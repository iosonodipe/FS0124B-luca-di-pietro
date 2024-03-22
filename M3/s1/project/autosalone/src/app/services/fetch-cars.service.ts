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

  getAllBrandsImages():Promise<string[]>{
    return this.getAllCars()
    .then(cars => {
      let brandsArray: string[] = []
      cars.forEach((el) => {
        if (!brandsArray.includes(el.brandLogo))
          brandsArray.push(el.brandLogo);
      });
      return brandsArray
    })
  }

  getBrandCars(brand: string):Promise<iCar[]>{
    return this.getAllCars()
    .then(cars => {
      let brandCarsArray: iCar[] = []
      cars.forEach((el) => {
        if (el.brand == brand)
          brandCarsArray.push(el);
      });
      return brandCarsArray
    })
  }

  getCarById(id:number):Promise<iCar | undefined>{
    return this.getAllCars()
    .then(cars => cars.find(car => car.id == id))
  }
}

