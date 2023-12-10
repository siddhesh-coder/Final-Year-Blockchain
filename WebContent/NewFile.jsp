<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="jsnew/jquery-1.9.1.min.js"></script>
<script src="jsnew/highcharts.js"></script>
<script>
   
    <%ArrayList arr1 = new ArrayList();
			ArrayList arr2 = new ArrayList();
			ArrayList arr3 = new ArrayList();
			int filelength = 0;
			int a = 75;
			int b=25;
			
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
                text: 'Browser market shares in May, 2020',
                align: 'left'
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            accessibility: {
                point: {
                    valueSuffix: '%'
                }
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                    }
                }
            },
            series: [{
                name: 'Brands',
                colorByPoint: true,
                data: [{
                    name: 'Used Fund',
                    y: <%=a%>,
                    }, {
                    name: 'Not Used Fund',
                    y: <%=b%>
                }]
            }]
        		});
	});
</script>

</head>
<body>
	<div id="containerg"
		style="min-width: 900px; height: 500px; max-width: 350px; margin: 0 auto"></div>
	<br />
</body>
</html>