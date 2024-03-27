import { Component } from '@angular/core';
import { iProduct } from '../../models/product';
import { DataService } from '../../data.service';

@Component({
  selector: 'app-preferiti',
  templateUrl: './preferiti.component.html',
  styleUrl: './preferiti.component.scss'
})
export class PreferitiComponent {
  favProducts!: iProduct[]

  constructor(private svc: DataService){}

  ngOnInit(){
    this.favProducts = this.svc.getFavs()
  }
}
