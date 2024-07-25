"use strict";
/*    JavaScript 7th Edition
      Chapter 5
      Project 05-03

      Project to create a table of headings from an article
      Author: Khamanei Ainsworth
      Date:   Thur July 18

      Filename: project05-03.js
*/

var sourceDoc = document.getElementById("source_doc");
var toc = document.getElementById("toc");
var headingCount = 1;
const heading = "H2";

for (var n = sourceDoc.firstElementChild; n != null; n = n.nextElementSibling) {
	if (n.nodeName == heading) {
		var anchor = document.createElement("a");
		anchor.name = "doclink" + headingCount;
		n.insertBefore(anchor, n.firstElementChild);

		var listItem = document.createElement("li");
		var link = document.createElement("a");
		link.href = "#doclink" + headingCount;
		listItem.appendChild(link);

		link.textContent = n.textContent;

		toc.appendChild(listItem);
		
		headingCount++;
	}
}

