import { Router } from '@angular/router';
import { UserService } from '../../../service/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  constructor(private UserService: UserService, private Router: Router) { }

  usersList: any[]=[];

  ngOnInit(): void {
    this.usersList = this.UserService.users;
  }

  delete(index) {
    this.UserService.users.splice(index,1);
  }

  edit(index){
    this.Router.navigate(['/user/edit',index])
    //cf exemple pê a modifier
  }

}
