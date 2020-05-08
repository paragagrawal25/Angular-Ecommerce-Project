import { TestBed } from '@angular/core/testing';

import { OrderCartService } from './order-cart.service';

describe('OrderCartService', () => {
  let service: OrderCartService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrderCartService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
