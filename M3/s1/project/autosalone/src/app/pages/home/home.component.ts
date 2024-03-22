import { Component } from '@angular/core';
import { FetchCarsService } from '../../services/fetch-cars.service';
import { iCar } from '../../models/icar';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  brandsArray: string[] = [];
  randomCars: iCar[] = [];
  randomNumbers: number[] = []

  constructor(private fetch: FetchCarsService) {}

  ngOnInit() {
    this.fetch.getAllBrandsImages()
    .then(brands => this.brandsArray = brands);
    this.get2RandomCars()
  }

  get2RandomCars():void{
    this.fetch.getAllCars()
    .then(cars => {
      do {
        let ran= Math.floor(Math.random()*cars.length)
        if (!this.randomNumbers.includes(ran)) {
          this.randomNumbers.push(ran)
          this.randomCars.push(cars[ran])
        }
      } while (this.randomCars.length < 2);
    })
  }
}
