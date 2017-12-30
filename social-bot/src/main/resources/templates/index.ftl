<!DOCTYPE html>
<html ng-app="app">

  <head>
  	<meta charset="utf-8">
    <title>Sample "Enactive System using a bot as example" Application</title>
    <link rel="stylesheet" href="css/simple-chat/angular-simple-chat.min.css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/login.css">
  </head>
  <body ng-controller="AppController as AppView" >
	<form ng-model="form-login" class="form" role="form" method="post" action="login" accept-charset="UTF-8">
		<div class="form-group">
			 <label class="sr-only" for="exampleInputEmail2">User Name</label>
			 <input ng-model="user_name" type="email" class="form-control" id="exampleInputEmail2" placeholder="your user name" required>
		</div>
		<div class="form-group">
			 <label class="sr-only" for="exampleInputPassword2">Password</label>
			 <input ng-model="password" type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required>
             <div class="help-block text-right"><a href="">Forget the password ?</a></div>
		</div>
		<div class="form-group">
			 <button type="submit" class="btn btn-primary btn-block">Sign up</button>
		</div>
		<div class="form-group">
			 <button type="submit" class="btn btn-primary btn-block">Sign in</button>
		</div>
	</form>
  	<div ng-model="chat" class="chat-container" style="display: none;">
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