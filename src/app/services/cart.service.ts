import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Cart} from '../classes/cart';
import {CartHelper} from '../classes/cart-helper';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private baseUrl = 'http://localhost:8086/cart';
  private baseUrl1 = 'http://localhost:1115/cart';

  constructor(private httpClient: HttpClient) { }

  // getCartByName(customerUserName: string): Observable<Object> {
  //  return this.httpClient.get(`${this.baseUrl}/${customerUserName}`);
  // }

  getCartByName(customerUserName: string): Observable<Cart> {
    const cartUrl = `${this.baseUrl}/${customerUserName}`;
    return this.httpClient.get<Cart>(cartUrl);
  }

  addCart(cart: CartHelper): Observable<any> {
    console.log(cart);
    return this.httpClient.post(`${this.baseUrl1}`, cart);
  }
}
