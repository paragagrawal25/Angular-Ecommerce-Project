import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Customer} from '../../classes/customer';
import {AuthenticationService} from '../../services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  customer: Customer = new Customer();
  invalidLogin = false;
  // Dependency Injection
  constructor(private router: Router,
              private loginService: AuthenticationService) { }

  ngOnInit() {
  }

  handleLogin(){
    (this.loginService.authenticate(this.customer.userName, this.customer.customerPassword).subscribe(
        data => {
          this.router.navigate(['/home-page']);
          this.invalidLogin = false;
        },
        error => {
          this.invalidLogin = true;
        }
      )
    );
  }
}
