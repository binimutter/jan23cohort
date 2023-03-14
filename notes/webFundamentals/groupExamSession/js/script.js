console.log('Wired up')

function changeImg(element) {
    // console.log('activated mouse event')
    element.src = "./images/yankeeBoy.png"
    element.alt = "yankee Boy squishee pic"
}
function changeBack(element) {
    // console.log('new event')
    element.src = "./images/breezee.png"
    element.alt = ".brezee squishie pic"
}
let count = 0;
function addToCart() {
    console.log('button clicked')
    // let count = 0;
    if (count === 0) {
        count++
        // console.log('if triggered', count)
    } else {
        count++
        // console.log('else triggered', count)
    }
    document.getElementById('cart').innerText = count
}

function salePrices() {
    // console.log('button click')
    var x = document.getElementById('sale');
    if (x.style.display === "none") {
        x.style.display = "flex";
    } else {
        x.style.display = "none";
    }
    var price = document.getElementsByClassName('price');
    // console.log(price);
    for (let i = 0; i < price.length; i++) {
        var newPrice = parseInt(price[i].innerText)
        newPrice = newPrice * 0.8
        price[i].innerText = newPrice
    }
}