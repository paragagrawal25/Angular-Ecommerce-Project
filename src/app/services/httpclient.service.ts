import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

export class Employee{
  constructor(
    public empId:string,
    public name:string,
    public designation:string,
    public salary:string,
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(
    private httpClient:HttpClient
  ) {
     }



     /*getEmployees()
  {
    let username='javainuse'
    let password='password'

    //const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    const headers = new HttpHeaders({ Authorization: 'Bearer ' + sessionStorage.getItem('token') });

       return this.httpClient.get<Employee[]>('http://localhost:1212/employees',{headers});
  }

  public deleteEmployee(employee) {
    let username='javainuse'
    let password='password'

   // const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    const headers = new HttpHeaders({ Authorization: 'Bearer ' + sessionStorage.getItem('token') });
    return this.httpClient.delete<Employee>("http://localhost:1212/employees" + "/"+ employee.empId,{headers});
  }

  public createEmployee(employee) {
    let username='javainuse'
    let password='password'

    //const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    const headers = new HttpHeaders({ Authorization: 'Bearer ' + sessionStorage.getItem('token') });
    return this.httpClient.post<Employee>("http://localhost:1212/employees", employee,{headers});
  }*/
}
