<!DOCTYPE html>
<html ng-app="app">

  <head>
  	<meta charset="utf-8">
    <title>Sample "Enactive System using a bot as example" Application</title>
    <link rel="stylesheet" href="css/simple-chat/angular-simple-chat.min.css">
    <link rel="stylesheet" href="css/app.css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
  </head>
  <body ng-controller="AppController as AppView" ng-init="logged = false">
  	<input type="hidden" ng-model="logged" />
	<form id="login-dp" class="form" role="form" ng-hide="logged">
		<div class="form-group">
			 <label class="sr-only" for="user_name">User Name</label>
			 <input ng-model="user_name" class="form-control" id="user_name" placeholder="your user name" required>
		</div>
		<div class="form-group">
			 <label class="sr-only .social-buttons" for="password">Password</label>
			 <input ng-model="password" type="password" class="form-control" id="password" placeholder="Password" required>
		</div>
		<div class="form-group">
			 <button id="sing-up" ng-click="signUp()" type="input" class="btn btn-primary social-buttons btn-block">Sign up</button>
		</div>
		<div class="form-group">
			 <button id="sign-in" ng-click="signIn()" type="input" class="btn btn-primary social-buttons btn-block">Sign in</button>
		</div>
	</form>
  	<div ng-model="chat" class="chat-container content-area show-hide" ng-show="logged" hidden>
  		<video id="video" width="640" height="480" autoplay></video>
		<simple-chat id="chatbot-form" local-user="AppView.you"
				messages="AppView.messages"
				send-function="AppView.sendMessage"
		        send-button-text="Send"
		        show-user-avatar="true"
		        show-composer="true"
		        composer-placeholder-text="Write your message here" style="height: 100vh;">
		</simple-chat>
    </div>
  	
  	<!-- this time we're not serving sockjs and stomp.js ourselves -->
  	<script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1.11.2/jquery.min.js"></script>
  	<script type="text/javascript" src="//cdn.jsdelivr.net/sockjs/0.3.4/sockjs.min.js"></script>
  	<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
  	<!-- Dependencies -->
	<script src="js/angular.min.js"></script>
	<script src="js/moment.js"></script>
	<script src="js/angular-moment.min.js"></script>
	<script src="js/app.js"></script>

	<!-- Simple Chat -->
	<script src="js/simple-chat/angular-simple-chat.min.js"></script>
		
	</script>
  </body>
</html>