<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<title>Login Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<link href="/css/style2.css" rel="stylesheet" type="text/css" />
</head>
<body style= "background-image: url('../../images/bg.jpeg'); background-size:cover;">

<br><br><br><br>
<div class="signup-form">
    <form action="userForm" method="post" style="background: rgba(0, 0, 0, 0.71);">
		<h2 style="color: antiquewhite"> Admin Login</h2>
        <div class="form-group">
			<div class="row">
				<div class="col-xs-6" ><input type="text" class="form-control" name="aId" placeholder="Admin ID" required="required" style="width: 337px;"></div>
			</div>        	
        </div>
		<div class="form-group">
            <input type="password" class="form-control" name="aPassword" placeholder="Password" required="required">
        </div>     
		<div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">Login</button>
        </div>
    </form>
  </div>
<%-- ${msg} --%>
${msg1}
</body>
</html>