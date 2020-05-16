import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AuthenticateService} from "../../services/authenticate.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userName = 'dummy';
  password = '';
  errorMessage = '<!----- Invalid Credentials -----!>';
  invalidLogin = false;

  // Dependency Injection
  constructor(private router: Router, private authenticateService: AuthenticateService) {
  }

  ngOnInit(): void {
  }

  handleLogin() {
    // if (this.userName === 'dummy' && this.password === 'dummy') {
    if(this.authenticateService.authenticate(this.userName, this.password)){
      // Redirect to welcome page
      this.router.navigate(['welcome', this.userName]);
      this.invalidLogin = false;
    } else {
      this.invalidLogin = true;
    }
  }
}
