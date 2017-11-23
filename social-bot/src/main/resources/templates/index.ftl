<!DOCTYPE html>
<html ng-app="app">

  <head>
  	<meta charset="utf-8">
    <title>Sample "Enactive System using a bot as example" Application</title>
    <link rel="stylesheet" href="simple-chat/angular-simple-chat.min.css">
  </head>
  <body ng-controller="AppController as AppView" >
  	<div class="chat-container">
		<simple-chat id="chatbot-form" local-user="AppView.you"
				messages="AppView.messages"
				send-function="AppView.sendMessage"
		        send-button-text="Send"
		        show-user-avatar="true"
		        show-composer="true"
		        composer-placeholder-text="Write your message here">
		</simple-chat>
    </div>
  	
  	<!-- this time we're not serving sockjs and stomp.js ourselves -->
  	<script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1.11.2/jquery.min.js"></script>
  	<script type="text/javascript" src="//cdn.jsdelivr.net/sockjs/0.3.4/sockjs.min.js"></script>
  	<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
  	<!-- Dependencies -->
	<script src="angular.min.js"></script>
	<script src="moment.js"></script>
	<script src="angular-moment.min.js"></script>
	<script src="app.js"></script>

	<!-- Simple Chat -->
	<script src="simple-chat/angular-simple-chat.min.js"></script>
    <script type="text/javascript">
		
	</script>
  </body>
</html>