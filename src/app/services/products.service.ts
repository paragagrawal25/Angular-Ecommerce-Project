import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {ProductCatalogue} from '../classes/product-catalogue';
import {ProductCategory} from '../classes/product-category';


@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  private baseUrl = 'http://localhost:8082/api/products';
  private categoryUrl = 'http://localhost:8082/api/product-category';
  private productAddUrl = 'http://localhost:8081/products';
  private searchUrl = 'http://localhost:8082/api/products/search/findByProductNameContaining';

  constructor(private httpClient: HttpClient) { }

  addProduct(product: ProductCatalogue): Observable<any>{
    console.log(product);
    return this.httpClient.post(`${this.productAddUrl}`, product, {responseType: 'text'});
  }

  getProduct(theProductId: number): Observable<any> {
    // need to build URL based on product id
    const productUrl = `${this.baseUrl}/${theProductId}`;

    return this.httpClient.get<ProductCatalogue>(productUrl);
  }

  deleteProduct(theProductId: number): Observable<any> {
    // need to build URL based on product id
    // console.log(theProductId);
    const productDeleteUrl = `${this.productAddUrl}?productId=${theProductId}`;
    // console.log(productDeleteUrl);
    return this.httpClient.delete(productDeleteUrl, {responseType: 'text'});
  }

  getProducts(): Observable<any> {
    return this.httpClient.get<GetResponseProducts>(`${this.baseUrl}`).pipe(
      map(response => response._embedded.products)
    );
  }

  getAllProducts(): Observable<any> {
    return this.httpClient.get<GetResponseProducts>(`${this.baseUrl}?size=1000`).pipe(
      map(response => response._embedded.products)
    );
  }
  getProductListByCategory(theCategoryId: number): Observable<any> {

    // need to build URL based on category id
    const searchUrl = `${this.baseUrl}/search/findByCategory_Id?id=${theCategoryId}`;
    return this.httpClient.get<GetResponseProducts>(searchUrl).pipe(map(response => response._embedded.products));
  }

  getProductCategories(): Observable<any> {
    return this.httpClient.get<GetResponseProductCategory>(this.categoryUrl).pipe(
      map(response => response._embedded.productCategory)
    );
  }

  searchProducts(keyword: string): Observable<any> {
    return this.httpClient.get<GetResponseProducts>(`${this.searchUrl}?name=${keyword}`).pipe(
      map(response => response._embedded.products)
    );
  }
}

interface GetResponseProducts {
  _embedded: {
    products: ProductCatalogue[];
  };
  page: {
    size: number;
    totalElements: number;
    totalPages: number;
    number: number;
  };
}

interface GetResponseProductCategory {
  _embedded: {
    productCategory: ProductCategory[];
  };
}
