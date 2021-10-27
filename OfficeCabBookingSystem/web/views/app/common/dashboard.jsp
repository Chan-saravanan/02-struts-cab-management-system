<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cab System - Dashboard</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type='text/javascript' src='views/app/common/scripts/dashboard.js'></script>
	<link rel='stylesheet' href='views/app/common/styles/dashboard.css'/>
</head>
<body>
	<div class='container'>
		<div class='header'>
			<div>Header	</div>
		</div>
		
		<div id='body' class='body'>
		<div>
			<a href='/user/manage'>User Management</a>
		</div>
		<div id = 'vehicleCardContainer' class='vehicleCardContainer'>
			<!-- <div class='vehicleCard'>
				<div class='vinfo'>
					Car-001(M) - Driver1
				</div>
				<div class='vseatInfo'>
					<div class='t-seats'>
						Total Seats:10
					</div>
					<div class='a-seats'>
						Available:10
					</div>
				</div>
				<div class='vBtn'>
					Book Seats
				</div>
			</div> -->
		</div>
		</div>
		<!-- The Modal -->
		<div id="myModal" class="modal">
		
		  <!-- Modal content -->
		  <div class="modal-content">
		    <span class="close">&times;</span>
		    <div>
		    	<div>
		    		<hidden id='hVehicleNo' name='hVehicleNo' value=''/>
		    		<hidden id='hDriverNo' name='hDriverNo' value=''/>
		    		<div>
		    			<div>
		    			
		    			</div>
		    			<div>
		    				<label for="cars">Choose a car:</label>
							<select name="seatCount" id="seatCount"></select>
		    			</div>
		    		</div>
		    		<div>
		    			<button id='seatBookBtn' name='seatBookBtn'>Book Seat</button>
		    		</div>
		    	</div>
		    </div>
		  </div>
		
		</div>
		<div class='load-more'>
			Load More
		</div>
	</div>
<script>
//Get the modal
var modal = document.getElementById("myModal");

//Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

//When the user clicks on <span> (x), close the modal
span.onclick = function() {
	modal.style.display = "none";
}

//When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
	if (event.target == modal) {
	 modal.style.display = "none";
	}
}
</script>
</body>
</html>