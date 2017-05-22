<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>

<link href="/css/tasklistmain.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>
	<nav>
		<a class="brand-logo"><i class="material-icons">toc</i></a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a><i class="material-icons">add</i></a></li>
			<li><a><i class="material-icons">sort</i></a></li>
		</ul>
		<ul id="slide-out" class="side-nav fixed">
			<li><a href="#!">First Sidebar Link</a></li>
			<li><a href="#!">Second Sidebar Link</a></li>
		</ul>
		<a href="#" data-activates="slide-out" class="button-collapse"><i
			class="material-icons">menu</i></a>
	</nav>
	<div id="main">
		<h3>TEXT</h3>
	</div>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>

</body>
</html>