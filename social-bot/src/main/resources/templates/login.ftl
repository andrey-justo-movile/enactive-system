<!DOCTYPE html>
<html ng-app="app">

  <head>
  	<meta charset="utf-8">
    <title>Sample "Enactive System using a bot as example" Application</title>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/login.css">
  </head>
  <body ng-controller="AppController as AppView" >
  	
  	<form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
										<div class="form-group">
											 <label class="sr-only" for="exampleInputEmail2">User Name</label>
											 <input type="email" class="form-control" id="exampleInputEmail2" placeholder="your user name" required>
										</div>
										<div class="form-group">
											 <label class="sr-only" for="exampleInputPassword2">Password</label>
											 <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required>
                                             <div class="help-block text-right"><a href="">Forget the password ?</a></div>
										</div>
										<div class="form-group">
											 <button type="submit" class="btn btn-primary btn-block">Sign up</button>
										</div>
										<div class="form-group">
											 <button type="submit" class="btn btn-primary btn-block">Sign in</button>
										</div>
	</form>
	
  	<!-- Dependencies -->
	<script src="angular.min.js"></script>
	<script src="moment.js"></script>
	<script src="angular-moment.min.js"></script>
	<script src="app.js"></script>

	</script>
  </body>
</html>