import { Component, OnInit } from '@angular/core';
import { DataService } from '../../data.service';
import { iProduct } from '../../models/product';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {

  constructor(private svc:DataService){}
  productsArr!: iProduct[]

  ngOnInit(): void {
    this.svc.getAllProducts().subscribe(json => this.productsArr = json.products)
  }

}
