// creo i selettori del: testo in input, bottone aggiungi e lista ul
const testo = document.querySelector("#testo");
const aggiungi = document.querySelector("#aggiungi");
const lista = document.querySelector("#lista");

// creo evento che aspetta il click del bottone aggiungi ed esegue la funzione aggiungi task
aggiungi.addEventListener("click", aggiungiTask);
// testo.addEventListener("keyup", aggiungiTask(e));

function aggiungiTask() {
  if (testo.value) {
    let li = document.createElement("li"); //creo li
    lista.append(li); //appendo a UL > li
    li.innerText = testo.value; //assegno a li il testo inserito nell'inpunt

    li.addEventListener("click", () => li.classList.toggle("completato"));

    let rimuovi = document.createElement("button"); //credo il bottone rimuovi
    li.append(rimuovi); //appendo a LI > button
    rimuovi.innerText = "-"; //il testo del bottone diventa '-'

    rimuovi.addEventListener("click", () => lista.removeChild(li));
    //aggiungo evento che al click del bottone rimuovi toglie il filio LI di UL

    testo.value = ""; //resetto input
    testo.classList.remove("redplaceholder"); //rimuovo classe
    testo.placeholder = "Ricordami di..."; //resetto placeholder nel caso in cui avessi tentato di inserire una task vuota
  } else {
    testo.classList.add("redplaceholder"); //aggiungo classe a input per dare stile al placeholder nel caso in cui non si inserisca alcun testo nell'input
    testo.placeholder = "Devi inserire del testo"; //rimpiazzio il placeholder
  }
}
