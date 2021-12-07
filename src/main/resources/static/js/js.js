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

// movies
function todayMovie() {
    var todayMovie = document.getElementById("todayMovie").style.display = "block";
    var tomorrowMovie = document.getElementById("tomorrowMovie").style.display = "none";
    var dayAfterTomorrowMovie = document.getElementById("dayAfterTomorrowMovie").style.display = "none";
    var linkAll = document.getElementById("linkAll").innerHTML;


    document.getElementById("tomorrowMovie").style.display = tomorrowMovie;
    document.getElementById("todayMovie").style.display = todayMovie;
    document.getElementById("dayAfterTomorrowMovie").style.display = dayAfterTomorrowMovie;
    document.getElementById("linkAll").innerHTML = linkAll;
}

function tomorrowMovie() {
    var todayMovie = document.getElementById("todayMovie").style.display = "none";
    var tomorrowMovie = document.getElementById("tomorrowMovie").style.display = "block";
    var dayAfterTomorrowMovie = document.getElementById("dayAfterTomorrowMovie").style.display = "none";
    var linkAll = document.getElementById("linkAll").innerHTML;


    document.getElementById("tomorrowMovie").style.display = tomorrowMovie;
    document.getElementById("todayMovie").style.display = todayMovie;
    document.getElementById("dayAfterTomorrowMovie").style.display = dayAfterTomorrowMovie;
    document.getElementById("linkAll").innerHTML = linkAll;
}
function dayAfterTomorrowMovie() {
    var todayMovie = document.getElementById("todayMovie").style.display = "none";
    var tomorrowMovie = document.getElementById("tomorrowMovie").style.display = "none";
    var dayAfterTomorrowMovie = document.getElementById("dayAfterTomorrowMovie").style.display = "block";
    var linkAll = document.getElementById("linkAll").innerHTML;


    document.getElementById("tomorrowMovie").style.display = tomorrowMovie;
    document.getElementById("todayMovie").style.display = todayMovie;
    document.getElementById("dayAfterTomorrowMovie").style.display = dayAfterTomorrowMovie;
    document.getElementById("linkAll").innerHTML = linkAll;
}


// admin panel
function allNews() {
    var allNews = document.getElementById("allNews").style.display = "block";
    var allUsers = document.getElementById("allUsers").style.display = "none";
    var allMovies = document.getElementById("allMovies").style.display = "none";
    var allSessions = document.getElementById("allSessions").style.display = "none";
    var allDiagrams = document.getElementById("allSessions").style.display = "none";
    var linkAllUsers = document.getElementById("linkAllUsers").innerHTML;


    document.getElementById("allNews").style.display = allNews;
    document.getElementById("allUsers").style.display = allUsers;
    document.getElementById("allSessions").style.display = allSessions;
    document.getElementById("allMovies").style.display = allMovies;
    document.getElementById("allDiagrams").style.display = allDiagrams;
    document.getElementById("linkAllUsers").innerHTML = linkAllUsers;
}
function allUsers() {
    var allNews = document.getElementById("allNews").style.display = "none";
    var allUsers = document.getElementById("allUsers").style.display = "block";
    var allSessions = document.getElementById("allSessions").style.display = "none";
    var allMovies = document.getElementById("allMovies").style.display = "none";
    var allDiagrams = document.getElementById("allSessions").style.display = "none";
    var linkAllUsers = document.getElementById("linkAllUsers").innerHTML;


    document.getElementById("allNews").style.display = allNews;
    document.getElementById("allUsers").style.display = allUsers;
    document.getElementById("allSessions").style.display = allSessions;
    document.getElementById("allMovies").style.display = allMovies;
    document.getElementById("allDiagrams").style.display = allDiagrams;
    document.getElementById("linkAllUsers").innerHTML = linkAllUsers;
}

