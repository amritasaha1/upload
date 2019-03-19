/*$(document).ready(function() {
    $.ajax({
        url: "http://rest-service.guides.spring.io/greeting"
    }).then(function(data) {
       $('.greeting-id').append(data.id);
       $('.greeting-content').append(data.content);
    });
});*/
function myFunction() {
	 $.ajax({
	        url: "http://18.223.68.150:8080/DocumentService/service/create/multichannel"
	    }).then(function(data) {
	       $('.greeting-id').append(data);
	       //$('.greeting-content').append(data.content);
	    });
}