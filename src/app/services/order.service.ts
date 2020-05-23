import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ShippingDetails} from '../classes/shipping-details';
import {Observable} from 'rxjs';
import {Order} from '../classes/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private baseUrl = 'http://localhost:8085/orders';
  private baseUrlGet = 'http://localhost:8086/ordersByUserName';

  constructor(private httpClient: HttpClient) { }

  createShippingDetails(objCheckout: ShippingDetails, username: string): Observable<any> {
    return this.httpClient.post(`${this.baseUrl}?userName=${username}`, objCheckout, {responseType: 'text'});
  }

  getOrderByUserName(username: string): Observable<any> {
    return this.httpClient.get<Order[]>(`${this.baseUrlGet}?userName=${username}`);
  }

  getAllOrders(): Observable<any> {
    return this.httpClient.get<any>('http://localhost:8086/all-orders');
  }

  getOrderById(id: number): Observable<any> {
    return this.httpClient.get<Order>(`${'http://localhost:8086/orders'}?id=${id}`);
  }
}
