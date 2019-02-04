import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterPhotographyComponent } from './register-photography.component';

describe('RegisterPhotographyComponent', () => {
  let component: RegisterPhotographyComponent;
  let fixture: ComponentFixture<RegisterPhotographyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterPhotographyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterPhotographyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
