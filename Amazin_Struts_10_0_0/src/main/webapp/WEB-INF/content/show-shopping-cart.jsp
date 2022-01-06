<!DOCTYPE html >
<%@ page contentType="text/html; charset=iso-8859-1"
	pageEncoding="iso-8859-1" language="java"
	import="java.util.*, com.miw.model.Book,com.miw.presentation.book.*"
	errorPage="" import="com.miw.model.User"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<head>
<title>Amazin</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<header>
		<h1 class="header">Amazin.com</h1>
		<h2 class="centered">
			Welcome to the <em>smallest</em> online shop in the world!!
		</h2>
	</header>
	<nav>
		<ul>
			<li><a href="index.action">Start</a></li>
			<li><a href="http://miw.uniovi.es">About</a></li>
			<li><a href="mailto:dd@email.com">Contact</a></li>
			<li><s:a action="logout">
					<s:text name="Log out" />
				</s:a></li>
		</ul>
	</nav>
	<section>
		<article>
			<div style="color: green;">
				<s:property value="#request.done" />
				<br />
			</div>
			<div style="color: red;">
				<s:property value="#request.noStockk" />
				<br />
			</div>
			<%
				if (request.getAttribute("shoppingCart") != null) {
			%>
			<h3>Shopping Cart</h3>
			<table>
				<caption>The books you have in the shopping cart</caption>
				<thead>
					<tr>
						<th>Title</th>
						<th>Quantity</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.shoppingCart">
						<tr>
							<td><s:property value="key.title" /></td>
							<td><s:property value="value" /></td>
							<td><s:property value="key.price" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<span>Total price:</span> <span> <s:property
					value="#request.price"></s:property> &euro;
			</span>
			<%
				}
			%>
			<%
				if (request.getAttribute("shoppingCart") == null) {
			%>
			<span>There is no book in the shopping cart</span>
			<%
				}
			%>
		</article>
	</section>
	<section>
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