<div class="modal fade login-modal" id="login-modal" tabindex="-1" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">Error</h4>
			</div>
			<div class="modal-body">
				Er is geen gebruiker gevondem met de door u ingevulde gegevens.
			</div>
		</div>
	</div>
</div>

<div class="modal fade register-modal" tabindex="-1" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="register-form" name="register-form" class="form">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">Registreeren</h4>
			</div>
			<div class="modal-body">

					<div class="form-group" id="register-form-group-username">
						<label class="control-label" for="register-username">Gebruikersnaam:</label>
						<input id="register-username" name="register-username" type="text" placeholder="Gebruikersnaam" class="form-control" required="" onkeyup="checkUsername()">
					</div>

					<div class="form-group" id="register-form-group-firstname">
						<label class="control-label" for="register-firstName">Voornaam:</label>
						<input id="register-firstName" name="register-firstName" type="text" placeholder="Voornaam" class="form-control" required="">

					</div>

					<div class="form-group" id="register-form-group-lastname">
						<label class="control-label" for="register-lastName">Achternaam:</label>
						<input id="register-lastName" name="register-lastName" type="text" placeholder="achternaam" class="form-control" required="">

					</div>

					<div class="form-group" id="register-form-group-email">
						<label  class="control-label" for="register-email">Emai addres:</label>
						<input id="register-email" name="register-email" type="email" placeholder="Email adres" class="form-control" required="">

					</div>

					<div class="form-group" id="register-form-group-password">
						<label class="control-label" for="register-password">Wachtwoord:</label>
						<input id="register-password" name="register-password"  type="password" placeholder="wachtwoord" class="form-control" required="" onkeyup="checkPassword()"/>
					</div>

					<div class="form-group" id="register-form-group-password-again">
						<label class="control-label" for="register-password-again">wachtwoord controle:</label>
						<input id="register-password-again" name="register-password-again" type="password" placeholder="wachtwoord" class="form-control" required="" onkeyup="checkPassword()"/>
					</div>

					<div id="register-feedback-data">

					</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Venster sluiten</button>
				<input type="submit" class="btn btn-primary" value="Registreeren"/>
			</div>
			</form>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

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
				<button type="button" class="btn btn-info" data-toggle="modal" data-target=".register-modal">Register</button>
			</form>

		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>
