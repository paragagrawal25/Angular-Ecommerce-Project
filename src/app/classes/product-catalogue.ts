import {ProductCategory} from './product-category';

export class ProductCatalogue {
  private _id: string;
  private _productName: string;
  private _productPrice: number;
  private _productImageUrl: string;
  private _productAddDate: Date;
  private _productDescription: string;
  private _productRating: number;
  private _category: ProductCategory[];

  get id(): string {
    return this._id;
  }

  set id(value: string) {
    this._id = value;
  }

  get productName(): string {
    return this._productName;
  }

  set productName(value: string) {
    this._productName = value;
  }

  get productPrice(): number {
    return this._productPrice;
  }

  set productPrice(value: number) {
    this._productPrice = value;
  }

  get productImageUrl(): string {
    return this._productImageUrl;
  }

  set productImageUrl(value: string) {
    this._productImageUrl = value;
  }

  get productAddDate(): Date {
    return this._productAddDate;
  }

  set productAddDate(value: Date) {
    this._productAddDate = value;
  }

  get productDescription(): string {
    return this._productDescription;
  }

  set productDescription(value: string) {
    this._productDescription = value;
  }

  get productRating(): number {
    return this._productRating;
  }

  set productRating(value: number) {
    this._productRating = value;
  }

  get category(): ProductCategory[] {
    return this._category;
  }

  set category(value: ProductCategory[]) {
    this._category = value;
  }
}
