<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />

  <title>Login</title>

  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
  <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<div class="container">
    <div class="row">
      <div class="col-md-4 col-md-offset-4">
        <h1 id="ilogo">Springram</h1>
      </div>
    </div>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<form action="/login" method="post" class="form-horizontal">
				  <div class="form-group">
            <h2>Login</h2>
          </div>
          
				  <div class="form-group">
				    <input type="text" name="username" placeholder="Username" class="form-control"/>
				  </div>
				  
				  <div class="form-group">
				    <input type="password" name="password" placeholder="Password" class="form-control" />
				  </div>
				  
				  <div class="form-group">
				    <button type="submit" class="btn btn-primary">Login</button>
						<a href="/register" class="btn btn-default pull-right">Register</a>
				  </div>
				</form>
			</div>
		</div>
	</div>

	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>