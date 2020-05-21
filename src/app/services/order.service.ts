import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ShippingDetails} from '../classes/shipping-details';
import {Observable} from 'rxjs';
import {Order} from '../classes/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private baseUrl = 'http://localhost:1115/orders';
  private baseUrlGet = 'http://localhost:8086/ordersByUserName';

  constructor(private httpClient: HttpClient) { }

  createShippingDetails(objCheckout: ShippingDetails, username: string): Observable<Object> {
    return this.httpClient.post(`${this.baseUrl}?userName=${username}`, objCheckout);
  }

  getOrderByUserName(username: string): Observable<Order[]> {
    return this.httpClient.get<Order[]>(`${this.baseUrlGet}/${username}`);
  }

}
