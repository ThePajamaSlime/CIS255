"use strict";
/*    JavaScript 7th Edition
      Chapter 5
      Project 05-04

      Project to display footnotes in a popup window
      Author: Khamanei Ainsworth
      Date:   Tue July 23

      Filename: project05-04.js
*/

// Node list of phrases that are associated with footnotes
let phrases = document.querySelectorAll("article blockquote dfn");

for (var i = 0; i < phrases.length; i++) {
	(function(i) {
		phrases[i].addEventListener("click", function() {
			var phrase = document.createElement("h1");
			phrase.textContent = this.textContent;

			var footnote = document.createElement("p");
			footnote.textContent = footnotes[i];
			footnote.style       = "font-style: italic; font-size: 1.2em;";

			var closeButton = document.createElement("input");
			closeButton.type  = "button";
			closeButton.value = "Close Footnote";
			closeButton.style = "display:block; margin: 10px auto;";

			var popup = window.open("", "Footnote", "height=200,width=100,top=100,left=100");

			popup.document.body.style = "background-color: ivory; font-size: 16px; padding: 10px;";	
			popup.document.body.appendChild(phrase);
			popup.document.body.appendChild(footnote);
			popup.document.body.appendChild(closeButton);

			closeButton.addEventListener("click", function() { popup.close() });
		});
	}(i));
}
