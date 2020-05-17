import {Product} from './product';

export class Cart {
  private _customerUserName: string;
  private _productList: Product[];
  private _totalPrice: number;

  get customerUserName(): string {
    return this._customerUserName;
  }

  set customerUserName(value: string) {
    this._customerUserName = value;
  }

  get productList(): Product[] {
    return this._productList;
  }

  set productList(value: Product[]) {
    this._productList = value;
  }

  get totalPrice(): number {
    return this._totalPrice;
  }

  set totalPrice(value: number) {
    this._totalPrice = value;
  }
}

