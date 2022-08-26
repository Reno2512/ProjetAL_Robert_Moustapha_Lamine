import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AnnonceService } from 'src/service/annonce.service';
import { FormGroup, FormControl } from '@angular/forms';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-annonce-profil',
  templateUrl: './annonce-profil.component.html',
  styleUrls: ['./annonce-profil.component.css']
})
export class AnnonceProfilComponent implements OnInit {
  form: FormGroup;
  id;
  annonce:any;
  demand;

  constructor(private annonceService: AnnonceService, private activatedRoute: ActivatedRoute, private router: Router) { }

  
  ngOnInit(): void {

}
  validation="disponible";
  annonceId;

  accept(){
    this.validation="acceptée";
  }


  find(){
    this.annonceService.getOne(this.id).subscribe(data=>{
      this.annonce = data as string;
    });
    console.log(this.annonce);
    }
      
  

  // redirect() {
  //   this.router.navigate(['/demandes'])
  // }

}
