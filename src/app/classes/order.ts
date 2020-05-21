import {ShippingDetails} from './shipping-details';
import {Product} from './product';

export class Order {

  _orderId: number;
  _customerUserName: string;
  _orderDate: Date;
  _orderStatus: string;
  _totalAmount: number;
  _address: ShippingDetails;
  _product: Product[];

  get product(): Product[] {
    return this._product;
  }

  set product(value: Product[]) {
    this._product = value;
  }

  get address(): ShippingDetails {
    return this._address;
  }

  set address(value: ShippingDetails) {
    this._address = value;
  }

// private List<Product> product = new ArrayList<Product>();
  get orderId(): number {
    return this._orderId;
  }

  set orderId(value: number) {
    this._orderId = value;
  }

  get customerUserName(): string {
    return this._customerUserName;
  }

  set customerUserName(value: string) {
    this._customerUserName = value;
  }

  get orderDate(): Date {
    return this._orderDate;
  }

  set orderDate(value: Date) {
    this._orderDate = value;
  }

  get orderStatus(): string {
    return this._orderStatus;
  }

  set orderStatus(value: string) {
    this._orderStatus = value;
  }

  get totalAmount(): number {
    return this._totalAmount;
  }

  set totalAmount(value: number) {
    this._totalAmount = value;
  }

}
