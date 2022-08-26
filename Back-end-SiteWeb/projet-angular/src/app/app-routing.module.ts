import { AnnonceProfilComponent } from './annonce/annonce-profil/annonce-profil.component';
import { AnnonceListComponent } from './annonce/annonce-list/annonce-list.component';
import { CommunityComponent } from './other/community/community.component';
import { TeamComponent } from './other/team/team.component';
import { OtherComponent } from './other/other.component';

import { UserFormComponent } from './user/user-form/user-form.component';
import { UserComponent } from './user/user.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { AnnonceComponent } from './annonce/annonce.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './service/auth/auth.guard';
import { PageComponent } from './page/page.component';
import { ProfileComponent } from './user/profile/profile.component';
import { EditprofileComponent } from './user/editprofile/editprofile.component';
import { AnnonceFormComponent } from './annonce/annonce-form/annonce-form.component';





const routes: Routes = [

  { path: '', component: HomeComponent },

  //path pour les annonces :
  { path: 'annonce', component: AnnonceComponent, children : [
    {path: 'all', component: AnnonceListComponent},
    {path: 'id', component: AnnonceFormComponent},
    {path:'profil', component : AnnonceProfilComponent}
  ] },
  
  //path for authentification parts :  
  { path: 'login', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'home', canActivate: [AuthGuard], component: HomeComponent },
  { path: 'page', canActivate: [AuthGuard], component: PageComponent },

  //path dashboard admin :
  { path: 'admin', canActivate: [AuthGuard], component: AdminComponent, data: { roles: ['ADMIN']} },

  //path user add : 
  { path: 'user', component: UserComponent, children: [
    {path:'signup', component: UserFormComponent},
    {path:'edit/:index', component: UserFormComponent}
  ]},

  //path pour les pages "autre" : l'équipe et la communauté
  { path: 'other', component: OtherComponent, children: [
    {path: 'team', component: TeamComponent},
    {path: 'community', component: CommunityComponent}
  ]},

  //profil user par bento
  {path: 'editprofil', component: EditprofileComponent},
  {path: 'profil', component: ProfileComponent},
  {path:'annonce', component:AnnonceComponent}

  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [AuthGuard]
})

export class AppRoutingModule { }
