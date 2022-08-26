import { UserService } from './../../../service/user.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { find } from 'rxjs/operators';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  
  form: FormGroup;
  user:any;
  id;

  constructor(private userService : UserService,private activatedRoute: ActivatedRoute, private Router: Router) { }
  ngOnInit(): void {
     
  this.userService.getOne(1).subscribe(data=>{
  this.user = data as string; });
  }

  find(){
    this.userService.getOne(this.id).subscribe(data=>{
      this.user = data as string; });
  }
}
