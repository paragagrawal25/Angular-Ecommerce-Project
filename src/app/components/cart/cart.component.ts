import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  /*objCart: Cart;
  objProduct: Product;*/

  constructor() {
  }

  ngOnInit(): void {
    // this.listCart();
  }
}
  // listCart() {
  //  this.objCart = this.cartService.getCartByName("muz7u");
 // }
  // reloadData() {
   /*this.cartService.getCartByName('muz7u').subscribe(data => {this.objCart = data; });
  }

  listCart() {
    // const theProductId: number = +this.route.snapshot.paramMap.get('id');
    this.cartService.getCartByName('muz7u').subscribe(data => {
      this.objCart = data;
          });
  }*/

