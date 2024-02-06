// !SPREAD OPERATOR
const user = {
  name: "Lidia",
  email: "lidia@email.com",
};

const userDetails = {
  ...user,
  email: "lidia@email.it",
  classe: "FS0124B",
  role: "docente",
};

user.email = "Pippo";
console.log(userDetails); //non cambia

const lettere = ["a", "b", "c", "d", "e"];
const altreLett = ["f", "g", "h", "i"];
// lettere.push("f", "g") -> cambia l'array originale
const completo = [...lettere, ...altreLett];

// !REST PARAMETERS

const sumWithText = function (text, ...numeri) {
  let sum = 0;
  for (let i = 0; i < numeri.length; i++) {
    sum += numeri[i];
  }
};

sumWithText("pippo", 34, 12, 67, 8, 12, 90);

// !DESTRUTTURAZIONE

const utente = {
  name: "Lidia",
  role: "docente",
  classi: [
    { name: "0522" },
    { name: "0822" },
    { name: "0123" },
    { name: "0623" },
  ],
};

// utente.name = "pippo"
const { role, classi } = utente;

// const name = utente.name
// const role = utente.role
// const classi = utente.classi

console.log(classi);
for (let i = 0; i < utente.classi.length; i++) {
  //   console.log(utente.classi[i]);
}

const [primo, secondo, , quarto] = [1, 2, 3, 4, 5, 6];
// const primo = arr[0]

// !TEMPLATE LITERALS
// Backtick:
//  - alt+96 su windows, option + 9 su mac
//  - (Layout US) => su tasto, accanto all'1
//  - estensione

const creaStringa = (utente) => {
  //   return (
  //     "L'utente " +
  //     utente.nome +
  //     " con email " +
  //     utente.email +
  //     " ha il ruolo di: " +
  //     utente.ruolo
  //   );
  return `L'utente ${utente.nome} con email ${utente.email} ha il ruolo di: ${utente.ruolo}`;
};

console.log(
  creaStringa({ nome: "Lidia", ruolo: "docente", email: "lidia@lidia.it" })
);

const nomi = [
  "Lidia",
  "Aleksander",
  "Alessandro",
  "Andrea",
  "Antonio",
  "Christian",
];

// const ul = document.getElementById("templateLiteral");
// for (let i = 0; i < nomi.length; i++) {
//   // ul.innerHTML = "<li>" + nomi[i] + "</li>"
//   ul.innerHTML += `<li> ${nomi[i]} </li>`;
// }

// ! METODI ARRAY:

/* 
    - push
    - pop 
    - reverse 
    // - split 
    - slice
    - splice
    - shift / unshift
    - join
    - includes
    Array.metodo()

*/

// ! () => funzione a freccia
//  (parametri) => valore di ritorno

// const sum = (a,b) => {return a+b}
const sum = (a, b) => a + b;

const fiori = ["margherita", "rosa", "tulipano", "pippo", "paperino"];

// const paperino = "paperino"
// const arr = paperino.split("") // ["p", "a", "p", "e", "r", "i", "n", "o"]
// arr.pop()
// ___.innerText = arr.join("")

fiori.slice(2);
// tulipano, pippo, paperino

// !.forEach

const todos = [
  {
    userId: 1,
    id: 1,
    title: "delectus aut autem",
    completed: false,
  },
  {
    userId: 1,
    id: 2,
    title: "quis ut nam facilis et officia qui",
    completed: false,
  },
  {
    userId: 1,
    id: 3,
    title: "fugiat veniam minus",
    completed: false,
  },
  {
    userId: 1,
    id: 4,
    title: "et porro tempora",
    completed: true,
  },
  {
    userId: 1,
    id: 5,
    title: "laboriosam mollitia et enim quasi adipisci quia provident illum",
    completed: false,
  },
  {
    userId: 1,
    id: 6,
    title: "qui ullam ratione quibusdam voluptatem quia omnis",
    completed: false,
  },
  {
    userId: 1,
    id: 7,
    title: "illo expedita consequatur quia in",
    completed: false,
  },
  {
    userId: 1,
    id: 8,
    title: "quo adipisci enim quam ut ab",
    completed: true,
  },
  {
    userId: 1,
    id: 9,
    title: "molestiae perspiciatis ipsa",
    completed: false,
  },
  {
    userId: 1,
    id: 10,
    title: "illo est ratione doloremque quia maiores aut",
    completed: true,
  },
];

// for(let i = 0; i < todos.length; i++) {
//     const todo = todos[i]

// }

todos.forEach((todo) => console.log("Equivalente di todos[i]: ", todo));

const nuovoArray = todos.map((todo) => todo.title);
console.log(nuovoArray);

const tuttoMaiusc = todos.map((todo) => {
  return {
    ...todo,
    title: todo.title.toUpperCase(),
  };
});

// const tuttoMaiusc2 = todos.map((todo) => ({
//   ...todo,
//   title: todo.title.toUpperCase(),
// }));

const ul = document.getElementById("templateLiteral");
const html = todos.map((todo) => `<li> ${todo.title} </li>`);
console.log(html);

ul.innerHTML = html.join("");

const filtrato = todos.filter((todo) => todo.completed);
console.log(filtrato);

const trovato = todos.find((todo) => todo.id === 1 )
console.log(trovato)




const nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 2, 3, 4];
// nums.map(num => num+4)
const indexes = [];
nums.forEach((num, i) => {
  // nums[i] => num
  if (num === 9) {
    indexes.push(i);
  }
});

// const shopping = {
//   email: "pippo@pippo.it",
//   carrello: [12, 45, 99, 1, 0.5],
// };

// const tot = shopping.carrello.reduce((temp, curr) => temp + curr, 0);
// console.log(tot);

const carrello = [
  {
    id: 1,
    title: "iPhone 9",
    price: 549,
  },
  {
    id: 2,
    title: "iPhone X",
    price: 899,
  },
  {
    id: 3,
    title: "Samsung Universe 9",
    price: 1249,
  },
  {
    id: 4,
    title: "OPPOF19",
    price: 280,
  },
  {
    id: 5,
    title: "Huawei P30",
    price: 499,
  },
  {
    id: 6,
    title: "MacBook Pro",
    price: 1749,
  },
];

const fn = (temp, curr) => temp + curr.price;
const totaleCarrello = carrello.reduce(fn, 0);

console.log(totaleCarrello);
// Equivalente di:
// let temp = 0
// for(let i = 0; i < carrello.length; i++) {
//     temp += carrello[i]
// }

const nomi2 = [
  "luca nervi",
  "paolo bitta",
  "silvano",
  "patty",
  "andrea",
  "luca nervi",
];

const existsIn = (arr, el) => {
  const index = arr.indexOf(el);
  if (index !== -1) {
    return index;
  } else return false;
};

const indiceTrovato = todos.findIndex((todo) => todo.id === 1)
console.log(indiceTrovato)

console.log(existsIn(nomi2, "emma")); //false
console.log(existsIn(nomi2, "luca nervi")); //0
console.log(existsIn(nomi2, "patty")); //3

nomi2.every((nome) => nome.includes("p")); //false
nomi2.every((nome) => nome.includes("a")); //true

nomi2.some((nome) => nome.includes("p")); //true
nomi2.some((nome) => nome.includes("z")); //false
