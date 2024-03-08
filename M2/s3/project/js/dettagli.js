const url = new URLSearchParams(location.search);
const id = url.get("id");

function writeProductInfo(selettore, info_prodotto, immagine_prodotto = 0) {
    if (!immagine_prodotto == 0) {
        let element = document.querySelector(`${selettore}`);
        element.src = `${immagine_prodotto}`;
    } else {
        let element = document.querySelector(`${selettore}`);
        element.innerText = `${info_prodotto}`;
    }
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
        writeProductInfo(
            "#productImage",
            `${prodotto.imageUrl}`,
            `${prodotto.imageUrl}`
        );
        writeProductInfo("#productBrand", `${prodotto.brand}`);
        writeProductInfo("#productName", `${prodotto.name}`);
        writeProductInfo("#productPrice", `${prodotto.price}`);
        writeProductInfo("#productDesc", `${prodotto.description}`);
    });
