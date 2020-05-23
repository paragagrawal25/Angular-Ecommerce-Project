import { Component, OnInit } from '@angular/core';
import {Order} from '../../classes/order';
import {OrderService} from '../../services/order.service';
import {ShippingDetails} from '../../classes/shipping-details';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-my-orders',
  templateUrl: './my-orders.component.html',
  styleUrls: ['./my-orders.component.css']
})
export class MyOrdersComponent implements OnInit {
  orderArr: Order;
  id: number;
  objShippingDetails: ShippingDetails;
  username: string;
  constructor(private orderService: OrderService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      console.log(params);
      this.id = params.data;
    });
    console.log(this.id);
    this.getOrder(this.id);
  }

  getOrder(id: number){
    this.username = sessionStorage.getItem('username');
    this.orderService.getOrderById(id).subscribe(data => { this.orderArr = data; });
  }
}
