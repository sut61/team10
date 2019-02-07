import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TablePhotogarpherComponent } from './table-photogarpher.component';

describe('TablePhotogarpherComponent', () => {
  let component: TablePhotogarpherComponent;
  let fixture: ComponentFixture<TablePhotogarpherComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TablePhotogarpherComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TablePhotogarpherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
