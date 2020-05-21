import { Component, OnInit } from '@angular/core';
import {Customer} from '../../../classes/customer';
import {ActivatedRoute, Router} from '@angular/router';
import {CustomerService} from '../../../services/customer.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  citiesByState = {
    Odisha: ['Bhubaneswar', 'Puri', 'Cuttack'],
    Maharashtra: ['Mumbai', 'Pune', 'Nagpur'],
    Kerala: ['kochi']
  };

  userName: string;
  customer: Customer;
  submitted = false;

  cities: string[][

    ];

  constructor(private route: ActivatedRoute, private router: Router,
              private customerService: CustomerService) { }


  ngOnInit(): void {
    this.customer = new Customer();
    this.userName = this.route.snapshot.params['userName'];

    this.customerService.getCustomer(this.userName)
      .subscribe(data => {
        console.log(data);
        this.customer = data;
      }, error => console.log(error));
  }

  updateCustomer() {
    this.customerService.updateCustomer(this.userName, this.customer)
      .subscribe(data => console.log(data), error => console.log(error));
    // this.customer = new Customer();
  }

  onSubmit() {
    this.submitted = true;
    this.updateCustomer();
    alert('Your Details has been updated successfully');
  }

  displayState(event)
  {
    this.cities = this.citiesByState[event.target.value];
    console.log(this.cities);
  }

  displayCity(event)
  {
    console.log(event.target.value);
  }
}
