import { Component, OnInit } from '@angular/core';
import {ProductCategory} from '../../classes/product-category';
import {ProductsService} from '../../services/products.service';

@Component({
  selector: 'app-products-by-category',
  templateUrl: './products-by-category.component.html',
  styleUrls: ['./products-by-category.component.css']
})
export class ProductsByCategoryComponent implements OnInit {

  productCategories: ProductCategory[];
  categoryId: number;

  constructor(private productsService: ProductsService) { }

  ngOnInit() {
    this.listProductCategories();
  }

  listProductCategories(){
    this.productsService.getProductCategories().subscribe(
      data => {
        console.log('Product Categories=' + JSON.stringify(data));
        this.productCategories = data;
      }
    );
  }
}
