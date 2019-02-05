import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PayonlineComponent } from './payonline.component';

describe('PayonlineComponent', () => {
  let component: PayonlineComponent;
  let fixture: ComponentFixture<PayonlineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PayonlineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PayonlineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
