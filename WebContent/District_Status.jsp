<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.connection.Dbconn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<!-- Mobile Specific Meta -->
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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

		<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
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
				         <jsp:include page="Distmenu.jsp"></jsp:include>
				        </ul>
				      </nav><!-- #nav-menu-container -->		    		
			    	</div>
			    </div>
			  </header><!-- #header -->

						<!-- Start testomial Area -->
			<section class="testomial-area section-gap" id="testimonail">
				<div >
					<div >
						<div >
							<div class="title text-center">
								<h1 class="mb-10 text-white">Update Request Status</h1>
								<br>
							</div>
			<form role="form" method="post">
			<div align="center">
	    
			<table border="1" width="90%">
	       <tr>
			<th ><label for="txt_Pid" style="color:White;font-size:18px;">User Id.:</label></th> 
		    <th ><label for="txt_Pid" style="color:White;font-size:18px;">Funds Name:</label></th>
		    <th ><label for="txt_Pid" style="color:White;font-size:18px;">Funds Amount</label></th>
		      <th ><label for="txt_Pid" style="color:White;font-size:18px;">Funds Status</label></th>
		     <th ><label for="txt_Pid" style="color:White;font-size:18px;">Action</label></th>
		    </tr>
		    
	<%
	int id=0,pid=0;
	String name="";
	String amount="";
	String status="";
	Dbconn db=new Dbconn();
	Connection con=db.conn();
	Statement st=con.createStatement();
	Statement st1=con.createStatement();
	ResultSet rs=st.executeQuery("select * from user_request_funds where Government_status='Accept' and District_status='Sending' and State_Gov_status='Accept'");
	while(rs.next())
	{
		id=Integer.parseInt(rs.getString(1));
		name=rs.getString(2);
		
		status=rs.getString(4);
		ResultSet rs1=st1.executeQuery("select * from tbl_tracker_info where Accecpt_status='State_Government'");
		while(rs1.next())
		{	
			amount=rs1.getString(5);
		 
%>
			<tr>
			<td ><label for="txt_Pid" style="color:Black;font-size:18px;"><input type="radio" name="rd_group" value="<%=id %>" required> <%=id %></label></td>
			<td ><label for="txt_Pid" style="color:Black;font-size:18px;"><%=name %></label></td>
			<td><label for="txt_Pid" style="color:Black;font-size:18px;"><%=amount %></label></td>
			<td><label for="txt_Pid" style="color:Black;font-size:18px;"><%=status %></label></td>
			<td> <a href="Dist_Send_Status.jsp?txt_id=<%=id %>">
			<input type="button" class="btn btn-success" value="Update"></a>
			</td>
			 </tr>
<%
	}
	}
	%>
			</table>
			</div>
			</form>
						</div>
					</div>						
					</div>	
			</section>
			<!-- End testomial Area -->				
			
	

			<!-- start footer Area -->		
		<footer class="footer-area" style="height:20px;">
			<p class="col-lg-8 col-sm-12 footer-text m-0">Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a></p>

			</footer>
			<!-- End footer Area -->	

			<script src="js/vendor/jquery-2.2.4.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
			<script src="js/vendor/bootstrap.min.js"></script>			
			<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
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