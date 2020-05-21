import {Component, OnInit} from '@angular/core';
import {ProductsService} from '../../services/products.service';
import {ProductCatalogue} from '../../classes/product-catalogue';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products: ProductCatalogue[];
  categoryId: number;
  categoryMode = false;

  constructor(private productService: ProductsService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    });
  }

  listProducts(){
    this.categoryMode = this.route.snapshot.paramMap.has('id');
    // console.log(this.categoryMode);
    if (this.categoryMode){
      this.handleListProductsByCategory();
    }
    else{
      this.handleListProducts();
    }
  }

  handleListProducts() {
    this.productService.getProducts().subscribe(data => {
      this.products = data;
    });
  }

  handleListProductsByCategory() {
    this.categoryId = +this.route.snapshot.paramMap.get('id');
    console.log(this.categoryId);
    this.productService.getProductListByCategory(this.categoryId).subscribe(data => {
      // console.log(data);
      this.products = data;
    });
  }
}
