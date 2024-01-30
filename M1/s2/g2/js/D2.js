/* ESERCIZIO 1
 Scrivi un algoritmo per trovare il più grande tra due numeri interi.
*/

{
  console.log("ESERCIZIO 1");

  let num1 = 20;
  let num2 = 15;

  if (num1 > num2 && Number.isInteger(num1 + num2)) {
    console.log(num1, "è maggiore di", num2);
  } else if (!Number.isInteger(num1 + num2)) {
    console.log("Uno dei due numeri non è intero");
  } else {
    console.log(num2, "è maggiore di", num1);
  }
}

/* ESERCIZIO 2
Scrivi un algoritmo che mostri "not equal" in console se un numero intero fornito è diverso da 5.
*/

{
  console.log("ESERCIZIO 2");

  let numero = 4;

  if (numero == 5 && Number.isInteger(numero)) {
    console.log("Il numero inserito è ugale a 5");
  } else if (!Number.isInteger(numero)) {
    console.log(numero, "non è un numero intero");
  } else {
    console.log(numero, "è diverso da 5");
  }
}

/* ESERCIZIO 3
Scrivi un algoritmo che mostri "divisibile per 5" in console se un numero fornito è perfettamente divisibile per 5 (suggerimento: usa l'operatore modulo)
*/

{
  console.log("ESERCIZIO 3");

  let numero = 10;

  if (Number.isInteger(numero / 5)) {
    console.log(numero, "è perfettamente divisibile per 5");
  } else {
    console.log(numero, "non è perfettamente divisibile per 5");
  }
}

/* ESERCIZIO 4
Scrivi un algoritmo per verificare che, dati due numeri interi, il valore di uno di essi sia 8 oppure se la loro addizione/sottrazione sia uguale a 8.
*/

{
  console.log("ESERCIZIO 4");

  let num1 = 10;
  let num2 = 8;

  if (num1 == 8 && num2 == 8) {
    console.log("Entrambi i numeri sono pari a 8");
  } else if (num1 == 8 && num2 != 8) {
    console.log("Il primo numero è uguale a 8");
  } else if (num1 != 8 && num2 == 8) {
    console.log("Il secondo numero è uguale a 8");
  } else {
    console.log("Nessuno dei numeri inseriti è pari a 8");
  }

  if (num1 + num2 == 8) {
    console.log("La somma dei numeri inseriti è pari a 8");
  } else if (num1 - num2 == 8) {
    console.log("La sottrazione dei numeri inseriti è pari a 8");
  } else {
    console.log("La somma/sottrazione dei numeri inseriti non è pari a 8");
  }
}

/* ESERCIZIO 5
Stai lavorando su un sito di e-commerce. Stai salvando il saldo totale del carrello dell'utente in una variabile "totalShoppingCart".
C'è una promozione in corso: se il totale del carrello supera 50, l'utente ha diritto alla spedizione gratuita (altrimenti la spedizione ha un costo fisso pari a 10).
Crea un algoritmo che determini l'ammontare totale che deve essere addebitato all'utente per il checkout.
*/

{
  console.log("ESERCIZIO 5");

  let totalShoppingCart = 51;
  let spedizione = 10;

  if (totalShoppingCart > 0 && totalShoppingCart <= 50) {
    totalShoppingCart += spedizione;
    console.log("Il totale del tuo ordine è pari a", totalShoppingCart);
  } else if (totalShoppingCart > 50) {
    console.log(
      "Spedizione gratuita! Il tuo ordine supera i 50 euro, il totale è pari a",
      totalShoppingCart
    );
  } else {
    console.log("Il carrello è vuoto");
  }
}

/* ESERCIZIO 6
  Stai lavorando su un sito di e-commerce. Oggi è il Black Friday e viene applicato il 20% su ogni prodotto.
  Modifica la risposta precedente includendo questa nuova promozione nell'algoritmo, determinando come prima se le spedizioni sono gratuite oppure no e e calcolando il totale.
  */

{
  console.log("ESERCIZIO 6");

  let totalShoppingCart = 62;
  let spedizione = 10;

  if ((totalShoppingCart * 0.8) > 0 && (totalShoppingCart * 0.8) <= 50) {
    totalShoppingCart = (totalShoppingCart*0.8)+spedizione;
    console.log("Il totale del tuo ordine è pari a", totalShoppingCart);
  } else if ((totalShoppingCart * 0.8) > 50) {
    console.log(
      "Spedizione gratuita! Il tuo ordine supera i 50 euro, il totale è pari a",
      totalShoppingCart*0.8
    );
  } else {
    console.log("Il carrello è vuoto");
  }
}

/* ESERCIZIO 7
  Crea tre variabili, e assegna un valore numerico a ciascuna di esse.
  Utilizzando un blocco condizionale, crea un algoritmo per ordinarle secondo il loro valore, dal più alto al più basso.
  Alla fine mostra il risultato in console.
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 8
  Crea un algoritmo per verificare che un valore fornito sia un numero oppure no (suggerimento: cerca su un motore di ricerca "typeof").
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 9
  Crea un algoritmo per controllare se un numero fornito sia pari o dispari (suggerimento: cerca l'operatore modulo su un motore di ricerca)
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 10
  Modifica la logica del seguente algoritmo in modo che mostri in console il messaggio corretto in ogni circostanza.
  let val = 7
  if (val < 10) {
      console.log("Meno di 10");
    } else if (val < 5) {
      console.log("Meno di 5");
    } else {
      console.log("Uguale a 10 o maggiore");
    }
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 11
  Fornito il seguente oggetto, scrivi del codice per aggiungere una proprietà "city", il cui valore sarà "Toronto".
*/

const me = {
  name: "John",
  lastName: "Doe",
  skills: ["javascript", "html", "css"],
};

/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 12
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere la proprietà "lastName".
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 13
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere l'ultimo elemento della proprietà "skills".
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 14
  Scrivi del codice per creare un array inizialmente vuoto. Riempilo successivamente con i numeri da 1 a 10.
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 15
  Scrivi del codice per sostituire l'ultimo elemento dell'array, ovvero il valore 10, con il valore 100.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
