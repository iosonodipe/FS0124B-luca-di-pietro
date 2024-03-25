import { Component } from '@angular/core';
import { iPost } from '../../modules/post';
import { PostFetchService } from '../../services/post-fetch.service';

@Component({
  selector: 'app-inactive-posts',
  templateUrl: './inactive-posts.component.html',
  styleUrl: './inactive-posts.component.scss'
})
export class InactivePostsComponent {
  inactivePostsCollection: iPost[] = []
  constructor(private fetchPosts: PostFetchService){}

  ngOnInit(){
    this.fetchPosts.getInactivePosts()
    .then(post => this.inactivePostsCollection = post)
  }
}
