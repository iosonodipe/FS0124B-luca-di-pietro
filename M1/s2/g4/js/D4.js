/* ESERCIZIO 1
 Scrivi una funzione di nome "area", che riceve due parametri (l1, l2) e calcola l'area del rettangolo associato.
*/

console.log("ESERCIZIO 1");

let area = (l1, l2) => l1 * l2;

console.log(area(3, 2));

/* ESERCIZIO 2
 Scrivi una funzione di nome "crazySum", che riceve due numeri interi come parametri.
 La funzione deve ritornare la somma dei due parametri, ma se il valore dei due parametri è il medesimo deve invece tornare
 la loro somma moltiplicata per tre.
*/

console.log("ESERCIZIO 2");

let crazySum = (n1, n2) => {
  if (n1 === n2) {
    return (n1 + n2) * 3;
  } else {
    return n1 + n2;
  }
};

console.log(crazySum(3, 3));

/* ESERCIZIO 3
 Scrivi una funzione di nome "crazyDiff" che calcola la differenza assoluta tra un numero fornito come parametro e 19.
 Deve inoltre tornare la differenza assoluta moltiplicata per tre qualora il numero fornito sia maggiore di 19.
*/

console.log("ESERICIZIO 3");

function crazyDiff(a, b = 19) {
  c = Math.abs(a - b);
  if (a > 19) {
    return c * 3;
  } else {
    return c;
  }
}

console.log(crazyDiff(17));

/* ESERCIZIO 4
 Scrivi una funzione di nome "boundary" che accetta un numero intero n come parametro, e ritorna true se n è compreso tra 20 e 100 (incluso) oppure
 se n è uguale a 400.
*/

console.log("ESERCIZIO 4");

function boundary(n) {
  if ((n >= 20 && n <= 100) || n === 4000) {
    return "True";
  } else {
    return "False";
  }
}

// function boundary(n){
//     return (n >= 20 && n <= 100) || n === 4000
// }  metodo abbreviato

console.log(boundary(101));

/* ESERCIZIO 5
 Scrivi una funzione di nome "epify" che accetta una stringa come parametro.
 La funzione deve aggiungere la parola "EPICODE" all'inizio della stringa fornita, ma se la stringa fornita comincia già con "EPICODE" allora deve
 ritornare la stringa originale senza alterarla.
*/

console.log("ESERICIZIO 5");

function epify(a) {
  if (a.slice(0) == "EPICODE") {
    return a;
  } else {
    return "EPICODE " + a;
  }
}

console.log(epify("EPICODE"));

/* ESERCIZIO 6
 Scrivi una funzione di nome "check3and7" che accetta un numero positivo come parametro. La funzione deve controllare che il parametro sia un multiplo
 di 3 o di 7. (Suggerimento: usa l'operatore modulo)
*/

console.log("ESERCIZIO 6");

function check3and7(n) {
  let check;
  if (n >= 0) {
    if (n % 3 == 0) {
      check = "Il numero inserito è multiplo di 3";
    } else if (n % 7 == 0) {
      check = "Il numero inserito è multiplo di 7";
    }
  } else {
    check = "Il numero inserito è negativo.";
  }
  return check;
}

console.log(check3and7(6));

/* ESERCIZIO 7
 Scrivi una funzione di nome "reverseString", il cui scopo è invertire una stringa fornita come parametro (es. "EPICODE" --> "EDOCIPE")
*/

console.log("ESERCIZIO 7");

function reverseString(parola) {
  let parolaReverse = parola.split("").reverse().join("");
  return parolaReverse;
}

console.log(reverseString("Luca"));

/* ESERCIZIO 8
 Scrivi una funzione di nome "upperFirst", che riceve come parametro una stringa formata da diverse parole.
 La funzione deve rendere maiuscola la prima lettera di ogni parola contenuta nella stringa.
*/

console.log("ESERCIZIO 8");

function upperFirst(parole) {
  let lettere_maiusc = parole.split(" ");
  let risultato= [];

  for (let index = 0; index < lettere_maiusc.length; index++) {
    let parolaCompleta = (lettere_maiusc[index].charAt(0).toUpperCase())+lettere_maiusc[index].slice(1);

    risultato.push(parolaCompleta)
  }

  return risultato.join(' ');
}

console.log(upperFirst("ciao luca sono luca"));

/* ESERCIZIO 9
 Scrivi una funzione di nome "cutString", che riceve  come parametro una stringa. La funzione deve creare una nuova stringa senza il primo e l'ultimo carattere
 della stringa originale.
*/

console.log("ESERCIZIO 9");

function cutString(parola) {
  let nuovaParola= parola.slice(1, (parola.length-1))

  return nuovaParola;
}

console.log(cutString('ciao luca'));

/* ESERCIZIO 10
 Scrivi una funzione di nome "giveMeRandom", che accetta come parametro un numero n e ritorna un'array contenente n numeri casuali inclusi tra 0 e 10.
*/

console.log("ESERCIZIO 10");

function giveMeRandom(n) {
  let array = [];
  for (let i = 0; i < n; i++) {
    array.push(Math.floor(Math.random() * 10)); 
  }

  return array;
}

console.log(giveMeRandom(20));
