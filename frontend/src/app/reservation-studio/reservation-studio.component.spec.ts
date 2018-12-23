import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationStudioComponent } from './reservation-studio.component';

describe('ReservationStudioComponent', () => {
  let component: ReservationStudioComponent;
  let fixture: ComponentFixture<ReservationStudioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReservationStudioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservationStudioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
