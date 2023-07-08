<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="./layout/header.jsp"%>
    <div id = "logo">
    <img src="resources/img/logo2.png" width="50%" height="40%">
     </div>
      
<div id = "borders"></div>
    <div class= "imgr">
     <img src="resources/img/logo4.png" width="50%" height="40%">
    </div>
    <div class = "imgr">
    <img src="resources/img/logo5.png" width="50%" height="40%">
    </div>
   

	
	<script >
	/* globals Chart:false, feather:false */

	(function () {
	  'use strict'

	  feather.replace()

	  // Graphs
	  var ctx = document.getElementById('myChart')
	  // eslint-disable-next-line no-unused-vars
	  var myChart = new Chart(ctx, {
	    type: 'line',
	    data: {
	      labels: [
	        'Sunday',
	        'Monday',
	        'Tuesday',
	        'Wednesday',
	        'Thursday',
	        'Friday',
	        'Saturday'
	      ],
	      datasets: [{
	        data: [
	          15339,
	          21345,
	          18483,
	          24003,
	          23489,
	          24092,
	          12034
	        ],
	        lineTension: 0,
	        backgroundColor: 'transparent',
	        borderColor: '#007bff',
	        borderWidth: 4,
	        pointBackgroundColor: '#007bff'
	      }]
	    },
	    options: {
	      scales: {
	        yAxes: [{
	          ticks: {
	            beginAtZero: false
	          }
	        }]
	      },
	      legend: {
	        display: false
	      }
	    }
	  })
	})()

	</script>
<%@ include file="./layout/footer.jsp"%>
<style>
#logo{
 margin-top:3%;
}
.imgr{
   margin-top:5%;
   }
#borders{
 margin-top:5%;
 border-bottom: solid 5px #4682B4;
}   
</style>


