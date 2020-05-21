import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Customer} from '../../classes/customer';
import {CustomerService} from '../../services/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  customer: Customer = new Customer();
  submitted = false;

  constructor(private registerService: CustomerService,
              private router: Router) {
  }

  ngOnInit(): void {

  }

  handleRegister(){
    this.registerService.registerCustomer(this.customer)
      .subscribe(data => console.log(data), error => console.log(error));
    this.customer = new Customer();
  }

  onSubmit() {
    this.submitted = true;
    this.handleRegister();
    alert('You are successfully registered');
    this.router.navigate(['/login']);
  }
}
