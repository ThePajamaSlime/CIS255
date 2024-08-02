"use strict";
/*    JavaScript 7th Edition
      Chapter 6
      Project 06-01

      Project to validate a form used for setting up a new account
      Author: Khamanei Ainsworth
      Date:   27 July 2024

      Filename: project06-01.js
*/

var submitButton = document.getElementById("submitButton");
var pwd  = document.getElementById("pwd");
var pwd2 = document.getElementById("pwd2");

submitButton.addEventListener("click", function() {
	if (pwd.validity.patternMismatch) {
		pwd.setCustomValidity("No good!");
	}
	else if (pwd.value != pwd2.value) {
		pwd2.setCustomValidity("no match!");
	}
	else {
		pwd.setCustomValidity("");
		pwd2.setCustomValidity("");
	}
});

