import { Component } from '@angular/core';
import { iCar } from '../../models/icar';
import { FetchCarsService } from '../../services/fetch-cars.service';

@Component({
  selector: 'app-ford',
  templateUrl: './ford.component.html',
  styleUrl: './ford.component.scss',
})
export class FordComponent {
  brandCarsArray: iCar[] = [];
  constructor(private fetch: FetchCarsService) {}

  ngOnInit() {
    this.fetch
      .getBrandCars('Ford')
      .then((cars) => (this.brandCarsArray = cars));
  }
}
