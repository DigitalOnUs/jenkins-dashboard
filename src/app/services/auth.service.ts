import { Injectable } from '@angular/core';
import { Observable, Subject, BehaviorSubject } from 'rxjs/Rx';
import { AngularFireAuth } from 'angularfire2/auth';
import { Router } from '@angular/router';
import * as firebase from 'firebase/app';
import { User } from '@firebase/auth-types';
import { toast } from 'angular2-materialize';
@Injectable()
export class AuthService {
  isLoading: boolean;
  user: User;
  public idToken;

  constructor(public afAuth: AngularFireAuth, private router: Router) {
    this.isLoading = true;
    this.afAuth.authState.subscribe(data => {
      this.user = data;
      this.isLoading = false;
      console.log('User Logged');
    });
    this.afAuth.idToken.subscribe(data => (this.idToken = data));
  }
  get authenticated() {
    return this.user;
  }

  login(email, password) {
    this.afAuth.auth
      .signInWithEmailAndPassword(email, password)
      .then(() => this.router.navigate(['/']))
      .catch(err => {
        toast(err.message, 3000, 'rounded');
      });
  }

  signUp(email, password) {
    this.afAuth.auth
      .createUserWithEmailAndPassword(email, password)
      .then(() => this.router.navigate(['/login']))
      .catch(err => {
        toast(err.message, 3000, 'rounded');
      });
  }

  logout() {
    this.afAuth.auth.signOut();
    this.router.navigate(['/login']);
  }
}
