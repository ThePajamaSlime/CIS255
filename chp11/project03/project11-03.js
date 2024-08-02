"use strict";
/*    JavaScript 7th Edition
      Chapter 11
      Project 11-03

      Project to retrieve order history from a web server
      Author: Khamanei Ainsworth
      Date:   Fri, Aug 2, 2024

      Filename: project11-03.js
*/

let orderResult = document.getElementById("orderResult");
let userIDBox = document.getElementById("userID");
let pwdBox = document.getElementById("pwd");


// Retrieve order history when the View Orders button is clicked
viewOrders.onclick = function() {
	var user = userIDBox.value;
	var pwd = pwdBox.value;

	fetch("wworders.pl?id=" + user + "&pwd=" + pwd)
	.then(response => response.json())
	.then(json => buildOrderTable(json))
	.catch(error => console.log(error));

}


// Function to display order history within web tables
function buildOrderTable(obj) {
	if (obj.status == "Orders Not Found") {
		orderResult.innerHTML = "No orders found for this user id and password."
	}
	else {
		var htmlCode = '<table id="summary"><tr><th>Name</th><td>' + obj.username + '</td><tr><th>Total Charges</th><td>' + obj.totalCharges + '</td></tr></table>';

		for (var i; i < obj.orderHistory.length; i++) {
			htmlCode += '<table class="orderList"><tr><th colspan="2">' + obj.orderHistory[i].orderDate + '</th><th colspan="2">' + obj.orderHistory[i].orderCost + '</th></tr><tr><th>Description</th><th>Qty</th><th>Price</th><th>Total</th></tr>';

			for (var j; j < obj.orderHistory[i].products.length; j++) {
				htmlCode += '<tr><td>' + obj.orderHistory[i].products[j].description + '</td><td>' + obj.orderHistory[i].products[j].qty + '</td><td>' + obj.orderHistory[i].products[j].price + '</td><td>' + obj.orderHistory[i].products[j].total + '</td></tr>'
		}

		htmlCode += "</table>";
}

	orderResults.innerHTML = htmlCode;

	}
}

