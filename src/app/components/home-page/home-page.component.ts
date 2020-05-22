import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ProductCatalogue} from "../../classes/product-catalogue";
import {ProductsService} from "../../services/products.service";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  userName = '';

  constructor(private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    // console.log(this.route.snapshot.params['name']);
    this.userName = this.route.snapshot.params['name'];
  }
}
