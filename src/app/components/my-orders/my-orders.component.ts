import { Component, OnInit } from '@angular/core';
import {Order} from '../../classes/order';
import {OrderService} from '../../services/order.service';
import {ShippingDetails} from '../../classes/shipping-details';

@Component({
  selector: 'app-my-orders',
  templateUrl: './my-orders.component.html',
  styleUrls: ['./my-orders.component.css']
})
export class MyOrdersComponent implements OnInit {
  orderArr: Order[];
  objShippingDetails: ShippingDetails;
  username: string;
  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
    this.getOrder();
  }

  getOrder(){
    this.username = sessionStorage.getItem('username');
    this.orderService.getOrderByUserName(this.username).subscribe(data => { this.orderArr = data; });
  }

}
