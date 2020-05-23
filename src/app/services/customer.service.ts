import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseUrl = 'http://localhost:8083/api/customer';

  constructor(private httpClient: HttpClient) {
  }

  getCustomer(userName: string): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}?username=${userName}`);
  }

  registerCustomer(customer: Object): Observable<Object> {
    return this.httpClient.post(`${this.baseUrl}`, customer);
  }

  deleteCustomer(userName: string): Observable<any> {
    return this.httpClient.delete(`${this.baseUrl}/${userName}`, {responseType: 'text'});
  }

  updateCustomer(userName: string, value: any): Observable<any> {
    return this.httpClient.put(`${this.baseUrl}?username=${userName}`, value);
  }
}
