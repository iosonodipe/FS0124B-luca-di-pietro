import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { iCar } from '../../models/icar';
import { FetchCarsService } from '../../services/fetch-cars.service';

@Component({
  selector: 'app-dettaglio',
  templateUrl: './dettaglio.component.html',
  styleUrl: './dettaglio.component.scss',
})
export class DettaglioComponent {
  carDetail: iCar | undefined = undefined;
  constructor(
    private router: ActivatedRoute,
    private fetch: FetchCarsService
  ) {}

  ngOnInit() {
    this.router.params.subscribe((id: any) => {
      this.fetch.getCarById(id.id).then((car) => (this.carDetail = car));
    });
  }
}
