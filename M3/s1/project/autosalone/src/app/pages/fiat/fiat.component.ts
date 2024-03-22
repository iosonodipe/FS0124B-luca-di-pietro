import { Component } from '@angular/core';
import { FetchCarsService } from '../../services/fetch-cars.service';
import { iCar } from '../../models/icar';

@Component({
  selector: 'app-fiat',
  templateUrl: './fiat.component.html',
  styleUrl: './fiat.component.scss'
})
export class FiatComponent {
  brandCarsArray: iCar[] = []
  constructor(private fetch: FetchCarsService){}

  ngOnInit(){
    this.fetch.getBrandCars("Fiat")
    .then(cars => this.brandCarsArray = cars)
  }
}
