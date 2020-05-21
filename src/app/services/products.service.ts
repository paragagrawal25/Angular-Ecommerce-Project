import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {ProductCatalogue} from '../classes/product-catalogue';
import {ProductCategory} from '../classes/product-category';
import {Product} from '../classes/product';


@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  private baseUrl = 'http://localhost:8082/api/products';
  private categoryUrl = 'http://localhost:8082/api/product-category';

  constructor(private httpClient: HttpClient) { }

  getProduct(theProductId: number): Observable<ProductCatalogue> {

    // need to build URL based on product id
    const productUrl = `${this.baseUrl}/${theProductId}`;

    return this.httpClient.get<ProductCatalogue>(productUrl);
  }

  getProducts(): Observable<any> {
    return this.httpClient.get<GetResponseProducts>(`${this.baseUrl}`).pipe(
      map(response => response._embedded.products)
    );
  }

  getProductListByCategory(theCategoryId: number): Observable<any> {

    // need to build URL based on category id
    const searchUrl = `${this.baseUrl}/search/findByCategory_Id?id=${theCategoryId}`;
    return this.httpClient.get<GetResponseProducts>(searchUrl).pipe(map(response => response._embedded.products));
  }

  getProductCategories(): Observable<ProductCategory[]> {
    return this.httpClient.get<GetResponseProductCategory>(this.categoryUrl).pipe(
      map(response => response._embedded.productCategory)
    );
  }
}

interface GetResponseProducts {
  _embedded: {
    products: ProductCatalogue[];
  };
}

interface GetResponseProductCategory {
  _embedded: {
    productCategory: ProductCategory[];
  };
}
