import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewFormSubmissionsComponent } from './view-form-submissions.component';

describe('ViewFormSubmissionsComponent', () => {
  let component: ViewFormSubmissionsComponent;
  let fixture: ComponentFixture<ViewFormSubmissionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewFormSubmissionsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewFormSubmissionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
