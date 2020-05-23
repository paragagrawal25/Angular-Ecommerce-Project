import { Component, OnInit } from '@angular/core';
import {OrderService} from '../../services/order.service';
import {Order} from '../../classes/order';
import {Router} from "@angular/router";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  objOrder: Order[];
  username: string;
  constructor(private orderService: OrderService, private router: Router) { }

  ngOnInit(): void {
    this.getOrder();
  }

  getOrder(){
    this.username = sessionStorage.getItem('username');
    this.orderService.getOrderByUserName(this.username).subscribe(data => { this.objOrder = data; });
  }

  passId(id: number){
    console.log(id);
    this.username = sessionStorage.getItem('username');
    this.router.navigate([`/my-orders-detail/${this.username}`], {
      queryParams: {data: id}
    });
  }
}
