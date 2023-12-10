<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.connection.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="img/fav.png">
<!-- Author Meta -->
<meta name="author" content="colorlib">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>Block chain</title>

<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
	rel="stylesheet">
<!--
			CSS
			============================================= -->
<link rel="stylesheet" href="css/linearicons.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/nice-select.css">
<link rel="stylesheet" href="css/animate.min.css">
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/main.css">
<script type="text/javascript" src="jsnew/jquery-1.9.1.min.js"></script>
<script src="jsnew/highcharts.js"></script>
<script>
   
    <%
    String data ="";
	String msg ="";
	double a =0;
	double b = 0;
	double Fund_amount=0.0;
    double Transfer_amount=0.0;
    String process=request.getParameter("roll");
    String txt_tid=request.getParameter("txt_tid");
    if(process==null)
    {
    	 data = "Government Fund Tracking";
			msg = data + "State_Government";
			a = 0;
			b = 0;
    }
    else{
    data = "Government Fund Tracking";
    System.out.println(process);
			Connection con = Dbconn.conn();
double percentage=0.0;
			ResultSet rss;
			Statement sss = con.createStatement();
			String str = "SELECT * FROM tbl_tracker_info where Accecpt_status='"+process+"' and T_id='"+txt_tid+"'";
			rss = sss.executeQuery(str);
			if(rss.next()) {
				Fund_amount=rss.getDouble("Fund_amount");
				Transfer_amount=rss.getDouble("Transfer_amount");
				percentage=(double)(Transfer_amount/Fund_amount)*100;
				System.out.println(percentage);
			
			a = 100-percentage;
			b = 100-a;
			msg = data +"\t"+process;
			}
			else
			{
				
				data = "Government Fund Tracking";
				msg = data + "\t Result Not Available";
				a = 0;
				b = 0;
			}
    }
			
			%>
    
    // graph call code
    $(function () {
        $('#containerg').highcharts({
        	chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'pie'
            },
            title: {
                text: '<%=msg%>	',
								align : 'left'
							},
							tooltip : {
								pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
							},
							accessibility : {
								point : {
									valueSuffix : '%'
								}
							},
							plotOptions : {
								pie : {
									allowPointSelect : true,
									cursor : 'pointer',
									dataLabels : {
										enabled : true,
										format : '<b>{point.name}</b>: {point.percentage:.1f} %'
									}
								}
							},
							series : [ {
								name : 'Fund',
								colorByPoint : true,
								data : [ {
									name : 'Used Fund',
									y :
<%=b%>
	,
								}, {
									name : 'Not Used Fund',
									y :
<%=a%>
	} ]
							} ]
						});
	});
</script>
</head>
<body>
	<header id="header" id="home">

	<div class="container main-menu">
		<div class="row align-items-center justify-content-between d-flex">
			<div id="logo">
				<jsp:include page="title.jsp" />
			</div>
			<nav id="nav-menu-container">
			<ul class="nav-menu">
				<jsp:include page="Gmenu.jsp"></jsp:include>
			</ul>
			</nav>
			<!-- #nav-menu-container -->
		</div>
	</div>
	</header>
	<!-- #header -->


	<!-- start banner Area -->
	<section class="testomial-area section-gap" id="testimonail">
	<div>
		<div>
			<div>
				<div class="title text-center">
					<h1 class="mb-10 text-white">Update Request Status</h1>
					<br>
				</div>
				<form action="Government_Tracking_Page.jsp" method="post">
					<div align="center">

						<table border="1" width="90%">
						<tr>
								<td class="col-md-2"><label for="txt_Uname"
									style="color: White; font-size: 18px;">Transfer ID</label></td>
								<td class="col-md-6"><label for="txt_Uname"
									style="color: White; font-size: 18px;"><%=txt_tid %></label>
								<td class="col-md-6"><label for="txt_Uname"
									style="color: White; font-size: 18px;">Funds Process</label></td>
								<td class="col-md-6"><label for="txt_Uname"
									style="color: White; font-size: 18px;"><%=process %></label></td>
							</tr>
							<tr>
								<td class="col-md-2"><label for="txt_Uname"
									style="color: White; font-size: 18px;">Fund Amount</label></td>
								<td class="col-md-6"><label for="txt_Uname"
									style="color: White; font-size: 18px;"><%=Fund_amount %></label>
								<td class="col-md-6"><label for="txt_Uname"
									style="color: White; font-size: 18px;">Transfer_amount</label></td>
								<td class="col-md-6"><label for="txt_Uname"
									style="color: White; font-size: 18px;"><%=Transfer_amount %></label></td>
							</tr>

							<tr>
								<td class="col-md-2" colspan="5"><div id="containerg"
										style="min-width: 900px; height: 500px; max-width: 350px; margin: 0 auto"></div></td>
							</tr>

						</table>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>



	<!-- End banner Area -->


	<!-- start footer Area -->
	<footer class="footer-area" style="height:20px;">
	<p class="col-lg-8 col-sm-12 footer-text m-0">
		Copyright &copy;
		<script>
			document.write(new Date().getFullYear());
		</script>
		All rights reserved | This template is made with <i
			class="fa fa-heart-o" aria-hidden="true"></i> by <a
			href="https://colorlib.com" target="_blank">Colorlib</a>
	</p>

	</footer>
	<!-- End footer Area -->

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
	<script src="js/easing.min.js"></script>
	<script src="js/hoverIntent.js"></script>
	<script src="js/superfish.min.js"></script>
	<script src="js/mn-accordion.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery.circlechart.js"></script>
	<script src="js/mail-script.js"></script>
	<script src="js/main.js"></script>
</body>
</html>