const wrapNumeri = document.querySelector(".wrap-numeri");
const inputSchede = document.querySelector(".input-schede");
const bottoneEstrai = document.querySelector(".estrai");
let numeriEstratti = [0];

creaTabellone();
const numeroTabellone = document.querySelectorAll(".numero");

bottoneEstrai.addEventListener("click", estraiNumero);

function creaTabellone() {
  for (let i = 1; i <= 90; i++) {
    numero = document.createElement("div");
    numero.classList.add("numero");
    numero.innerText = i;
    wrapNumeri.append(numero);
  }
}

function creaScheda() {}

function estraiNumero() {
  let numeroRandom = Math.floor(Math.random() * 90 + 1);
  numeriEstratti.forEach((numero) => {
    // console.log(numeroRandom);
    if (numero != numeroRandom) {
      numeriEstratti.push(numeroRandom);
      //   console.log(numeriEstratti);
    }
  });
  numeroTabellone.forEach((cella) => {
    if (cella.innerText == numeroRandom) {
      cella.classList.add("colore");
    }
  });
}
