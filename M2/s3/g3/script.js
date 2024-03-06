fetch("https://striveschool-api.herokuapp.com/books")
    .then((response) => response.json())
    .then((libri) => {
        let row = document.querySelector(".row");
        let template = document.getElementsByTagName("template")[0];
        
        libri.forEach((libro) => {
            let card = template.content.cloneNode(true);
            let bookImage = card.querySelector("img");
            let bookTitle = card.querySelector("h5");
            let bookPrice = card.querySelector("p");
            let buttonRemove = card.querySelector('.scarta')
            let buttonBuy = card.querySelector('.compra')
            bookImage.setAttribute('src', `${libro.img}`)
            bookTitle.innerText = libro.title;
            bookPrice.innerText = libro.price + '$';
            buttonRemove.addEventListener('click', function(){
                this.parentElement.parentElement.parentElement.remove();
            }) 
            buttonBuy.addEventListener('click', function(){
                // localStorage.setItem (`${bookTitle}`, `${bookTitle}`)
            }) 
            row.appendChild(card);
        });
    });
