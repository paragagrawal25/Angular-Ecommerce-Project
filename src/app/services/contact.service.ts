import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../classes/user";

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  private url = 'http://localhost:9005/contactUs/send-mail';

  constructor(private httpClient: HttpClient) { }

  sendEmail(user: User)
  {
    return this.httpClient.post(this.url, user);
  }
}
