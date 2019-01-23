import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationModelComponent } from './reservation-model.component';

describe('ReservationModelComponent', () => {
  let component: ReservationModelComponent;
  let fixture: ComponentFixture<ReservationModelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReservationModelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservationModelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
