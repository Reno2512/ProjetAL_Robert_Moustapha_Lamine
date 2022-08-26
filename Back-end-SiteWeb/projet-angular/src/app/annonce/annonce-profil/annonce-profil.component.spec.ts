import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnonceProfilComponent } from './annonce-profil.component';

describe('AnnonceProfilComponent', () => {
  let component: AnnonceProfilComponent;
  let fixture: ComponentFixture<AnnonceProfilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnnonceProfilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnnonceProfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
