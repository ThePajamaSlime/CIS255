/*    JavaScript 7th Edition
      Chapter 2
      Project 02-04

      Application to calculate the cost of a restaurant order plus tax
      Author: Khamanei Ainsworth
      Date:   Fri 14 June 2024
      Filename: project02-04.js
 */
 
PRICE_CHICKEN = 10.95;
PRICE_HALIBUT = 13.95;
PRICE_BURGER  = 9.95;
PRICE_SALMON  = 18.95;
PRICE_SALAD   = 7.95;

SALES_TAX = 0.07;

document.getElementById("chicken").onclick = calcTotal;
document.getElementById("halibut").onclick = calcTotal;
document.getElementById("burger" ).onclick = calcTotal;
document.getElementById("salmon" ).onclick = calcTotal;
document.getElementById("salad"  ).onclick = calcTotal;

function calcTotal() {
	cost = 0;

	buyChicken = document.getElementById("chicken").checked;
	buyHalibut = document.getElementById("halibut").checked;
	buyBurger  = document.getElementById("burger" ).checked;
	buySalmon  = document.getElementById("salmon" ).checked;
	buySalad   = document.getElementById("salad"  ).checked;

	buyChicken ? cost += PRICE_CHICKEN : cost += 0
	buyHalibut ? cost += PRICE_HALIBUT : cost += 0
	buyBurger  ? cost += PRICE_BURGER : cost += 0
	buySalmon  ? cost += PRICE_SALMON : cost += 0
	buySalad   ? cost += PRICE_SALAD : cost += 0

	document.getElementById("foodTotal").innerHTML = formatCurrency(cost);
	document.getElementById("foodTax"  ).innerHTML = formatCurrency(cost * SALES_TAX);
	document.getElementById("totalBill").innerHTML = formatCurrency(cost + cost * SALES_TAX);
}

// Function to display a numeric value as a text string in the format $##.## 
 function formatCurrency(value) {
    return "$" + value.toFixed(2);
 }
