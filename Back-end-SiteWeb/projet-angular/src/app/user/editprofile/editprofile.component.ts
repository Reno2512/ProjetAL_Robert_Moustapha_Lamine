import { Router, Params, ActivatedRoute } from '@angular/router';
import { UserService } from 'src/service/user.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.css']
})
export class EditprofileComponent implements OnInit {
  id: any;
  form: FormGroup;
  index:any;
  mode: boolean;
  constructor(private userService: UserService,private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.form = new FormGroup({
      userId : new FormControl(null),
      pseudo : new FormControl(null,Validators.required),
      email : new FormControl(null,Validators.required),
      password : new FormControl(null,Validators.required),
      postalCodeUser : new FormControl(null, Validators.required),
      phone : new FormControl(null, Validators.required),
      description : new FormControl(null, Validators.required)
    })

    this.activatedRoute.params.subscribe ((param: Params) => {
      this.index = param['index'];

      if(this.index) {
        this.form.setValue(this.userService.users [this.index]);
      }
    })
  }

  updateUser() {
    this.userService.update(this.form.value).subscribe(response =>{
    this.userService.users.push(response.body);
    console.log(this.userService.users);
    this.form.reset();
  });
}



}
