$(document).ready(function() {
	$('.datepicker').pickadate({
		selectMonths : true,
		selectYears : 15
	});
});

$("#password").on("focusout", function(e) {
	if ($(this).val() != $("#confirmPassword").val()) {
		$("#confirmPassword").removeClass("valid").addClass("invalid");
	} else {
		$("#confirmPassword").removeClass("invalid").addClass("valid");
	}
});

$("#confirmPassword").on("keyup", function(e) {
	if ($("#password").val() != $(this).val()) {
		$(this).removeClass("valid").addClass("invalid");
	} else {
		$(this).removeClass("invalid").addClass("valid");
	}
});

$('.show_tasks').click(function(){
	    $.ajax({
	        type: "GET",
	        contentType: "application/json",
	        url: "/tasks/today",
	        dataType: 'json',
	        cache: false,
	        timeout: 600000,
	        success: function (data) { 
	        	var json = "<ul class='mycontent'>";
	        	console.log(data);
	        	$.each(data, function(i){	
					json+="<li><a style='padding: 15px;'>"
					json+=data[i].name;
					json+="</a><div id='icon_con' class='icon_container'><a style='padding: 0px; display: inline-block'><i class='material-icons right'>mode_edit</i></a><a style='padding: 0px; display: inline-block'><i class='material-icons right'>delete</i></a></div></li>";
	        	});
				json+="</ul>";
				$('#main').html(json);
	        },
	        error: function (e) {
	            console.log("ERROR : ", e);
	        }
	    });
});