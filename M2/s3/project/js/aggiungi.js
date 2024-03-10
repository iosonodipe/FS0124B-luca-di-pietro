import Product from "./export.js";

const addBtn = document.querySelector("#addBtn");
addBtn.addEventListener("click", function (e) {
    e.preventDefault();
    addProduct();
});

const resetBtn = document.querySelector("#resetBtn");
        resetBtn.addEventListener("click", function () {
            if (confirm("Resettare il form?")) {
                (document.querySelector('#form1')).reset()
            } 
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

    if (
        !productName == "" &&
        !productBrand == "" &&
        !productPrice == "" &&
        !productImage == "" &&
        !productDesc == ""
    ) {
        if (confirm("Sei sicuro di voler aggiungere il prodotto?")) {
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
                body: JSON.stringify(product),
            })
                .then((response) => response.json())
                .then((res) => {
                    let productAdded = document.querySelector("#productAdded");
                    productAdded.classList.remove("d-none");
                    setTimeout(function () {
                        location.href = "index.html";
                    }, 2000);
                });
        }
    } else alert("Devi compilare tutti i campi per aggiungere un prodotto!");
}
