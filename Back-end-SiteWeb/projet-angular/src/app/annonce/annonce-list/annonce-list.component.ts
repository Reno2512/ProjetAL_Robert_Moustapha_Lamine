import { Component, OnInit } from '@angular/core';
import { AnnonceService } from 'src/service/annonce.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-annonce-list',
  templateUrl: './annonce-list.component.html',
  styleUrls: ['./annonce-list.component.css']
})
export class AnnonceListComponent implements OnInit {

  constructor(private annonceService: AnnonceService, private Router: Router) { }

  annoncesList: any[]=[]

  ngOnInit(): void {
    this.annoncesList = this.annonceService.annonces;
  }

  delete(index) {
    this.annonceService.annonces.splice(index,1);
  }

  edit(index) {
    this.Router.navigate(['/demand/edit',index])
  }

}
