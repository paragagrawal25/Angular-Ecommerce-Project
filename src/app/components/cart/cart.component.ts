import { Component, OnInit } from '@angular/core';
import {Cart} from '../../classes/cart';
import {CartService} from '../../services/cart.service';
import {Observable} from 'rxjs';
import {Product} from '../../classes/product';
import {ActivatedRoute, Router} from '@angular/router';
import {CartHelper} from '../../classes/cart-helper';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  objCart: Cart;
  username: string;
  cartHelper: CartHelper = new CartHelper();

  constructor(private cartService: CartService, private router: Router) { }

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

  onIncrement(tempProduct: Product){
    // console.log(tempProduct);
    let value = tempProduct.quantity;
    value++;
    this.updateCart(value, tempProduct);
  }

  onDecrement(tempProduct: Product){
    let value = tempProduct.quantity;
    value--;
    this.updateCart(value, tempProduct);
  }

  updateCart(value: number, tempProduct: Product) {
    this.cartHelper.quantity = value;
    this.cartHelper.productId = tempProduct.productId;
    this.cartHelper.customerUserName = sessionStorage.getItem('username');
    console.log(this.cartHelper);
    this.cartService.updateCart(this.cartHelper).subscribe(data => (console.log(data)));
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate([`/cart/${this.username}`]);
    });
  }
}
