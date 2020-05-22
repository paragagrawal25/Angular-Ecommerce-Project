import { Component, OnInit } from '@angular/core';
import {ShippingDetails} from '../../classes/shipping-details';
import {Cart} from '../../classes/cart';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {OrderService} from '../../services/order.service';
import {Router} from '@angular/router';
import {CartService} from '../../services/cart.service';

@Component({
  selector: 'app-check-out',
  templateUrl: './check-out.component.html',
  styleUrls: ['./check-out.component.css']
})
export class CheckOutComponent implements OnInit {

  objCheckout: ShippingDetails = new ShippingDetails();
  submitted = false;
  objCart: Cart;
  myForm: FormGroup;
  username: string;

  constructor(private orderService: OrderService, private formBuilder: FormBuilder,
              private router: Router, private cartService: CartService) {
  }
  ngOnInit() {
    this.username = sessionStorage.getItem('username');
    this.getCart();
    this.myForm = this.formBuilder.group({

      firstName: [null, [Validators.required, Validators.maxLength(15), Validators.minLength(2)]],
      lastName: [null, [Validators.required, Validators.maxLength(15), Validators.minLength(2)]],
      customerUserName: [null, [Validators.required, Validators.email]],
      phoneNo: [null, Validators.required],
      addressLine1: [null, Validators.required],
      addressLine2: [null],
      country: [null, Validators.required],
      state: [null, Validators.required],
      city: [null, Validators.required],
      zipCode: [null, Validators.required]
    });
  }

  onSubmit() {
    this.save();
    alert('SUCCESS!! :-)');
  }


  save() {
    this.objCheckout.email = this.username;
    this.orderService.createShippingDetails(this.objCheckout, this.username)
      .subscribe(data => console.log(data), error => console.log(error));
    this.objCheckout = new ShippingDetails();
  }

  getCart() {
    this.username = sessionStorage.getItem('username');
    this.cartService.getCartByName(this.username).subscribe(data => {
      this.objCart = data;
    });
    console.log(this.objCart);
  }
}
