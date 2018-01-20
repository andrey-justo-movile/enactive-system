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
  	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    	<div class="container-fluid">
			<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			</button>
				<a class="navbar-brand" href="">Enactive ChatBots</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="">Home</a></li>
					<li><a href="">About</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right" ng-hide="logged">
                    <li class="dropdown" ng-hide="logged">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Register <span class="caret"></span></a>
                        <ul class="dropdown-menu dropdown-lr animated flipInX" role="menu">
                            <div class="col-lg-12">
                                <div class="text-center"><h3><b>Register</b></h3></div>
                                <form id="sign-up-form" role="form" autocomplete="off">
                                	<div class="form-group">
										<input type="text" ng-model="name" name="name" id="name" tabindex="1" class="form-control" placeholder="Display Name" value="" required>
									</div>
									<div class="form-group">
										<input type="email" ng-model="registerEmail" name="email" id="email" tabindex="1" class="form-control" placeholder="Email Address" value="" required>
									</div>
									<div class="form-group">
										<input type="text" ng-model="registerUsername" name="username" id="username-signup" tabindex="1" class="form-control" placeholder="Username" value="" required>
									</div>
									<div class="form-group">
										<input type="password" ng-model="registerPassword" name="password" id="password-signup" tabindex="2" class="form-control" placeholder="Password" required>
									</div>
									<div class="form-group">
										<input type="password" ng-model="registerConfirmPassword" name="confirm-password" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password" required>
									</div>
									<div class="form-group">
										<input id="picture" ng-model="picture" ng-click="uploadAvatar()" name="file" type="button" class="btn btn-info" value="Upload Avatar Photo" required/>
										<input id="picture-url" type="hidden" />
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-xs-6 col-xs-offset-3">
												<input type="input" ng-click="signUp()" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-info" value="Register Now">
											</div>
										</div>
									</li>
									</form>
                            </div>
                        </ul>
                    </li>
                    <li class="dropdown" ng-hide="logged">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Log In <span class="caret"></span></a>
                        <ul class="dropdown-menu dropdown-lr animated slideInRight" role="menu">
                            <div class="col-lg-12">
                                <div class="text-center"><h3><b>Log In</b></h3></div>
                                <form id="sign-in-form" role="form" autocomplete="off">
                                    <div class="form-group">
                                        <label for="username">Username</label>
                                        <input type="text" ng-model="username" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="" autocomplete="off" required>
                                    </div>

                                    <div class="form-group">
                                        <label for="password">Password</label>
                                        <input type="password" ng-model="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password" autocomplete="off" required>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-xs-5 pull-right">
                                                <input type="input" ng-click="signUp()" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-success btn btn-primary btn-block" value="Log In">
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </ul>
                    </li>
                </ul>
			</div>
		</div>
	</nav>
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