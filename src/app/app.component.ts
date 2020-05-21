import {Component} from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {User} from './classes/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'apna-ecommerce-app';

  /*emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);*/
}
