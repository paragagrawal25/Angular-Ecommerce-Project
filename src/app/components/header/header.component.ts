import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {LoginComponent} from '../login/login.component';
import {AuthenticationService} from '../../services/authentication.service';
import {Customer} from '../../classes/customer';
import {Router} from '@angular/router';
import {Cart} from '../../classes/cart';
import {CartService} from '../../services/cart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isUserLoggedIn = false;
  username: string;
  cart: Cart = new Cart();
  cartBadge: Cart;

  constructor(private authenticationService: AuthenticationService,
              private router: Router,
              private cartService: CartService) { }

  ngOnInit(): void {
    this.isUserLoggedIn = this.authenticationService.isUserLoggedIn();
    console.log(this.isUserLoggedIn);
    // this.getBadgeCount();
    this.username = sessionStorage.getItem('username');
    // this.getCart();
  }

  getBadgeCount() {
    this.username = sessionStorage.getItem('username');
    this.cartService.getCartByName(this.username).subscribe( data => {
      this.cartBadge = data; this.getCart(this.cartBadge);
    });
  }

  showAcc(username: string) {
    this.router.navigate(['profile', username]);
  }

  getCart(cart1: Cart){
    return cart1.productList.length;
  }

  findProduct(searchKeyword: string) {
    if (searchKeyword.length > 0) {
      this.router.navigateByUrl(`/search-products/${searchKeyword}`);
      console.log(searchKeyword);
    }
    else {
      this.router.navigateByUrl(`/products`);
    }

  }
  /*openDialog() {
    const dialogRef = this.dialog.open('./login.component.html');

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }*/
}
