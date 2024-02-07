const bottoneAggiungi = document.querySelector("#aggiungiTask");
let testoTask = document.querySelector("#task");
let elenco = document.querySelector("#listaTask");
let nuovaTask = document.createElement("li");
let bottoneRimuovi = document.createElement("button");

bottoneAggiungi.addEventListener("click", addTask);
bottoneRimuovi.addEventListener("click", removeTask);

console.dir(bottoneRimuovi);

function addTask() {
  if (testoTask.value) {
    elenco.append(nuovaTask);
    nuovaTask.innerText = testoTask.value;
    elenco.append(bottoneRimuovi);
    bottoneRimuovi.innerText = "-";
    testoTask.value = "";
  } else alert("Aggiungi del testo per aggiungere una task");
}

function completed() {}

function removeTask() {}
