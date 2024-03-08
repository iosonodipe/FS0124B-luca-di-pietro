function clone() {
    let template = document.querySelector("template");
    let clone = template.content.cloneNode(true);
    return clone;
}

fetch("https://striveschool-api.herokuapp.com/api/product/", {
    method: "GET",
    headers: {
        Authorization:
            "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZTg4OTJkN2IxMTAwMTkwZTZmNWIiLCJpYXQiOjE3MDk4OTM3NjksImV4cCI6MTcxMTEwMzM2OX0.73fOiV3a4vGZ_L20YVP5v9_bPaJ30wE9c9MWHAUHXBU",
        "Content-type": "application/json",
    },
})
.then((response) => response.json())
.then(prodotti => {
    prodotti.forEach(prodotto => {
        let card = clone();
        let cardContent = card.querySelector('.card')
        cardContent.addEventListener('click', function(){
            location.href = 'dettagli.html' + `?id=${prodotto._id}`
        })
        let row = document.querySelector("#product-catalogue");
        let productImage = card.querySelector('.card-img-top');
        productImage.src = `${prodotto.imageUrl}`;
        let productName = card.querySelector('.card-title');
        productName.innerText = `${prodotto.name}`
        let productDesc = card.querySelector('.card-text');
        productDesc.innerText = `${prodotto.description}`
        row.append(card)
    });
})
