/*    JavaScript 7th Edition
      Chapter 2
      Project 02-03

      Application to return the shape of a clicked object
      Author: Khamanei Ainsworth
      Date:   Fri 14 June 2024
      Filename: project02-03.js
 */

feedback = document.getElementById("feedback")

document.getElementById("square").onmouseover = function () { feedback.innerHTML = "You're hovering over the square"; };
document.getElementById("square").onmouseout  = function () { feedback.innerHTML = ""; };

document.getElementById("triangle").onmouseover = function () { feedback.innerHTML = "You're hovering over the triangle"; };
document.getElementById("triangle").onmouseout  = function () { feedback.innerHTML = ""; };

document.getElementById("circle").onmouseover = function () { feedback.innerHTML = "You're hovering over the circle"; };
document.getElementById("circle").onmouseout  = function () { feedback.innerHTML = ""; };
