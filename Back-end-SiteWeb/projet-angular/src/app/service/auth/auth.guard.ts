import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { isNull } from 'util';
import { AuthService } from './auth.service';

@Injectable()
export class AuthGuard implements CanActivate {

constructor(
  private router: Router, private authService: AuthService
) { }

canActivate(
  next: ActivatedRouteSnapshot,
  state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    // Récupération de l'utilisateur connecté
    const isLoggedIn = !isNull(localStorage.getItem('user'));

    this.router.navigate(['/login'], { queryParams: { redirectUrl: state.url }});

    if (!isLoggedIn) {
      // Si pas d'utilisateur connecté : redirection vers la page de login
      console.log('Vous n\'êtes pas connectés');
      this.router.navigate(['/login']);
    }
    return isLoggedIn;
     /*
     const roles = next.data['roles'];
  let hasRoles = true;
  if (roles) {
    hasRoles = this.authService.hasAnyRole(roles);
  }
  if(!hasRoles) {
    // Si l'utilisateur na pas les habilitations : redirection vers la page d'accueil
    console.log('Vous n\'avez pas les droits');
    this.router.navigate(['/home']);
  }

  return isLoggedIn && hasRoles;
  */
    
  }
}