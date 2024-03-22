import { Component } from '@angular/core';
import { iCar } from '../../models/icar';
import { FetchCarsService } from '../../services/fetch-cars.service';

@Component({
  selector: 'app-audi',
  templateUrl: './audi.component.html',
  styleUrl: './audi.component.scss'
})
export class AudiComponent {
  brandCarsArray: iCar[] = []
  constructor(private fetch: FetchCarsService){}

  ngOnInit(){
    this.fetch.getBrandCars("Audi")
    .then(cars => this.brandCarsArray = cars)
  }
}
