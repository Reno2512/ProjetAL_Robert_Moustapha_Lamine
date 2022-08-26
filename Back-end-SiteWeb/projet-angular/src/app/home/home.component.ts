import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'], 
  providers: [AuthService]
})
export class HomeComponent implements OnInit {

  //delete : private router: Router 
  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    console.log('welcome home');
  }


  // Outils d'authentification 
  getLogin() {
    //return JSON.parse(localStorage.getItem('user')).login;
    return this.authService.getUser().pseudo;
  }

  logout() {
    /*
    console.log('Tentative de déconnexion');
    localStorage.removeItem('user');
    this.router.navigate(['/login']);
    */
    return this.authService.logout();
  }

  hasAnyRole(roles: string[]) {
    return this.authService.hasAnyRole(roles);
  }

}
