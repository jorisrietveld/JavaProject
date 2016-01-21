<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="includes/head.jsp"%>
	<title></title>
</head>
<body>
	<% if( session.getAttribute("session") == null ){ %>
		<%@include file="includes/header.jsp"%>
	<% }else{ %>
		<%@include file="includes/header-logged-in.jsp"%>
	<% } %>
	<div class="container">
		<div class="jumbotron">
			<h1>Welkom op de website van relaunch</h1>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quis negat? At coluit ipse amicitias. Si longus, levis dictata sunt. Numquam facies. </p>

			<p>Venit ad extremum; Tria genera bonorum; Ita credo. Ita prorsus, inquam; Et quod est munus, quod opus sapientiae? Minime vero istorum quidem, inquit. </p>

			<p>Quamquam tu hanc copiosiorem etiam soles dicere. Hoc mihi cum tuo fratre convenit. Res enim concurrent contrariae. </p>

			<blockquote cite='http://loripsum.net'>
				Verum ut haec non in posteris et in consequentibus, sed in primis continuo peccata sunt, sic ea, quae proficiscuntur a virtute, susceptione prima, non perfectione recta sunt iudicanda.
			</blockquote>


			<p>Si quae forte-possumus. Ratio quidem vestra sic cogit. Duo Reges: constructio interrete. Rationis enim perfectio est virtus; </p>

			<p>Idemne, quod iucunde? Hic ambiguo ludimur. Facete M. Pollicetur certe. Zenonis est, inquam, hoc Stoici. Quid enim possumus hoc agere divinius? Cur iustitia laudatur? An eiusdem modi? </p>
		</div>
	</div>

</body>
</html>
