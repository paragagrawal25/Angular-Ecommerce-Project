import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import {AppComponent} from './app.component';
import {HomePageComponent} from './components/home-page/home-page.component';
import {AboutUsComponent} from './components/about-us/about-us.component';
import {ProductsComponent} from './components/products/products.component';
import {PaymentComponent} from './components/payment/payment.component';
import {InvoiceComponent} from './components/invoice/invoice.component';
import {RegisterComponent} from './components/register/register.component';
import {LoginComponent} from './components/login/login.component';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HeaderComponent} from './components/header/header.component';
import {FooterComponent} from './components/footer/footer.component';
import {ProductDetailsComponent} from './components/product-details/product-details.component';
import {CheckOutComponent} from './components/check-out/check-out.component';
import {OrderComponent} from './components/order/order.component';
import {CartComponent} from './components/cart/cart.component';
import {SearchProductComponent} from './components/search-product/search-product.component';
import {ProductsByCategoryComponent} from './components/products-by-category/products-by-category.component';
import {ProfilePageComponent} from './components/profile-page/profile-page.component';
import {OrdersComponent} from './components/profile-page/orders/orders.component';
import {ProfileComponent} from './components/profile-page/profile/profile.component';
import {AdminPanelComponent} from './components/profile-page/admin-panel/admin-panel.component';
import {MatButtonModule} from '@angular/material/button';
import {MatDialogModule} from '@angular/material/dialog';
import {AuthGuardService} from './services/auth-guard.service';
import {LogoutComponent} from './components/logout/logout.component';
import {MyOrdersComponent} from './components/my-orders/my-orders.component';
import {ContactUsComponent} from './components/contact-us/contact-us.component';
import {PaymentGatewayComponent} from './components/payment-gateway/payment-gateway.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'home-page', component: HomePageComponent},
  {path: 'products', component: ProductsComponent},
  {path: 'products/product-details/:id', component: ProductDetailsComponent},
  {path: 'products/category/:id', component: ProductsComponent},
  {path: 'search-products/:searchKeyword', component: ProductsComponent},
  {path: 'profile/:userName', component: ProfilePageComponent, canActivate: [AuthGuardService]},
  {path: 'cart/:username', component: CartComponent, canActivate: [AuthGuardService]},
  {path: 'checkout/:username', component: CheckOutComponent, canActivate: [AuthGuardService]},
  {path: 'payment-gateway/:username', component: PaymentGatewayComponent, canActivate: [AuthGuardService]},
  {path: 'my-orders/:username', component: OrderComponent, canActivate: [AuthGuardService]},
  {path: 'my-orders-detail/:username', component: MyOrdersComponent, canActivate: [AuthGuardService]},
  {path: 'about-us', component: AboutUsComponent},
  {path: 'orders', component: OrdersComponent, canActivate: [AuthGuardService]},
  {path: 'admin-page', component: AdminPanelComponent},
  {path: 'contact-us', component: ContactUsComponent},
  {path: 'logout', component: LogoutComponent},

  {path: '**', component: HomePageComponent}
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
    ProfileComponent,
    AdminPanelComponent,
    LogoutComponent,
    MyOrdersComponent,
    ContactUsComponent,
    PaymentGatewayComponent
  ],
  imports: [
    BrowserModule,
    NoopAnimationsModule,
    MatSelectModule,
    MatInputModule,
    RouterModule.forRoot(routes),
    FormsModule,
    HttpClientModule,
    MatButtonModule,
    ReactiveFormsModule,
    NgbModule,
  ],
  exports: [
    MatDialogModule
  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
