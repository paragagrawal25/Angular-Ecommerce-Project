import {Component, OnInit} from '@angular/core';
import {ProductCatalogue} from '../../../classes/product-catalogue';
import {ProductsService} from '../../../services/products.service';
import {OrderService} from '../../../services/order.service';
import {Order} from '../../../classes/order';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {

  product: ProductCatalogue = new ProductCatalogue();
  products: ProductCatalogue[];
  orders: Order[];

  constructor(private productService: ProductsService,
              private orderService: OrderService) {
  }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.listProducts();
    this.getAllOrders();
  }

  addProduct() {
    this.product.productRating = 3.5;
    console.log(this.product);
    this.productService.addProduct(this.product).subscribe(
      data => console.log(data), error => console.log(error));
    // swal("Here's a message!", "It's pretty, isn't it?")
  }

  listProducts() {
    this.productService.getAllProducts().subscribe(
      data => (console.log(this.products = data)), error => console.log(error));
  }

  deleteProduct(id: number) {
    console.log(id);
    this.productService.deleteProduct(id).subscribe(data => (console.log(data)), error => console.log(error));
    window.location.reload();
    this.reloadData();
  }

  getAllOrders() {
    this.orderService.getAllOrders().subscribe(
      data => (console.log(this.orders = data)), error => console.log(error));
  }
}
