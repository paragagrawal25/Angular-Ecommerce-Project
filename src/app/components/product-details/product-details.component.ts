import { Component, OnInit } from '@angular/core';
import {ProductsService} from '../../services/products.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductCatalogue} from '../../classes/product-catalogue';
import {Cart} from '../../classes/cart';
import {CartService} from '../../services/cart.service';
import {CartHelper} from '../../classes/cart-helper';
import {MatDialog} from '@angular/material/dialog';
import Swal from 'sweetalert2';
import {AuthenticationService} from "../../services/authentication.service";

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  product: ProductCatalogue = new ProductCatalogue();
  username = '';
  productId: number;
  cartHelper: CartHelper = new CartHelper();

  constructor(private productService: ProductsService,
              private route: ActivatedRoute,
              private cartService: CartService,
              private router: Router,
              private authenticationService: AuthenticationService) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.handleProductDetails();
    });
    this.username = sessionStorage.getItem('username');
  }

  handleProductDetails() {

    // get the "id" param string. convert string to a number using the "+" symbol
    this.productId = +this.route.snapshot.paramMap.get('id');

    this.productService.getProduct(this.productId).subscribe(
      data => {
        this.product = data;
      }
    );
  }

  handleCartObjects(){
    if (this.authenticationService.isUserLoggedIn()) {
      this.initializeCartHelper();
      // console.log(this.cartHelper);
      this.cartService.addCart(this.cartHelper)
        .subscribe(data => console.log(data), error => console.log(error));
      this.showSuccessAlert();
    }
    else {
      this.showErrorAlert();
    }
  }

  showSuccessAlert() {
    Swal.fire('Added Successfully!!', 'Item has been successfully added to cart!', 'success');
  }

  showErrorAlert(){
    Swal.fire({
      title: '<strong>You are not logged in</strong>',
      padding: '5em',
      icon: 'warning',
      html:
        'To add the product into cart , ' +
        '<a href="/login">Login first</a> ',
      showConfirmButton: false
    });
  }


  handleBuyNowObjects(){
    this.initializeCartHelper();
    this.cartService.addCart(this.cartHelper)
      .subscribe(data => console.log(data), error => console.log(error));
  }

  initializeCartHelper(){
    this.cartHelper.customerUserName = this.username;
    this.cartHelper.productId = this.productId;
    this.cartHelper.quantity = 1;
  }
}
