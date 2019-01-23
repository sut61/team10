import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationPhotographerComponent } from './reservation-photographer.component';

describe('ReservationPhotographerComponent', () => {
  let component: ReservationPhotographerComponent;
  let fixture: ComponentFixture<ReservationPhotographerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReservationPhotographerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservationPhotographerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
