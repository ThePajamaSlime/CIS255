/*    JavaScript 7th Edition
      Chapter 2
      Project 02-01

      Celsius <-> Farenheit Coverter
      Author: Khamanei Ainsworth 
      Date:   Fri 15 June 2024
      Filename: project02-01.js
 */

function CtoF(deg) {
	 return deg * 1.8 + 32;
 }

function FtoC(deg) {
	 return (deg - 32) / 1.8;
}

cValue = document.getElementById("cValue");
fValue = document.getElementById("fValue");

cValue.onchange = function () { document.getElementById("fValue").value = CtoF(document.getElementById("cValue").value) };
fValue.onchange = function () { document.getElementById("cValue").value = FtoC(document.getElementById("fValue").value) };

