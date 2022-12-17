
var fetchCourseUrl = "getCoursesByDomain";

function fetchCoursesByDomain() {
	document.getElementById("courses_space").innerHTML = "Courses are on the way";
	//var method = "GET";
	var domain = document.getElementById("domain").value;

	var domain1 = $('#domain').value;
	console.log(domain1);
	
	var finalUrl = fetchCourseUrl + "?domain=" + domain;
	
	$.get(finalUrl, function(data) {

		console.log(data);

		document.getElementById("courses_space").innerHTML = data	;

	});
}