import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AnnonceService {

  annonces: any[]=[];
  URL = 'http://localhost:8080/apiDemand';

  constructor(private http:HttpClient) { }


  add(annonce) {
    return this.http.post(this.URL+'/add',annonce,{observe:'response'});
  }

  findAll() {
    return this.http.get<any[]>(this.URL+'/demandes').pipe(map(value =>this.annonces=value))
  }

  getOne(id) {
    return this.http.get<any>(this.URL+'/find/'+id);
  }

  update(annonce){
    return this.http.put(this.URL+'/update',annonce,{ observe: 'response'});
    }
}
