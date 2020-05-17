export class Product {
  private _productId: number;
  private _productName: string;
  private _productPrice: number;
  private _quantity: number;

  get productId(): number {
    return this._productId;
  }

  set productId(value: number) {
    this._productId = value;
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

  get quantity(): number {
    return this._quantity;
  }

  set quantity(value: number) {
    this._quantity = value;
  }
}
