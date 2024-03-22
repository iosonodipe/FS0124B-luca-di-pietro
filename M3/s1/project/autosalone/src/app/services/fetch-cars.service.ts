import { iCar } from './../models/icar';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FetchCarsService {

  getAllCars():Promise<iCar[]>{
    return fetch('../../assets/db.json')
    .then(res => res.json())
    .then((cars: iCar[]) => cars)
  }

  getAllBrands():Promise<iCar[]>{
    return this.getAllCars()
    .then(cars => cars.filter(car => car.brand))
  }

}

