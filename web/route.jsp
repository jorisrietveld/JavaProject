<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="includes/head.jsp"%>
	<title></title>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
	<script type="text/javascript">
		var directionDisplay;
		var directionsService = new google.maps.DirectionsService();
		function initialize() {
			var latlng = new google.maps.LatLng(53.13751,7.04105);
			directionsDisplay = new google.maps.DirectionsRenderer();
			var myOptions = {
				zoom: 14,
				center: latlng,
				mapTypeId: google.maps.MapTypeId.ROADMAP,
				mapTypeControl: false
			};
			var map = new google.maps.Map(document.getElementById("map_canvas"),myOptions);
			directionsDisplay.setMap(map);
			directionsDisplay.setPanel(document.getElementById("directionsPanel"));
			var marker = new google.maps.Marker({
				position: latlng,
				map: map,
				title:"My location"
			});
		}
		function calcRoute() {
			var start = document.getElementById("routeStart").value;
			var end = "51.764696,5.526042";
			var request = {
				origin:start,
				destination:end,
				travelMode: google.maps.DirectionsTravelMode.DRIVING
			};
			directionsService.route(request, function(response, status) {
				if (status == google.maps.DirectionsStatus.OK) {
					directionsDisplay.setDirections(response);
				}
			});
		}
	</script>
</head>
<body onload="initialize()">
	<% if( session.getAttribute("session") == null ){ %>
	<%@include file="includes/header.jsp"%>
	<% }else{ %>
	<%@include file="includes/header-logged-in.jsp"%>
	<% } %>
	<div class="container">

			<div id="map_canvas" class="jumbotron" style="width:100%; height:400px"></div>
			<form action="" onsubmit="calcRoute();return false;" id="routeForm">
				<input placeholder="Uw Adres" class="input-lg col-lg-9" type="text" id="routeStart" value="">
				<input class="btn btn-lg btn-info col-lg-3" type="submit" value="Route plannen">
			</form>
			<div id="directionsPanel" style="background-color: gainsboro;"></div>
		</div>


</body>
</html>
