interface iCellulare {
    credito: number;
    numeroChiamate: number;
}

class User implements iCellulare {
    credito: number = 0;
    numeroChiamate: number = 0;

    constructor(private nome: string, private cognome: string) {}

    ricarica(amount: number): void {
        this.credito += amount;
        console.log(`Utente: ${this.nome}, Credito: ${this.credito}$`);
    }

    chiamata(minuti: number): void {
        let check: number = minuti * 0.2;
        if (check <= this.credito) {
            this.credito -= check;
            this.numeroChiamate += minuti;
            console.log(
                `${this.nome} - Chiamata effettuata. Nuovo credito disponibile: ${this.credito}$`
            );
        } else {
            console.log(
                `${this.nome} - Impossibile effettuare la chiamata. L'importo della chiamata è pari a ${check}$, il credito disponibile è di ${this.credito}$.`
            );
        }
    }

    chiama404(): number {
        return this.credito;
    }

    getNumeroChiamata(): number {
        return this.numeroChiamate;
    }

    azzeraChiamate(): void {
        this.numeroChiamate = 0;
    }
}

let luca: User = new User("Luca", "Di Pietro");
let mario: User = new User("Mario", "Rossi");
let paolo: User = new User("Paolo", "Verdi");

luca.ricarica(10);
mario.ricarica(5);
paolo.ricarica(15);

luca.chiamata(5);
luca.chiamata(15);
mario.chiamata(30);
mario.chiamata(10);
paolo.chiamata(50);

console.log('Luca ha un credito di $' + luca.chiama404());
console.log('Mario ha un credito di $' + mario.chiama404());
console.log('Paolo ha un credito di $' + paolo.chiama404());

console.log('Luca ha effettuato chiamate per ' + luca.getNumeroChiamata() + ' minuti.');
console.log('Mario ha effettuato chiamate per ' + mario.getNumeroChiamata() + ' minuti.');
console.log('Paolo ha effettuato chiamate per ' + paolo.getNumeroChiamata() + ' minuti.');
