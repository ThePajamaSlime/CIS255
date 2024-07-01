/*    JavaScript 7th Edition
      Chapter 3
      Project 03-01

      Application to calculate total order cost
      Author: Khamanei Ainsworth
      Date:   July 1, 2024

      Filename: project03-01.js
*/

menuItems = document.getElementsByClassName("menuItem");

for (i = 0; i < menuItems.length; i++) {
	menuItems[i].addEventListener("click", calcTotal);
}

function calcTotal() {
	orderTotal = 0;

	for (i = 0; i < menuItems.length; i++) {
		orderTotal += (menuItems[i].checked) ? Number(menuItems[i].value) : 0
	}

	document.getElementById("billTotal").innerHTML = formatCurrency(orderTotal);
}


 // Function to display a numeric value as a text string in the format $##.## 
 function formatCurrency(value) {
    return "$" + value.toFixed(2);
 }
