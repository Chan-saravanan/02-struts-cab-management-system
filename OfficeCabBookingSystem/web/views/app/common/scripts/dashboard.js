$(document).ready(function(){
	$(document).on("click", '.vBtn', function(){
		showBookingScreen(this);
	});

	$('#seatBookBtn').click(function(){
		bookSeats();
	});

	loadVehicleInformation();
});

function loadVehicleInformation(){
	fetch(`${window.location.href}vehicleMgmt`)
	.then((response)=>{
		return response.json();
	})
	.then((response)=>{
		buildVehicleCard(response);
	})
}

function buildVehicleCard(vehicleInfo){
	console.log('vehicleInfo', vehicleInfo);
	const {vehicleInfoList}= vehicleInfo;
	const result = vehicleInfoList.map((item, index)=>createCard(item, index));
	document.querySelector('#vehicleCardContainer').innerHTML = result.join('');
}

function createCard(info, index){
	console.log('Cab Info', info);
	const {driverInfo} = info;
	const cAvail = info.available === true?'A':'N';
	const dAvail = driverInfo.available === true?'A':'N';
	
	return `<div id='card${index}' class='vehicleCard'>
	<div class='vinfo'>
		${info.vehicleNo}[${cAvail}]  -  ${driverInfo.driverName}[${dAvail}]
	</div>
	<div class='vseatInfo'>
		<div class='t-seats'>
			Total Seats:${info.totalSeats}
		</div>
		<div class='a-seats'>
			Available:${info.totalSeats - info.bookedSeats}
		</div>
	</div>
	<div id='${index}' vehicleNo ='${info.vehicleNo}' class='vBtn' >
		Book Seats
	</div>
</div>`;
}

function showBookingScreen(ref){
	const vehicleNumber = $(ref).attr("vehicleNo");
	const formData = new FormData();
	formData.append('vehicleNo', vehicleNumber.toString());
  
	fetch(`${window.location.href}getVehicleInfo`,{
		method:'POST',
		body:formData//data="menuName=index"
	})
	.then((response)=>{
	  if(!response.ok){
		  console.log('response is not okay!');
		  return;
	  }
	  return response.json();
	}).then((response)=>{
		const {driverName, driverNo, vehicleNo, size} = response;
		$('#hVehicleNo').val(vehicleNo);
		$('#hDriverNo').val(driverNo);
		prepareBookingSeatCountOptions(response);
		const modal = document.getElementById("myModal");
		modal.style.display = "block";
	}).catch((err)=>{
		console.log('Error', err);
	});
}

function prepareBookingSeatCountOptions(vehicleInfo){
	const {bookedSeats, totalSeats} = vehicleInfo;
	const availableSeats = totalSeats - bookedSeats;
	const seatSelect = document.getElementById('seatCount');
	
	$("#seatCount").empty();
	var option = document.createElement("option");
	option.value = '0';
	option.text = '0 seat';
	
	//create the new options!
	const options = Array.from({length: availableSeats}, (v, i) => i).map((item, index)=>{
		var option = document.createElement("option");
		option.value = `${index+1}`
		option.text = `${index+1} ${(index+1 === 1)?'seat':'seats'}`;
		return option;
	});
	options.forEach(item=>seatSelect.appendChild(item));
}

function bookSeats(){
	const 
		vehicleNo = $('#hVehicleNo').val(),
		drivcerNo = $('#hDriverNo').val(),
		totalSeats = $('#seatCount').val();
	
	if(totalSeats === 0)
		alert(`Select Seat's count greater than 0!`);
	
	const formData = new FormData();
	formData.append('vehicleNo', vehicleNo);
	formData.append('driverNo', drivcerNo);
	formData.append('noOfSeats', totalSeats);
	
	fetch(`${window.location.href}bookSeats`, {
		method:'POST',
		body:formData
	}).then(response=>{
		if(!response.ok)
			console.log('Problem in response!');
		console.log('response1', response)
		return response.json()
	}).then((response)=>{
		console.log('response2', response)
		refreshVehicleCardContainer();
	});
}


function refreshVehicleCardContainer(){
	const modal = document.getElementById("myModal");
	modal.style.display = "none";
	loadVehicleInformation();
}