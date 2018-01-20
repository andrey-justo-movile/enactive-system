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
  </head>
  <body ng-controller="AppController as AppView" ng-init="logged = false">
  	<input type="hidden" ng-model="logged" />
  	<#include "nav-bar.ftl">
  	<div ng-model="chat" class="chat-container show-hide" ng-show="logged">
  		<video id="video" class="video-interface" autoplay></video>
		<simple-chat id="chatbot-form" local-user="AppView.you" class="chat-view"
				messages="AppView.messages"
				send-function="AppView.sendMessage"
		        send-button-text="Send"
		        show-user-avatar="true"
		        show-composer="true"
		        composer-placeholder-text="Write your message here">
		</simple-chat>
    </div>
  	
  	<!-- this time we're not serving sockjs and stomp.js ourselves -->
  	<script type="text/javascript" src="//cdn.jsdelivr.net/sockjs/0.3.4/sockjs.min.js"></script>
  	<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
  	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  	<!-- Latest compiled and minified JavaScript -->
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  	<!-- Dependencies -->
  	<script src="//widget.cloudinary.com/global/all.js" type="text/javascript"></script>
  	<script type="text/javascript">
  		$("#picture").cloudinary_upload_widget({
        	        cloud_name: "hl5w3dog6", 
        	        secure: true,
        	        api_key: '952724658153242',
        	        cropping: 'server', 
        	        upload_preset: 'avatars',
        	        multiple:false,
        	        cropping_aspect_ratio: 1,
        	        max_image_width: 120,
        	        max_image_height: 120,
        	        button_class: 'btn btn-info form-control',
        	        button_caption: 'Upload Avatar Image',
        	        theme: 'white'
	            },
	            function(error, result) {
	            	if (error == null) {
	            		$("#picture-url").value = result.secure_url;
	            	}
	            	console.log(error, result);
	            }
        	);
  	</script>
	<script src="js/angular.min.js"></script>
	<script src="js/moment.js"></script>
	<script src="js/ui-bootstrap-tpls-2.5.0.min.js"></script>
	<script src="js/angular-moment.min.js"></script>
	<script src="js/angular-touch.min.js"></script>
	<script src="js/angular-animate.min.js"></script>
	<script src="js/app.js"></script>
	
	<!-- Simple Chat -->
	<script src="js/simple-chat/angular-simple-chat.min.js"></script>
  </body>
</html>