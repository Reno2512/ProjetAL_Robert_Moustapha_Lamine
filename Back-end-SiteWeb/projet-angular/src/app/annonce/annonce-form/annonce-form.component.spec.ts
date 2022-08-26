import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnonceFormComponent } from './annonce-form.component';

describe('AnnonceFormComponent', () => {
  let component: AnnonceFormComponent;
  let fixture: ComponentFixture<AnnonceFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnnonceFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnnonceFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
