import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from '../service/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [AuthService]
})
export class LoginComponent implements OnInit {

  model: any = {};

  //private router: Router, private route: ActivatedRoute,  delete in constructor
  constructor(private authService: AuthService) {
   }

  ngOnInit(): void {
  }

  login() {
    /*
    console.log('Tentative de connexion');
    //permet de verif si les login/mdp sont corrects, par exemple par une requête à un service REST 
    localStorage.setItem('user', JSON.stringify({login : this.model.pseudo})); 
    this.router.navigate(['/home']);

    // On récupère l'url de redirection
    const redirectUrl = this.route.snapshot.queryParams['redirectUrl'] || '/home';

    // On accède à la page souhaitée
    this.router.navigate([redirectUrl]);
    */
    this.authService.login(this.model);
  }

}
