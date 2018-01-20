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