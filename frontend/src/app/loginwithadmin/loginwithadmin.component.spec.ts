import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginwithadminComponent } from './loginwithadmin.component';

describe('LoginwithadminComponent', () => {
  let component: LoginwithadminComponent;
  let fixture: ComponentFixture<LoginwithadminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginwithadminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginwithadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
