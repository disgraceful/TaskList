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