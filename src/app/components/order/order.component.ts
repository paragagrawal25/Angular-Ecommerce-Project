import { Component, OnInit } from '@angular/core';
import {OrderService} from '../../services/order.service';
import {Order} from '../../classes/order';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  objOrder: Order[];
  username: string;
  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
    this.getOrder();
  }

  getOrder(){
    this.username = sessionStorage.getItem('username');
    this.orderService.getOrderByUserName(this.username).subscribe(data => { this.objOrder = data; });
  }

}
