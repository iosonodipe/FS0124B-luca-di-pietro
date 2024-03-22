import { TestBed } from '@angular/core/testing';

import { FetchCarsService } from './fetch-cars.service';

describe('FetchCarsService', () => {
  let service: FetchCarsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FetchCarsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
