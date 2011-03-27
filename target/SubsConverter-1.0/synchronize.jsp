<%@page import="com.google.api.translate.Language"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>SubSynch - Subtitle Synchronizer</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="author" content="SubSynch">
<meta name="robots" content="all">
<meta name="MSSmartTagsPreventParsing" content="true">
<meta name="description" content="SubSynch - Subtitle Synchronizer is an online subtitle tool meant to help you synchronize your subtitle with a movie.">
<meta name="keywords" content="subsynch, subtitle synchronizer, synchronize subtitle, synchronize framerate, convert subtitle, translate subtitle, change subtitle, change subtitle type, change subtitle framerate">
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
	$("#trigger").click(function(){
		$(".panel").toggle("fast");
		$(this).toggleClass("active");
		return false;
	});
	$("body").click(function(e){
		var obj = (e.target ? e.target : e.srcElement);
		if (obj.tagName == 'A' || obj.tagName == 'SELECT' || obj.tagName == 'INPUT') return true;
		$(".panel").hide("fast");
		//alert($("#trigger").attr("class"));
		$("#trigger").attr("class", "trigger");
		return false;
	});
});
</script>
</head>
<body>
    <div id ="header">
		<ul class="menu">
			<li class="current">
				<a href="synchronize">sub synch</a>
			</li>
			<li>
				<a href="faq">faq</a>
			</li>
			<li>
				<a href="about">about</a>
			</li>
		</ul>
	</div>


	<div class="panel">
	    <h3>SubSynch - Subtitle Synchronizer</h3>
	    <!--<p id="internalCloseTrigger"><a id="triggerInternal" href="#">Close</a></p>-->
		<p>Subtitle Synchronizer is an online subtitle tool meant to help you synchronize your subtitle with a movie. This short info panel is meant to give you a short quick tour through the Sub Synch functionality. You will probably need this only once (or more likely don't need it at all).
		If you still have any doubts about how to use SubSynch to synchronize your subtitle or need anymore info, you can check the subtitle synchronizer <a href="faq">faq</a> page we have prepared.</p>
		<h3>Synchronize subtitle</h3>
		<p><strong>Framerate from</strong> is the current framerate of the subtitle. My suggestion is to use all the other values from the drop-down box, that are not equal with the framerate into, and try to see if the downloaded subtitle works (<a href="faq#framerateFrom">see subsynch faq page</a>).</p>
		<p><strong>Framerate into</strong> is the desired subtitle framerate. You can get this subtitle from your movie player, or if you know it that's even better (<a href="faq#framerateInto">see subsynch faq page</a>).</p>
		<p><strong>Subtitle type</strong> represents the format in which the content is stored in the subtitle file (<a href="faq#subtitleType">see subsynch faq page</a>).</p>

		<h3>Translate subtitle</h3>
		<p>This is pretty straightforward to use, choose the language of the subtitle as <strong>language from</strong> and the desired language as <strong>language into</strong>.</p>
	</div>

     <%
        if (request.getAttribute("messages") != null) {
            List<String> messages = (List<String>) request.getAttribute("messages");
     %>
            <div id="messages">
                <div id="messagesHolder">
                    <%
                    for (String message : messages) {
                        out.println("<p>"+message+"</p>");
                    }
                    %>
                </div>
            </div>
    <%
        }
    %>

	<div id="content">
		<form id="h3sForm" action="synchronize" method="POST" enctype="multipart/form-data">
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
			<a class="trigger" id="trigger" href="#">info</a>
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
						<option value="none">...or leave unchanged</option>
						<option value="SubRip">SubRip</option>
						<option value="MicroDVD">MicroDVD</option>
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
                        <%
                            if (request.getAttribute("languages") != null){
                                Language[] languages = (Language[]) request.getAttribute("languages");
                                String name = "";
                                for (int i=0; i< languages.length; i++) {
                                    name = languages[i].name();
                                    if (name != null && name != "" && !name.equals("") && !name.equals("AUTO_DETECT")) {
                                        out.println("<option value='"+name+"'>"+name+"</option>");
                                    }
                                }
                            }
                        %>
					</select>
				</label>
				<label for="translateSelectInto">
				Choose language into<br />
					<select id="translateSelectInto" name = "languageInto">
						<option value="none">...or don't translate</option>
						<%
                            if (request.getAttribute("languages") != null){
                                Language[] languages = (Language[]) request.getAttribute("languages");
                                String name = "";
                                for (int i=0; i< languages.length; i++) {
                                    name = languages[i].name();
                                    if (name != null && name != "" && !name.equals("") && !name.equals("AUTO_DETECT")) {
                                        out.println("<option value='"+name+"'>"+name+"</option>");
                                    }
                                }
                            }
                        %>
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

<jsp:include page="footer.jsp" />

</body></html>