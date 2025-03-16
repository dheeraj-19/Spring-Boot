import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddQuestionInFormComponent } from './add-question-in-form.component';

describe('AddQuestionInFormComponent', () => {
  let component: AddQuestionInFormComponent;
  let fixture: ComponentFixture<AddQuestionInFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddQuestionInFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddQuestionInFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
