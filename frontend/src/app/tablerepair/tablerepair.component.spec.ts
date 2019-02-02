import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TablerepairComponent } from './tablerepair.component';

describe('TablerepairComponent', () => {
  let component: TablerepairComponent;
  let fixture: ComponentFixture<TablerepairComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TablerepairComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TablerepairComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
