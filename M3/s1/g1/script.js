"use strict";
class User {
    constructor(nome, cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.credito = 0;
        this.numeroChiamate = 0;
    }
    ricarica(amount) {
        this.credito += amount;
        console.log(`Utente: ${this.nome}, Credito: ${this.credito}$`);
    }
    chiamata(minuti) {
        let check = minuti * 0.2;
        if (check <= this.credito) {
            this.credito -= check;
            this.numeroChiamate += minuti;
            console.log(`Chiamata effettuata. Nuovo credito dipsponibile utente ${this.nome}: ${this.credito}$`);
        }
        else {
            console.log(`Impossibile effettuare la chiamata. L'importo della chiamata è pari a ${check}$, il credito disponibile dell'utente ${this.nome} è di ${this.credito}$.`);
        }
    }
    chiama404() {
        return this.credito;
    }
    getNumeroChiamata() {
        return this.numeroChiamate;
    }
    azzeraChiamate() {
        this.numeroChiamate = 0;
    }
}
let luca = new User("Luca", "Di Pietro");
let mario = new User("Mario", "Rossi");
let paolo = new User("Paolo", "Verdi");
luca.ricarica(10);
mario.ricarica(5);
paolo.ricarica(15);
luca.chiamata(5);
mario.chiamata(30);
paolo.chiamata(50);
console.log('Luca ha un credito di $' + luca.chiama404());
console.log('Mario ha un credito di $' + mario.chiama404());
console.log('Paolo ha un credito di $' + paolo.chiama404());
console.log('Luca ha effettuato chiamate per ' + luca.getNumeroChiamata() + ' minuti.');
console.log('Mario ha effettuato chiamate per ' + mario.getNumeroChiamata() + ' minuti.');
console.log('Paolo ha effettuato chiamate per ' + paolo.getNumeroChiamata() + ' minuti.');
