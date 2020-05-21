import { Component, OnInit } from '@angular/core';
import {ShippingDetails} from '../../classes/shipping-details';
import {OrderService} from '../../services/order.service';
import {Router} from '@angular/router';
import {CartService} from '../../services/cart.service';
import {Cart} from '../../classes/cart';

@Component({
  selector: 'app-check-out',
  templateUrl: './check-out.component.html',
  styleUrls: ['./check-out.component.css']
})
export class CheckOutComponent implements OnInit {

  objCheckout: ShippingDetails = new ShippingDetails();
  submitted = false;
  customerUserName: string;
  objCart: Cart;

  constructor(private orderService: OrderService,
              private router: Router, private cartService: CartService) {
  }

  ngOnInit(): void {
    this.getCart();
    this.customerUserName = sessionStorage.getItem('username');
  }

  getCart() {
    this.customerUserName = sessionStorage.getItem('username');
    this.cartService.getCartByName(this.customerUserName).subscribe(data => {
      this.objCart = data;
    });
    console.log(this.objCart);

  }

  newShippingDetails(): void {
    this.submitted = false;
    this.objCheckout = new ShippingDetails();

  }

  save() {
    this.objCheckout.email = this.customerUserName;
    this.orderService.createShippingDetails(this.objCheckout, this.customerUserName)
      .subscribe(data => console.log(data), error => console.log(error));
    this.objCheckout = new ShippingDetails();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
    // alert('Order has been placed successfully');
    // this.router.navigate(['/confirmation']);
  }
}
