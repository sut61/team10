import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PhotocollectionComponent } from './photocollection.component';

describe('PhotocollectionComponent', () => {
  let component: PhotocollectionComponent;
  let fixture: ComponentFixture<PhotocollectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PhotocollectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PhotocollectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