function allSessions() {
    var allNews = document.getElementById("allNews").style.display = "none";
    var allUsers = document.getElementById("allUsers").style.display = "none";
    var allMovies = document.getElementById("allMovies").style.display = "none";
    var allSessions = document.getElementById("allSessions").style.display = "block";
    var allDiagrams = document.getElementById("allSessions").style.display = "none";
    var linkAllUsers = document.getElementById("linkAllUsers").innerHTML;

    document.getElementById("allNews").style.display = allNews;
    document.getElementById("allUsers").style.display = allUsers;
    document.getElementById("allSessions").style.display = allSessions;
    document.getElementById("allMovies").style.display = allMovies;
    document.getElementById("allDiagrams").style.display = allDiagrams;
    document.getElementById("linkAllUsers").innerHTML = linkAllUsers;
}
function allMovies() {
    var allNews = document.getElementById("allNews").style.display = "none";
    var allUsers = document.getElementById("allUsers").style.display = "none";
    var allMovies = document.getElementById("allMovies").style.display = "block";
    var allSessions = document.getElementById("allSessions").style.display = "none";
    var allDiagrams = document.getElementById("allSessions").style.display = "none";
    var linkAllUsers = document.getElementById("linkAllUsers").innerHTML;


    document.getElementById("allNews").style.display = allNews;
    document.getElementById("allUsers").style.display = allUsers;
    document.getElementById("allSessions").style.display = allSessions;
    document.getElementById("allMovies").style.display = allMovies;
    document.getElementById("allDiagrams").style.display = allDiagrams;
    document.getElementById("linkAllUsers").innerHTML = linkAllUsers;
}
function allDiagrams() {
    var allNews = document.getElementById("allNews").style.display = "none";
    var allUsers = document.getElementById("allUsers").style.display = "none";
    var allMovies = document.getElementById("allMovies").style.display = "none";
    var allSessions = document.getElementById("allSessions").style.display = "none";
    var allDiagrams = document.getElementById("allSessions").style.display = "block";
    var linkAllUsers = document.getElementById("linkAllUsers").innerHTML;


    document.getElementById("allNews").style.display = allNews;
    document.getElementById("allUsers").style.display = allUsers;
    document.getElementById("allSessions").style.display = allSessions;
    document.getElementById("allMovies").style.display = allMovies;
    document.getElementById("allDiagrams").style.display = allDiagrams;
    document.getElementById("linkAllUsers").innerHTML = linkAllUsers;
}

function truncateText(text, letters = 135) {
    let truncatedText = text.slice(0, letters);
    let truncatedToHTML = `<p class="truncate">${truncatedText}...</p>`;

    return truncatedToHTML;
}

/* Select all card text containers */
let cards = document.getElementsByClassName("card_text");

/* Save texts within the cards as plain text */
let plainText = [];
for (let i = 0; i < cards.length; i++) {
    plainText[i] = cards[i].innerText;
}

/* Save the original card texts */
let htmlText = [];
for (let i = 0; i < cards.length; i++) {
    htmlText[i] = cards[i].innerHTML;
}

/* Add truncated text inside the cards */
for (let i = 0; i < cards.length; i++) {
    cards[i].innerHTML = truncateText(plainText[i]);
}

/* Add events to all buttons */
let btns = document.getElementsByClassName("card_btn");

for (let i = 0; i < cards.length; i++) {
    btns[i].addEventListener("click", function () {
        /* If the first child in the card text container has 'truncate' class... */
        if (cards[i].firstChild.className == "truncate") {
            /* Add their full text */
            cards[i].innerHTML = htmlText[i];
        } else {
            /* Add their truncated text */
            cards[i].innerHTML = truncateText(plainText[i]);
        }
    });
}


// diagrams

// window.onload  = function (data) {
//     $('#lineChart').remove();
//     $('#lineChart-container').append('<canvas id="lineChart"><canvas>');
//
//     const $grafica = document.querySelector("#myChart");
//     const tags = ["Октябрь", "Ноябрь", "Декабрь", "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь"]
//     const dataSales2020 = {
//         label: "Потребление за год",
//         data: [1,2,3,4,1,2,3,4,1,2,3,4],
//         backgroundColor: 'rgba(54, 162, 235, 0.2)',
//         borderColor: 'rgba(54, 162, 235, 1)',
//         borderWidth: 1,
//     };
//     new Chart($grafica, {
//         type: 'line',
//         data: {
//             labels: tags,
//             datasets: [
//                 dataSales2020,
//             ]
//         },
//         options: {
//             scales: {
//                 yAxes: [{
//                     ticks: {
//                         beginAtZero: true
//                     }
//                 }],
//             },
//             maintainAspectRatio: false
//         }
//     });
// }

window.onload = function (weekday) {
    $('#easionChartjsBar').remove();
    $('#graph-container').append('<canvas id="easionChartjsBar"><canvas>');
    var ctx = document.getElementById("easionChartjsBar").getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['Форрест Гамп', 'Веном 2'],
            datasets: [{
                label: 'Tickets',
                data: [5,2],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ]
            }]
        },
        options: {
            legend: {
                display: false
            },
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
}

