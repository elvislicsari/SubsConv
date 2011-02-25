<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<head>
<title>Sub Synch - Faq</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="author" content="Sub Synch">
<meta name="robots" content="all">
<meta name="MSSmartTagsPreventParsing" content="true">
<meta name="description" content="">
<meta name="keywords" content="subtitle, framerate, synchronize, subtitle type, synchronize subtitle, synchronize framerate, convert subtitle, translate subtitle, change subtitle, change subtitle type, change subtitle framerate, SubRip, subtitles, Sub Synch, MicroDVD">
<style type="text/css" media="all">
	@import "css/main.css";
	@import "css/fieldsets.css";
	@import "css/rounded_corners.css";
	@import "css/panel.css";
	@import "css/menu.css";
</style>
</head>
<body>
	<div id ="header">
		<ul class="menu">
			<li>
				<a href="synchronize">sub synch</a>
			</li>
			<li class="current">
				<a href="faq">faq</a>
			</li>
			<li>
				<a href="about">about</a>
			</li>

		</ul>
	</div>


	<div id="content">
		<h2>Faq</h2>

		<h3><a name="framerateFrom"></a>What does framerate from means ?</h3>
		<p>Framerate from is the current framerate of the subtitle. If you want to use SubSynch to synchronize correctly a subtitle, then, most probably the subtitle's framerate is not the correct one. There is no way you can know for sure what is the correct framerate of the subtitle. There are many cases when you download a subtitle from a site where the subtitle framerate is specified, but the subtitle doesn't work with the movie, although the subtitle's framerate is the same with the movie's. So if you want to synchronize your subtitle correctly, you have 2 options here: either you're like me, not a very patience person, and you try the other framerates values that are not equal with framerate into, or you can pay attention and compare the movie with the subtitle. If in the movie a line is being said, let's say at 00:10:00 and in the subtitle file the same line is mapped at 00:09:58, then you should choose a smaller value for framerate from than the value of framerate into. And vice-versa.</p>

		<h3><a name="framerateInto"></a>What does framerate into means?</h3>
		<p>Framerate into represents the desired framerate afer which your subtitle will be synchronized. If right now you have a movie player opened and you're trying to find a good subtitle for the movie, then the framerate into is the framerate of the movie. Many movie players show you this framerate in the main player window. 99% of the cases it's one of these values: 23.976, 25.000 or 29.97. If the movie player is indicating another framerate, then Sub Synch is currently unable to help you synchronize the subtitle. In this case leave us a feedback on Twitter or Facebook.</p>

		<h3><a name="subtitleType"></a>Why would i want to change the subtitle type ?</h3>
		<p>I actually have no idea why would you want to do such a thing, but if you really want to, you can. A friend of mine told me that there are some movie players for which some subtitle types do not work. I don't know which movie players are these, or in which era were they used, but we have included the functionality just in case.</p>

		<h3>What does SubRip means?</h3>
		<p>SubRip is the most encountered type of subtitle, at least from what i have seen lately. You can read more on Wikipedia if you are really that interested. The SubRip subtitles have the .srt extension and the subtitle content is being hold like in the example below:<br />
		771<br />
		01:06:48,103 --> 01:06:50,072<br />
		You talking to me?<br />
		<br />
		772<br />
		01:06:52,341 --> 01:06:55,711<br />
		Then who the hell else are you talking to? You talking to me?
		</p>

		<h3>What does MultiDVD means?</h3>
		<p>It's another type of subtitle, often encountered on any subtitles site. The subtitles files have the extension .sub and the content is stored differently than the SubRip files.Check it out:<br />
		{11270}{11335}More bla bla
		</p>

		<h3>How do i translate from one language into another?</h3>
		<p>This should pretty straight forward, just select the language of the subtitle as language from and the language in which you want your subtitle translated as language into. There is not need to synchronize your subtitle, if you want only to translate it from one language into another.</p>

		<h3>What should i do with the synchronized subtitle?</h3>
		<p>You can do whatever you want with it (mainly use it for the movie), but if the synchronized subtitle is working correctly it would be a good gesture to upload it to a subtitle site so someone else can use it in the future.</p>

		<h3>How do i ask for new features ?</h3>
		<p>Use Twitter and/or Facebook and tell us whatever is on your mind. We don't promise that the feature will be available in the near future, but if enough people are requesting the same feature we will do our best to include it.</p>

		<h3>I have synchronized my subtitle but it still doesn't work, what is the problem ?</h3>
		<p>We know that Sub Synch might not be able to synchronize correctly all subtitles out there, but we want and we can improve it. If you have a subtitle for which the tool was unable to help you with, let us know on Twitter or Facebook.</p>

		<h3>How to change only the framerate ?</h3>
		<p>If you need to change only the framerate of the subtitle, then select only the framerate from and the framerate into and press the Download button</p>

		<h3>How to change only the subtitle's type ?</h3>
		<p>If you want to change only the subtitle type, then you have to select for framerate from and framerate into the same value (which has to be equal with the correct subtitle framerate), then choose the desired subtitle type and press Download button.</p>

	</div>

	<jsp:include page="footer.jsp" />
</body></html>