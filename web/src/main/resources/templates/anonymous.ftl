<!DOCTYPE html>
<html ng-app="app">

  <head>
  	<meta charset="utf-8">
    <title>Sample "Enactive System using a bot as example" Application</title>
    <link rel="stylesheet" href="css/simple-chat/angular-simple-chat.min.css">
    <link rel="stylesheet" href="css/jquery/jquery.fileupload-ui.css">
    <link rel="stylesheet" href="css/jquery/jquery.fileupload.css">
    <link rel="stylesheet" href="css/simple-chat/angular-simple-chat.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="css/app.css">
    <link rel="stylesheet" href="css/chat.css">
    <script src="js/webgl/avatar.js"></script>
    <script type="text/javascript" language="javascript">
        var gameInstance = UnityLoader.instantiate("avatarContainer", "js/webgl/build.json");
    </script>
  </head>
  <body ng-controller="AppController as AppView" ng-init="logged = false; tab = 'home'">
  	<input type="hidden" ng-model="logged">
    <input id="anonymous" type="hidden" ng-click="anonymous()" tabindex="4">
    <script type="text/javascript" language="javascript">
        $("#anonymous").click();
    </script>
  	<div class="content-page">
	  	<div class="ng-cloak" ng-show="logged">
			<#include "chat.ftl">
	  	</div>
  	</div>
  	<!-- this time we're not serving sockjs and stomp.js ourselves -->
  	<script type="text/javascript" src="//cdn.jsdelivr.net/sockjs/0.3.4/sockjs.min.js"></script>
  	<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
  	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  	<!-- Latest compiled and minified JavaScript -->
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  	<script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>
  	<script src="https://webrtc.github.io/adapter/adapter-latest.js"></script>
	<script src="js/angular.min.js"></script>
	<script src="js/moment.js"></script>
	<script src="js/ui-bootstrap-tpls-2.5.0.min.js"></script>
	<script src="js/angular-moment.min.js"></script>
	<script src="js/angular-touch.min.js"></script>
	<script src="js/angular-animate.min.js"></script>
	<script src="js/app.js"></script>
	<script src="js/chat.js"></script>
	
	<!-- Simple Chat -->
	<script src="js/simple-chat/angular-simple-chat.min.js"></script>
  </body>
</html>