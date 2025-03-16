import { Component } from '@angular/core';
import { SharedModule } from '../../../shared/shared.module';
import { AdminService } from '../../services/admin.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NzNotificationService } from 'ng-zorro-antd/notification';

@Component({
  selector: 'app-add-question-in-form',
  imports: [SharedModule],
  templateUrl: './add-question-in-form.component.html',
  styleUrl: './add-question-in-form.component.scss'
})
export class AddQuestionInFormComponent {

  constructor(private fb: FormBuilder,
    private adminService: AdminService,
    private notification: NzNotificationService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
  ) { }

  id: number | null;
  questionForm!: FormGroup;
  questionTypes = ['TEXT', 'DROPDOWN', 'RADIO', 'CHECKBOX'];

  ngOnInit() {

    this.questionForm = this.fb.group({
      questionText: [null, [Validators.required]],
      questionType: ['TEXT', [Validators.required]],
      options: this.fb.array([]), // Dynamic options
    });

    console.log(this.options);
    this.id = this.activatedRoute.snapshot.params["id"];
  }

  get options() {
    return this.questionForm.get('options') as FormArray;
  }

  onQuestionTypeChange() {
    const selectedType = this.questionForm.get('questionType')?.value;
    const optionsArray = this.questionForm.get('options') as FormArray;

    if (selectedType === 'TEXT') {
      this.questionForm.setControl('options', this.fb.array([])); // Reset options for text
    } else {
      this.questionForm.setControl(
        'options',
        this.fb.array(Array(4).fill('').map(() => this.fb.control('', Validators.required)))
      );
    }
  }

  submitForm() {
    const questionDto = this.questionForm.value;
    questionDto.id = this.id;

    if (questionDto.options) {
      questionDto.options = questionDto.options.filter((option: string) => option && option.trim() !== '');
    }

    console.log('Submitting question:', questionDto);

    this.adminService.addQuestionInform(questionDto).subscribe(res => {
      this.notification.success(
        'SUCCESS',
        `Question Created Successfully!`,
        { nzDuration: 5000 }
      );
      this.router.navigateByUrl("/admin/dashboard");
    }, error => {
      this.notification.error(
        'ERROR',
        `${error.error}`,
        { nzDuration: 5000 }
      );
    })
  }

}
