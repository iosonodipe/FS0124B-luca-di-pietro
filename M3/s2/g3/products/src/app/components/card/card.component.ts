import { Component, Input } from '@angular/core';
import { iProduct } from '../../models/product';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrl: './card.component.scss'
})
export class CardComponent {
  @Input() products!: iProduct
}
