<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/jquery.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>

<div id="content">
	<jsp:include page="leftColumn.jsp"/>
	<div id="mainWindow">
		<form action="index.html" method="post" enctype="multipart/form-data">
		<!-- tab panes -->
		<div id="panes">
			<div style="display: block;">
				<h1>Upload Subtitle - Step 1</h1>
				<p class="more">
					Choose file: <input type="file" name="subtitle">
				</p>
				<span class="stepNavigationLinks">
					<a class="nextStep" href="#2">Next step</a>
				</span>
			</div>

			<div style="display: none;">
				<h1>Change Framerate - Step 2</h1>

				<p class="more">
					Select framerate from:
					<select name="framerateFrom">
						<option value="0">Please select</option>
						<option value="23976">23976</option>
						<option value="25000">25000</option>
						<option value="29000">29000</option>
					</select>
				</p>
				<p class="more">
					Select framerate into:
					<select name="framerateInto">
						<option value="0">Please select</option>
						<option value="23976">23976</option>
						<option value="25000">25000</option>
						<option value="29000">29000</option>
					</select>
				</p>

				<span class="stepNavigationLinks">
					<a class="previousStep" href="#1">Previous step</a>
					<a class="nextStep" href="#3">Next step</a>
				</span>
			</div>

			<div style="display: none;">
				<!--<img src="images/1_m.jpg">-->
				<h1>Translate</h1>
				<p class="more">
					Feature coming soon
				</p>
				<span class="stepNavigationLinks">
					<a class="previousStep" href="#2">Previous step</a>
					<a class="nextStep" href="#4">Next step</a>
				</span>
			</div>

			<div style="display: none;">
				<img src="images/1_m.jpg">
				<h1>Checkout</h1>
				<p class="more">
					<input type="submit" name="downloadSubtitle" value="Download subtitle">
				</p>
				<span class="stepNavigationLinks">
					<a class="previousStep" href="#3">Previous step</a>
				</span>
			</div>
		</div>
		</form>
		<br clear="all">

		<!-- navigator -->
		<div id="nav">
			<ul>
				<li>
					<a class="current" href="#1">
						<img src="images/1_s.jpg">
						<strong>Step 1</strong>
						Upload Subtitle
					</a>
				</li>
				<li>
					<a class="" href="#2">
						<img src="images/1_s.jpg">
						<strong>Step 2</strong>
						Change Framerate
					</a>
				</li>
				<li>
					<a class="" href="#3">
						<img src="images/1_s.jpg">
						<strong>Step 3</strong>
						Translate Subtitle
					</a>
				</li>
				<li>
					<a class="" href="#4">
						<img src="images/1_s.jpg">
						<strong>Step 4</strong>
						Checkout
					</a>
				</li>
			</ul>
		</div>

		<br clear="all">
		<script>
		$(function() {
			$("#nav ul").tabs("#panes > div", {effect: 'fade', fadeOutSpeed: 200});
		});
		</script>
	</div>

	<jsp:include page="rightColumn.jsp"/>
</div>

<div class="spacer"></div>

<jsp:include page="footer.jsp"/>
</div>
</body>
</html>