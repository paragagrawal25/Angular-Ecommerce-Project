import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {

  profileCheck = true;
  ordersCheck = false;

  constructor() {
   }

  ngOnInit(): void {
  }


  show(x)
  {
    if (x === 1)
    {
      this.profileCheck = true;
      this.ordersCheck = false;
    }
    else
    {
      this.profileCheck = false;
      this.ordersCheck = true;
    }
  }
}
