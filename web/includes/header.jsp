<%
	String loginMessage = (String)request.getAttribute( "loginMessage" );

	if( loginMessage != null ){
		out.println( "<script>console.log(\""+loginMessage+"\"</script>" );
	}
%>

<nav class="navbar navbar-inverse" role="navigation">
	<div class="container-fluid" id="container-fluid-navbar">

		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">
				<img src="images/Logo-sm.png" id="logo-navbar-img">
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

			<ul class="nav navbar-nav">
				<li>
					<a href="index.jsp">Home</a>
				</li>
				<li>
					<a href="agenda.jsp">Agenda</a>
				</li>
				<li>
					<a href="tickets.jsp">Tickets</a>
				</li>
				<li>
					<a href="route.jsp">Route</a>
				</li>
				<li>
					<a href="contact.jsp">Contact</a>
				</li>
			</ul>

			<form class="navbar-form navbar-right" id="login-form-navbar">
				<div class="form-group">
					<input type="text" placeholder="username" id="username" class="form-control">
				</div>
				<div class="form-group">
					<input type="password" placeholder="Password" id="password" class="form-control">
				</div>
				<button type="submit" class="btn btn-success">Login</button>
			</form>

		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>
