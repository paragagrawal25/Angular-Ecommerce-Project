import {Component, Input, OnInit} from '@angular/core';
import {ShippingDetails} from '../../classes/shipping-details';
import {OrderService} from '../../services/order.service';
import {FormBuilder, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from '@angular/router';
import {CartService} from "../../services/cart.service";
import {Cart} from "../../classes/cart";
import Swal from "sweetalert2";

@Component({
  selector: 'app-payment-gateway',
  templateUrl: './payment-gateway.component.html',
  styleUrls: ['./payment-gateway.component.css']
})
export class PaymentGatewayComponent implements OnInit {

  objCheckout: ShippingDetails;
  username: string;

  constructor(private router: Router, private route: ActivatedRoute,
              private orderService: OrderService) {
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      console.log(params);
      this.objCheckout = JSON.parse(atob(params.data));
    });
  }

  save() {
    this.username = sessionStorage.getItem('username');
    this.objCheckout.email = this.username;
    this.orderService.createShippingDetails(this.objCheckout, this.username)
      .subscribe(data => console.log(data), error => console.log(error));
    this.objCheckout = new ShippingDetails();
    Swal.fire({
      title: '<strong>Order Successfully Placed</strong>',
      icon: 'success',
      showConfirmButton: false,
      padding: '5em',
      html:
        'Go to HomePage , ' +
        '<a href="/home-page">HomePage</a> ',
      });
  }
}
