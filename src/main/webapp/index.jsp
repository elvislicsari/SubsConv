<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Subtitle synchronizer</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="author" content="Sub Synch">
<meta name="robots" content="all">
<meta name="MSSmartTagsPreventParsing" content="true">
<meta name="description" content="">
<meta name="keywords" content="">
<style type="text/css" media="all">
	@import "css/main.css";
	@import "css/fieldsets.css";
	@import "css/rounded_corners.css";
	@import "css/panel.css";
	@import "css/menu.css";
</style>
<script type="text/javascript" src="js/jquery-1.txt"></script>

<script type="text/javascript">
$(document).ready(function(){
	$(".trigger").click(function(){
		$(".panel").toggle("fast");
		$(this).toggleClass("active");
		return false;
	});
});
</script>
</head>
<body>
	<div id ="header">
		<ul class="menu">
			<li class="current">
				<a href="index.htm">sub synch</a>
			</li>
			<li>
				<a href="faq.htm">faq</a>
			</li>
			<li>
				<a href="about.htm">about</a>
			</li>
		</ul>
	</div>


	<div class="panel">
		<p>This short info panel is meant to give you a short quick tour through the SubSynch functionality. You will probably need this only once (or more likely don't need it at all).
		If you still have any doubts about how to use SubSynch to synchronize your subtitle or need anymore info, you can check the <a href="faq.htm">faq</a> page we have prepared.</p>
		<h3>Framerate and subtitle type</h3>
		<p><strong>Framerate from</strong> is the current framerate of the subtitle. My suggestion is to use all the other values from the drop-down box, that are not equal with the framerate into, and try to see if the downloaded subtitle works (<a href="faq.htm#framerateFrom">read more</a>).</p>
		<p><strong>Framerate into</strong> is the desired subtitle framerate. You can get this subtile from your movie player, or if you know it that's even better (<a href="faq.htm#framerateInto">read more</a>).</p>
		<p><strong>Subtitle type</strong> represents the format in which the content is stored in the subtitle file (<a href="faq.htm#subtitleType">read more</a>).</p>

		<h3>Translate subtitle</h3>
		<p>This is pretty straightforward to use, choose the language of the subtitle as <strong>language from</strong> and the desired language as <strong>language into</strong>.</p>
	</div>


	<div id="content">
		<form id="h3sForm" action="index.htm">
			<fieldset id="fieldset">
				<legend>
					Upload subtitle
				</legend>
				<label for="subtitle">
					Choose a subtitle file
					<input id="subtitle" name="subtitle" value="Card number" type="file">
				</label>
			</fieldset>

			<div id="fieldsetWithInfo">
			<a class="trigger" href="#">info</a>
			<fieldset id="fieldsetInInfo">
				<legend>
					Framerate and subtitle type
				</legend>
				<label for="framerateFrom">
					Choose framerate from
					<select name="framerateFrom" id="framerateFrom">
						<option value="0">Please select framerate</option>
						<option value="23.976">23.976</option>
						<option value="25.000">25.000</option>
						<option value="29.97">29.97</option>
					</select>
				</label>
				<label for="framerateInto">
					Choose framerate into
					<select name = "framerateInto" id="framerateInto">
						<option value="0">Please select framerate</option>
						<option value="23.976">23.976</option>
						<option value="25.000">25.000</option>
						<option value="29.97">29.97</option>
					</select>
				</label>

				<label for="subtitleType">
					Choose subtitle type
					<select name="subtitleType" id="subtitleType">
						<option value="0">...or leave unchanged</option>
						<option value="SubRip">SubRip</option>
						<option value="MultiDVD">MultiDVD</option>
					</select>
				</label>
			</fieldset>
			</div>
			<div style="clear:both;"> </div>
			<fieldset id="fieldset">
				<legend>
					Translate subtitle
				</legend>
				<label for="translateSelectFrom">
				Choose language from<br />
					<select id="translateSelectFrom" name = "languageFrom">
						<option value="none">...or don't translate</option>
						<option value="english">English</option>
						<option value="spanish">Spanish</option>
					</select>
				</label>
				<label for="translateSelectInto">
				Choose language into<br />
					<select id="translateSelectInto" name = "languageInto">
						<option value="none">...or don't translate</option>
						<option value="english">English</option>
						<option value="spanish">Spanish</option>
					</select>
				</label>
			</fieldset>
			<fieldset id="lastFieldset">
				<legend>
					Download subtitle
				</legend>
				<label>
					<input class="submit" name="download" value="Download subtitle" type="submit">
				</label>
			</fieldset>
		</form>
	</div>
<!-- END content -->

<div id="footer">
	<div id="footerImagesLeft">
		<p>design and programing by <a href="#">E</a>&<a href="#">C</a></p>
		<img src="images/appengine-silver-120x30.gif" alt="Powered by Google App Engine" />
	</div>
	<div id="footerImagesRight">
		<a href="http://twitter.com/share" class="twitter-share-button" data-count="horizontal">Tweet</a><script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
	</div>
</div>
</body></html>