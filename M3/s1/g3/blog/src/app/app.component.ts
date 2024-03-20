import { Component } from '@angular/core';
import { iPost } from './modules/post';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  postsCollection: iPost[] = [];
  randomPostsCollection: iPost[] = [];
  random: number = 0;
  ngOnInit() {
    fetch('../assets/db.json')
      .then((posts) => posts.json())
      .then((post) => {
        this.postsCollection = post.posts;
        this.get4Posts();
      });
  }

  getRandom(): number {
    let numero = Math.floor(Math.random() * this.postsCollection.length);
    this.random = numero;
    return numero;
  }

  get4Posts(): void {
    for (let i = 0; i < 4; i++) {
      this.randomPostsCollection.push(this.postsCollection[this.getRandom()]);
    }
  }
}
