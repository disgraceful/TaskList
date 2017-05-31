$(document).ready(function() {
                $('.datepicker').pickadate({
                    selectMonths: true,
                    selectYears: 15
                });
            });
			
function loginToSignUp() {
	var elem = document.getElementById("login");
	var confirm = document.getElementById("confirm");
	if (elem.firstChild.data == "Login") {
		elem.firstChild.data = "Sign Up";
		confirm.style.display = "none";
	} else {
		elem.firstChild.data = "Login";
		confirm.style.display = "block";
	}
}

function closeSideBar() {
	var sidebar = document.getElementById("sidebar");
	var main = document.getElementById("main");
	if (sidebar.style.display == "none") {
		sidebar.style.display = "block";
		main.style.marginLeft = "20%";
	} else {
		sidebar.style.display = "none";
		main.style.marginLeft = "0px";
	}
}

function addProject() {
	var main = document.getElementById("main");
	var proj = document.getElementById("create_proj");
	var barwidth = main.clientWidth;
	var docwidth = window.innerWidth;
	var icons = document.getElementById("icon_con");
	var i;
	if (barwidth == docwidth) {
		main.style.width="60%";
		proj.style.display="block";
		icons.style.display="none";
		proj.style.zIndex="100";
	} else {
		proj.style.position="fixed";
		main.style.width="100%";
		proj.style.display="none";
		icons.style.display="block";
		proj.style.zIndex="-1";
	}
}

function showCreateTask(){
		var taskDiv = document.getElementById("create_task");
		if(taskDiv.style.display=="none"){
			taskDiv.style.display="block";
		}else{
			taskDiv.style.display="none";
		}

}

