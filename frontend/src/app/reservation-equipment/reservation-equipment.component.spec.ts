import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationEquipmentComponent } from './reservation-equipment.component';

describe('ReservationEquipmentComponent', () => {
  let component: ReservationEquipmentComponent;
  let fixture: ComponentFixture<ReservationEquipmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReservationEquipmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservationEquipmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
