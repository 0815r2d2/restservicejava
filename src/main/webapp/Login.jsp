<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<div class="container">
			<div class="row">
				<div class="span3 hidden-phone"></div>
				<div class="span6" id="form-login">
					<form class="form-horizontal well" action="j_security_check" method="post">
						<fieldset>
							<legend>Login Form</legend>
							<div class="control-group">
								<div class="control-label">
									<label>Username</label>
								</div>
								<div class="controls">
									<input type="text" id="login" name="j_username" placeholder="your.name@youremail.com" class="input-large"/>
								</div>
							</div>
							
							<div class="control-group">
								<div class="control-label">
									<label>Password</label>
								</div>
								<div class="controls">
									<input type="password" id="password" name="j_password" placeholder="type your password" class="input-large"/>
								</div>
							</div>
	
							<div class="control-group">
								<div class="controls">
									<button type="submit" id="submit" class="btn btn-primary button-loading" data-loading-text="Loading...">Sign in</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
</html>