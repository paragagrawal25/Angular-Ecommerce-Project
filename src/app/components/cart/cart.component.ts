import { Component, OnInit } from '@angular/core';
import {Cart} from '../../classes/cart';
import {CartService} from '../../services/cart.service';
import {Observable} from 'rxjs';
import {Product} from '../../classes/product';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  objCart: Cart;
  objProduct: Product;
  username: string;

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
   this.listCart();
  }

  listCart() {
    // const theProductId: number = +this.route.snapshot.paramMap.get('id');
    this.username = sessionStorage.getItem('username');
    this.cartService.getCartByName(this.username).subscribe(data => {
      this.objCart = data;
          });
  }
}
