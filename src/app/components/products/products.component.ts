import {Component, OnInit} from '@angular/core';
import {ProductsService} from '../../services/products.service';
import {ProductCatalogue} from '../../classes/product-catalogue';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products: ProductCatalogue[];
  categoryId: number;
  categoryMode = false;
  searchMode = false;

  constructor(private productService: ProductsService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    });
  }

  listProducts(){
    this.searchMode = this.route.snapshot.paramMap.has('searchKeyword');
    this.categoryMode = this.route.snapshot.paramMap.has('id');
    // console.log(this.categoryMode);
    if (this.categoryMode){
      this.handleListProductsByCategory();
    }
    else if (this.searchMode) {
      this.handleSearchProducts();
    }
    else{
      this.handleListProducts();
    }
  }

  handleSearchProducts() {

    const theKeyword: string = this.route.snapshot.paramMap.get('searchKeyword');

    // now search for the products using keyword
    this.productService.searchProducts(theKeyword).subscribe(
      data => {
        this.products = data;
      }
    );
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
