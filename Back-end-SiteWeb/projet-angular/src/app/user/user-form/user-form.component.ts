import { ActivatedRoute, Router, Params } from '@angular/router';
import { UserService } from './../../../service/user.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})

export class UserFormComponent implements OnInit {

  form: FormGroup;
  index:any;
  mode: boolean;

  constructor( private userService: UserService, private activatedRoute: ActivatedRoute, private router: Router) { }
  

  ngOnInit(): void {

    this.mode = this.userService.editMode;
    this.form = new FormGroup({
      id : new FormControl(null),
      pseudo : new FormControl(null,[Validators.required,Validators.minLength(5), Validators.maxLength(20)]),
      email : new FormControl(null,Validators.required),
      password : new FormControl(null,[Validators.required,Validators.minLength(5), Validators.maxLength(20)]),
      postalCodeUser : new FormControl(null, Validators.required)
    })

    this.activatedRoute.params.subscribe ((param: Params) => {
      this.index = param['index'];

      if(this.index) {
        this.form.setValue(this.userService.users [this.index]);
      }
    })

    //this.mode = this.UserService.editMode;
  }

  addUser() {
    this.userService.add(this.form.value).subscribe(response =>{
    this.userService.users.push(response.body);
    console.log(this.userService.users);
    this.form.reset();
  });
}
}