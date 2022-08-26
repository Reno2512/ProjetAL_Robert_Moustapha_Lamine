import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AnnonceService } from 'src/service/annonce.service';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { Route } from '@angular/compiler/src/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@Component({
  selector: 'app-annonce-form',
  templateUrl: './annonce-form.component.html',
  styleUrls: ['./annonce-form.component.css']
})
export class AnnonceFormComponent implements OnInit {


  form: FormGroup;
  index: any;
  mode: boolean;

  constructor(private annonceService: AnnonceService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {

    this.form = new FormGroup({
      id: new FormControl(null),
      title: new FormControl(null, Validators.required),
      description: new FormControl(null, Validators.required),
      category: new FormControl(null,Validators.required),
      postalCodeDemand: new FormControl(null,Validators.required)

    })

    this.activatedRoute.params.subscribe ((param: Params) => {
      this.index = param['index'];
      if(this.index) {
        this.form.setValue(this.annonceService.annonces [this.index]);
      }
    })

  }

  addDemand(){
    this.annonceService.add(this.form.value).subscribe(response => {
      this.annonceService.annonces.push(response.body);
      console.log(this.annonceService.annonces);
      this.form.reset();
    })
  }

  

}
