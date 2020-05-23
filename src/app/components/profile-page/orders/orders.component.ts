import { Component, OnInit } from '@angular/core';
import {Order} from '../../../classes/order';
import {OrderService} from '../../../services/order.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

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
