import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  constructor() { }

  authenticate(username, password){
    // console.log('before', + this.isUserLoggedIn());
    if (username === 'dummy' && password === 'dummy') {
      sessionStorage.setItem('authenticatedUser', username);
      // console.log('after', + this.isUserLoggedIn());
      return true;
    }
    return false;
  }

  isUserLoggedIn() {
    const user = sessionStorage.getItem('authenticatedUser');
    return !(user === null);
  }
}
