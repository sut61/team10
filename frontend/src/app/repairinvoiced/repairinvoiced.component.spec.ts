import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RepairinvoicedComponent } from './repairinvoiced.component';

describe('RepairinvoicedComponent', () => {
  let component: RepairinvoicedComponent;
  let fixture: ComponentFixture<RepairinvoicedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RepairinvoicedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RepairinvoicedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
