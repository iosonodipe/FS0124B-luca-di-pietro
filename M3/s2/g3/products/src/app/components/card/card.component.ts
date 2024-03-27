import { Component, EventEmitter, Input, Output } from '@angular/core';
import { iProduct } from '../../models/product';
import { DataService } from '../../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrl: './card.component.scss'
})
export class CardComponent {
  @Input() product!: iProduct
  url: string = this.route.url

  constructor(private svc: DataService, private route: Router){}
  // favourites: iProduct[] = []

  pushFavourite(product: iProduct):void{
    this.svc.pushFavs(product)
  }
}
