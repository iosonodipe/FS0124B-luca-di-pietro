const wrapNumeri = document.querySelector(".wrap-numeri");
const numeroTabellone = document.querySelectorAll(".numero");
const inputSchede = document.querySelector(".input-schede");
const bottoneEstrai = document.querySelector(".estrai");
let numeriEstratti = [0];

creaTabellone();

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
  numeriEstratti.forEach(
    (numero) =>
      function () {
        if (numero != numeroRandom) {
          numeriEstratti.push(numeroRandom);
        }
      }
  );
  numeroTabellone.forEach(
    (cella) =>
      function () {
        if (cella.innerText == numeroRandom) {
          cella.classList.add("colore");
        }
      }
  );
}

// function estraiNumero() {
//   let numeroRandom = Math.floor(Math.random() * 90 + 1);
//   numeriEstratti.forEach(
//     (n) =>
//       function () {
//         if (n != numeroRandom) {
//           numeriEstratti.push(numeroRandom);
//           wrapNumeri.forEach((numero) => {
//             if (numero.innerText == n) {
//               numero.classList.add("colore");
//             }
//           });
//         }
//       }
//   );
// }
