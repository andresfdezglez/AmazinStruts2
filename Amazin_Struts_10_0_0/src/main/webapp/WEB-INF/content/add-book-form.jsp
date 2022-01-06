<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<head>
<title>Amazin</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<header>
		<h1 class="header">Amazin.com</h1>
		<h2 class="centered">Añadir nuevo libro</h2>
	</header>
	<nav>
		<ul>
			<li><a href="index.action">Start</a></li>
			<li><a href="http://miw.uniovi.es">About</a></li>
			<li><a href="mailto:dd@email.com">Contact</a></li>
		</ul>
	</nav>
	<section>
		<article>
			<label class="mytitle">Introduce los datos del nuevo libro:</label><br />

			<div style="color: green;">
				<s:property value="#request.bookInserted" />
				<br />
			</div>
			<div style="color: red;">
				<s:property value="#request.bookNotInserted" />
				<br />
			</div>

			<s:form action="add-book">
				<s:textfield name="newBook.title" label="Título" value="" />
				<s:textfield name="newBook.description" label="Descripción" value="" />
				<s:textfield name="newBook.author" label="Autor" value="" />
				<s:textfield name="vat.taxGroup" label="Tax Group" value="" />
				<s:textfield name="newBook.basePrice" label="Precio base" value="" />
				<s:submit value="Add Book" />
			</s:form>

		</article>
	</section>
	<footer>

		<strong> Master in Web Engineering (miw.uniovi.es).</strong><br /> <em>University
			of Oviedo </em>
	</footer>
</body>
