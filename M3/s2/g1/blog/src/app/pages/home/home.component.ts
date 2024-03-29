import { Component } from '@angular/core';
import { iPost } from '../../modules/post';
import { PostFetchService } from '../../services/post-fetch.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  postsCollection: iPost[] = [];
  randomPostsCollection: iPost[] = [];
  random: number = 0;
  show: boolean = false;
  constructor(private postsFetch: PostFetchService) {}

  ngOnInit() {
    this.postsCollection = this.postsFetch.getAllPosts();
    this.get4Posts();
    // setInterval(() => {
    //   console.log(this.show);
    // }, 3000
    // )
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

  editPost(event: string){
    console.log(event);

  }
}
