/*    JavaScript 7th Edition
      Chapter 2
      Project 02-02

      Application to test for completed form
      Author: Khamanei Ainsworth
      Date:   Fri 14 June 2024
      Filename: project02-02.js
 */

function verifyForm() {
	name  = document.getElementById("name").value; 
	phone = document.getElementById("phone").value; 
	email = document.getElementById("email").value; 

	(name && phone && email) ? window.alert("Big McThankies from McSpankies!") : window.alert("Failure to fill all fields. This incident will be reported.")
}

document.getElementById("submit").onclick = verifyForm;
