import {Component} from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {AuthenticateService} from './services/authenticate.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'apna-ecommerce-app';

  authenticateService: AuthenticateService;

  /*emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);*/
}
