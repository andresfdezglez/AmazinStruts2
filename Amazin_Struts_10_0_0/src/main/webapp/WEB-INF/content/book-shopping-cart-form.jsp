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
			<label class="mytitle">Select a book:</label><br />



			<div style="color: green;">
				<s:property value="#request.bookAdded" />
				<br />
			</div>
			<div style="color: red;">
				<s:property value="#request.noBookSelected" />
				<br />
			</div>
			<s:form action="add-book-shopping-cart">
				<s:checkboxlist name="listBooks" list="#application.books"
					listKey="id" listValue="title" value="false" />
				<s:submit value="Add to shopping cart" />
			</s:form>

		</article>
		<article id="a01">
			<label class="mytitle">Choose an option:</label><br /> <a
				href="book-shopping-cart-form.action">Add book to Shopping Cart</a>
			<br /> <a href="show-book-shopping-cart.action">Show Shopping
				Cart</a> <br /> <a href="buy-book.action">Buy</a>
		</article>
	</section>
	<footer>

		<strong> Master in Web Engineering (miw.uniovi.es).</strong><br /> <em>University
			of Oviedo </em>
	</footer>
</body>
