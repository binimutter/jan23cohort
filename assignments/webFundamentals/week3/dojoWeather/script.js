function cityAlert() {
    alert("Loading weather report...");
}

function hideCookie() {
    var x = document.getElementById("cookie");
    if (x.style.display === "none") {
        x.style.display = "flex";
    } else {
        x.style.display = "none";
    }
}

function changeDegrees() {
    var parent = document.getElementById("temperature");
    var values = parent.getElementsByTagName('h2');
    // console.log("🚀 ~ file: script.js:18 ~ changeDegrees ~ values", values)
}