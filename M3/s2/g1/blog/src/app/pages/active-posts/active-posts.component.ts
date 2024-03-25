import { Component } from '@angular/core';
import { PostFetchService } from '../../services/post-fetch.service';
import { iPost } from '../../modules/post';

@Component({
  selector: 'app-active-posts',
  templateUrl: './active-posts.component.html',
  styleUrl: './active-posts.component.scss'
})
export class ActivePostsComponent {
  activePostsCollection: iPost[] = []
  constructor(private fetchPosts: PostFetchService){}

  ngOnInit(){
    this.activePostsCollection = this.fetchPosts.getActivePosts()
  }
}
