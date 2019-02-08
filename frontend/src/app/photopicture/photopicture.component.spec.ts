import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PhotopictureComponent } from './photopicture.component';

describe('PhotopictureComponent', () => {
  let component: PhotopictureComponent;
  let fixture: ComponentFixture<PhotopictureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PhotopictureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PhotopictureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
