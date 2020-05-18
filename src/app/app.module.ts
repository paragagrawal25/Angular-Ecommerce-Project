import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { ProductsComponent } from './components/products/products.component';
import { PaymentComponent } from './components/payment/payment.component';
import { InvoiceComponent } from './components/invoice/invoice.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatSelectModule } from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { CheckOutComponent } from './components/check-out/check-out.component';
import { OrderComponent } from './components/order/order.component';
import { CartComponent } from './components/cart/cart.component';
import { SearchProductComponent } from './components/search-product/search-product.component';
import { ProductsByCategoryComponent } from './components/products-by-category/products-by-category.component';
import {ProfilePageComponent} from './components/profile-page/profile-page.component';
import {OrdersComponent} from './components/profile-page/orders/orders.component';
import {ProfileComponent} from './components/profile-page/profile/profile.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'home-page', component: HomePageComponent },
  { path: 'profile', component: ProfilePageComponent},
  { path: 'cart', component: CartComponent},
  { path: 'checkout', component: CheckOutComponent},
  { path: 'my-orders/:username', component: OrderComponent},
  { path: 'product-details', component: ProductDetailsComponent},
  { path: 'products', component: ProductsComponent},
  { path: 'products-by-category/:categoryId', component: ProductsByCategoryComponent},
  { path: 'search-products/:searchKeyword', component: SearchProductComponent},
  { path: 'about-us', component: AboutUsComponent},
  { path: 'orders', component: OrdersComponent}
  /*{ path: '/!**', component: HomePageComponent}*/
];

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    AboutUsComponent,
    ProductsComponent,
    PaymentComponent,
    InvoiceComponent,
    RegisterComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    ProductDetailsComponent,
    CheckOutComponent,
    OrderComponent,
    CartComponent,
    SearchProductComponent,
    ProductsByCategoryComponent,
    ProfilePageComponent,
    OrdersComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    NoopAnimationsModule,
    MatSelectModule,
    MatInputModule,
    RouterModule.forRoot(routes),
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
