fetch("https://striveschool-api.herokuapp.com/books")
    .then((response) => response.json())
    .then((libri) => {
        let row = document.querySelector(".row");
        let template = document.querySelector("template");

        libri.forEach((libro) => {
            let card = template.content.cloneNode(true);
            let bookImage = card.querySelector("img");
            let bookTitle = card.querySelector("h5");
            let bookPrice = card.querySelector("p");
            let buttonRemove = card.querySelector(".scarta");
            let buttonBuy = card.querySelector(".compra");
            bookImage.src = libro.img;
            bookTitle.innerText = libro.title;
            bookPrice.innerText = libro.price + "$";
            buttonRemove.addEventListener("click", function () {
                this.parentElement.parentElement.parentElement.remove();
            });
            buttonBuy.addEventListener("click", function () {
                localStorage.setItem(`${libro.asin}`, `${libro.title}`)
                let cartList = document.querySelector('.cart-list');
                let cartItem = document.createElement('li')
                cartItem.innerText = `${libro.title}`
                let cartButton = document.createElement('button')
                cartButton.classList.add('btn', 'btn-danger', 'p-1','m-2')
                cartButton.innerText = 'Scarta'
                cartItem.append(cartButton)
                cartButton.addEventListener('click', function () {
                    cartItem.remove();
                    localStorage.removeItem(`${libro.asin}`)
                })
                cartList.appendChild(cartItem)
            });
            row.appendChild(card);
        });
    });
