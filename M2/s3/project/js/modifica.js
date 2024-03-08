import { getId } from "./export.js";
import Product from './export.js';
const id = getId();

function writeProductInput(selettore, info_prodotto) {
    let element = document.querySelector(`${selettore}`);
    element.value = `${info_prodotto}`;
}

function getProductInputValue(selettore) {
    return document.querySelector(`${selettore}`).value
}

function deleteProduct() {
    //DA PULIRE
    fetch(`https://striveschool-api.herokuapp.com/api/product/${id}`, {
        method: "DELETE",
        headers: {
            Authorization:
                "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZTg4OTJkN2IxMTAwMTkwZTZmNWIiLCJpYXQiOjE3MDk4OTM3NjksImV4cCI6MTcxMTEwMzM2OX0.73fOiV3a4vGZ_L20YVP5v9_bPaJ30wE9c9MWHAUHXBU",
            "Content-type": "application/json",
        },
    });
    location.href = 'index.html'
}

function editProduct() {
    let productName = getProductInputValue('#productName')
    let productDesc = getProductInputValue('#productDesc')
    let productBrand = getProductInputValue('#productBrand')
    let productImage = getProductInputValue('#productImage')
    let productPrice = getProductInputValue('#productPrice')
    let editedProduct = new Product(productName, productDesc, productBrand, productImage, productPrice)

    fetch(`https://striveschool-api.herokuapp.com/api/product/${id}`, {
        method: "PUT",
        headers: {
            Authorization:
                "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZTg4OTJkN2IxMTAwMTkwZTZmNWIiLCJpYXQiOjE3MDk4OTM3NjksImV4cCI6MTcxMTEwMzM2OX0.73fOiV3a4vGZ_L20YVP5v9_bPaJ30wE9c9MWHAUHXBU",
            "Content-type": "application/json",
        },
        body: JSON.stringify(editedProduct)
    });
}

    fetch(`https://striveschool-api.herokuapp.com/api/product/${id}`, {
        method: "GET",
        headers: {
            Authorization:
                "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZTg4OTJkN2IxMTAwMTkwZTZmNWIiLCJpYXQiOjE3MDk4OTM3NjksImV4cCI6MTcxMTEwMzM2OX0.73fOiV3a4vGZ_L20YVP5v9_bPaJ30wE9c9MWHAUHXBU",
            "Content-type": "application/json",
        },
    })
        .then((response) => response.json())
        .then((prodotto) => {
            writeProductInput("#productName", `${prodotto.name}`);
            writeProductInput("#productBrand", `${prodotto.brand}`);
            writeProductInput("#productPrice", `${prodotto.price}`);
            writeProductInput("#productImage", `${prodotto.imageUrl}`);
            writeProductInput("#productDesc", `${prodotto.description}`);
            let deleteBtn = document.querySelector("#deleteBtn");
            deleteBtn.addEventListener("click", function(e){
                e.preventDefault();
                deleteProduct();
            });
            //DA PULIRE
            let editBtn = document.querySelector('#editBtn')
            editBtn.addEventListener("click", function(e){
                e.preventDefault();
                editProduct();
            });
        });

