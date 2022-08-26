
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { SigninComponent } from './connexion/signin/signin.component';
import { SignupComponent } from './connexion/signup/signup.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { ProfileComponent } from './user/profile/profile.component';
import { EditprofileComponent } from './user/editprofile/editprofile.component';
import { AnnonceComponent } from './annonce/annonce.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { PageComponent } from './page/page.component';
import { AuthService } from './service/auth/auth.service';
import { HttpClientModule } from '@angular/common/http';

import { UserLoginComponent } from './user/user-login/user-login.component';
import { UserFormComponent } from './user/user-form/user-form.component';
import { AnnonceListComponent } from './annonce/annonce-list/annonce-list.component';
import { UserService } from 'src/service/user.service';
import { OtherComponent } from './other/other.component';
import { TeamComponent } from './other/team/team.component';
import { CommunityComponent } from './other/community/community.component';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AnnonceFormComponent } from './annonce/annonce-form/annonce-form.component';
import { AnnonceProfilComponent } from './annonce/annonce-profil/annonce-profil.component';





@NgModule({
  declarations: [
    AppComponent,
    ConnexionComponent,
    SigninComponent,
    SignupComponent,
    AdminComponent,
    UserComponent,
    ProfileComponent,
    EditprofileComponent,
    AnnonceComponent,
    LoginComponent,
    HomeComponent,
    PageComponent,
    UserLoginComponent,
    UserFormComponent,
    AnnonceListComponent,
    OtherComponent,
    TeamComponent,
    CommunityComponent,
    AnnonceFormComponent,
    AnnonceProfilComponent


  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],


  providers: [AuthService,UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
