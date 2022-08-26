import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({ providedIn: 'root' })

export class UserService {
  users: any []=[];
  editMode = false;
  
  URL = 'http://localhost:8080/apiUser';

  constructor(private http:HttpClient) { 

  } 
  
  add(user) {
    return this.http.post(this.URL+'/add',user,{observe:'response'});
  }

  findAll() {
    return this.http.get<any[]>(this.URL+'/users').pipe(map(value =>this.users=value))
  }

  getOne(id) {
    return this.http.get<any>(this.URL+'/find/'+id);
  }

  update(user){
    return this.http.put(this.URL+'/update',user,{ observe: 'response'});
    }
  
}
