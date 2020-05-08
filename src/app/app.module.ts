import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { ProfileComponent } from './components/profile/profile.component';
import { OrderCartComponent } from './components/order-cart/order-cart.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { ProductsComponent } from './components/products/products.component';
import { PaymentComponent } from './components/payment/payment.component';
import { LoginRegisterComponent } from './components/login-register/login-register.component';
import { InvoiceComponent } from './components/invoice/invoice.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    ProfileComponent,
    OrderCartComponent,
    AboutUsComponent,
    ProductsComponent,
    PaymentComponent,
    LoginRegisterComponent,
    InvoiceComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
