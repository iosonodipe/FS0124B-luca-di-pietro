import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { iProduct } from './models/product';
import { iRoot } from './models/root';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http:HttpClient){}
  url: string = "https://dummyjson.com/products"

  getAllProducts():Observable<iRoot>{
    return this.http.get<iRoot>(this.url)
  }
}
