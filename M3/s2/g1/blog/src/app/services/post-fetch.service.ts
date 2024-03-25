import { Injectable } from '@angular/core';
import { iPost } from '../modules/post';
import { iJsonContent } from '../modules/json-content';

@Injectable({
  providedIn: 'root'
})
export class PostFetchService {

  getAllPosts():Promise<iPost[]>{
    return fetch('../assets/db.json')
    .then(res => res.json())
    .then((res:iJsonContent) => res.posts)
  }

  getActivePosts():Promise<iPost[]>{
    return this.getAllPosts()
    .then(res => res.filter(post => post.active))
  }

  getInactivePosts():Promise<iPost[]>{
    return this.getAllPosts()
    .then(res => res.filter(post => !post.active))
  }
}
