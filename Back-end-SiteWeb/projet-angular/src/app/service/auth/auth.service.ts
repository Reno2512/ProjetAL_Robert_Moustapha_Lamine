import { Injectable } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Injectable()
export class AuthService {

  constructor(
    private router: Router,
    private route: ActivatedRoute
  ) { }

  login(loginForm: any) {
    console.log('Tentative de connexion');

    this.setUser({login : loginForm.username});

    // On récupère l'url de redirection
    const redirectUrl = this.route.snapshot.queryParams['redirectUrl'] || '/home';

    // On accède à la page souhaitée
    this.router.navigate([redirectUrl]);

    
    // Ajout des roles au modèle utilisateur
    let rolesUser = [];
    if (loginForm.isAdmin === true) {
      rolesUser = ['ADMIN'];
    } else {
      rolesUser = ['NOTADMIN'];
    } 

    this.setUser({login : loginForm.isAdmin, roles : rolesUser});
    
  }

  logout() {
    console.log('Tentative de déconnexion');

    this.clearUser();
    this.router.navigate(['/login']);
  }

  getUser() {
    return JSON.parse(localStorage.getItem('user'));
  }

  setUser(user: any) {
    localStorage.setItem('user', JSON.stringify(user));
  }

  clearUser() {
    localStorage.removeItem('user');
  }

  hasAnyRole(roles: string[]) {
    const user = this.getUser();
  
    for (const role of user.roles) {
      if (roles.includes(role)) {
        return true;
      }
    }
    return false;
  }
  
}