import Product from './export.js'

const addBtn = document.querySelector("#addBtn");
addBtn.addEventListener("click", function (e) {
    e.preventDefault();
    addProduct();
});

function getInputValue(id) {
    return document.querySelector(id).value;
}

async function addProduct() {
    let productName = getInputValue("#productName");
    let productBrand = getInputValue("#productBrand");
    let productPrice = getInputValue("#productPrice");
    let productImage = getInputValue("#productImage");
    let productDesc = getInputValue("#productDesc");

    let product = new Product(
        productName,
        productDesc,
        productBrand,
        productImage,
        productPrice
    );

    fetch("https://striveschool-api.herokuapp.com/api/product/", {
        method: "POST",
        headers: {
            Authorization:
                "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZTg4OTJkN2IxMTAwMTkwZTZmNWIiLCJpYXQiOjE3MDk4OTM3NjksImV4cCI6MTcxMTEwMzM2OX0.73fOiV3a4vGZ_L20YVP5v9_bPaJ30wE9c9MWHAUHXBU",
            "Content-type": "application/json",
        },
        body: JSON.stringify(product)
    })
        .then((response) => response.json())
        .then((res) => {
            alert("Prodotto creato correttamente!");
            //do conferma all'utente oppure lo mando via
        });
}
