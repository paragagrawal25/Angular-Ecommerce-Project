import { Component, OnInit } from '@angular/core';
import {ProductsService} from '../../services/products.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductCatalogue} from '../../classes/product-catalogue';
import {Cart} from '../../classes/cart';
import {CartService} from '../../services/cart.service';
import {CartHelper} from '../../classes/cart-helper';

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
              private router: Router) {
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
    this.initializeCartHelper();
    // console.log(this.cartHelper);
    this.cartService.addCart(this.cartHelper)
      .subscribe(data => console.log(data), error => console.log(error));
    alert('Your item has been successfully added to Cart');
    // this.router.navigateByUrl(`/cart/${this.username}`);
  }

  handleBuyNowObjects(){
    this.initializeCartHelper();
    // console.log(this.cartHelper);
    this.cartService.addCart(this.cartHelper)
      .subscribe(data => console.log(data), error => console.log(error));
    // this.router.navigateByUrl(`/cart/${this.username}`);
  }

  initializeCartHelper(){
    this.cartHelper.customerUserName = this.username;
    this.cartHelper.productId = this.productId;
    this.cartHelper.quantity = 1;
  }
}
