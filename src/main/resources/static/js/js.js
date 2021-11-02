// Modal Image Gallery
function onClick(element) {
    document.getElementById("img01").src = element.src;
    document.getElementById("modal01").style.display = "block";
    var captionText = document.getElementById("caption");
    captionText.innerHTML = element.alt;
}

// Change style of navbar on scroll
window.onscroll = function () {
    myFunction()
};

function myFunction() {
    var navbar = document.getElementById("myNavbar");
    if (document.body.scrollTop > 100 || document.documentElement.scrollTop > 100) {
        navbar.className = "w3-bar" + " w3-card" + " w3-animate-top" + " w3-white";
    } else {
        navbar.className = navbar.className.replace(" w3-card w3-animate-top w3-white", "");
    }
}

// Used to toggle the menu on small screens when clicking on the menu button
function toggleFunction() {
    var x = document.getElementById("navDemo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else {
        x.className = x.className.replace(" w3-show", "");
    }
}

function showHide() {
    var x = document.getElementsByClassName('newsDisplay');
    if (x.style.display === 'none') {
        x.style.display = 'block';
    } else {
        x.style.display = 'none';
    }
}

function allMovie() {
    var allMovie = document.getElementById("allMovie").style.display = "block";
    var todayMovie = document.getElementById("todayMovie").style.display = "none";
    var linkAll = document.getElementById("linkAll").innerHTML;


    document.getElementById("allMovie").style.display = allMovie;
    document.getElementById("todayMovie").style.display = todayMovie;
    document.getElementById("linkAll").innerHTML = linkAll;
}

function todayMovie() {
    var allMovie = document.getElementById("allMovie").style.display = "none";
    var todayMovie = document.getElementById("todayMovie").style.display = "block";
    var linkAll = document.getElementById("linkAll").innerHTML;


    document.getElementById("allMovie").style.display = allMovie;
    document.getElementById("todayMovie").style.display = todayMovie;
    document.getElementById("linkAll").innerHTML = linkAll;
}
