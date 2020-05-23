import { Component, OnInit } from '@angular/core';
import {User} from '../../classes/user';
import {ContactService} from '../../services/contact.service';

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {

  user: User = new User();
  data: any;
  email: string;
  constructor(private contactService: ContactService) { }

  ngOnInit(): void
  {

  }
  sendEmail(name: string, email: string, phoneNo: number, subject: string, message: string)
  {
    this.user.name = name;
    this.user.email = email;
    this.user.phoneNo = phoneNo;
    this.user.subject = subject;
    this.user.message = message;
    this.contactService.sendEmail(this.user).subscribe( data => {this.data = data; });
  }

}
