import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddRandomTicketComponent } from './add-random-ticket.component';

describe('AddRandomTicketComponent', () => {
  let component: AddRandomTicketComponent;
  let fixture: ComponentFixture<AddRandomTicketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddRandomTicketComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddRandomTicketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
