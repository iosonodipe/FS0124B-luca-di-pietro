import { Component, EventEmitter, Input, Output } from '@angular/core';
import { iProduct } from '../../models/product';
import { DataService } from '../../data.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrl: './card.component.scss'
})
export class CardComponent {
  @Input() product!: iProduct

  constructor(private svc: DataService){}
  // favourites: iProduct[] = []

  pushFavourite(product: iProduct):void{
    this.svc.pushFavs(product)
  }
}
