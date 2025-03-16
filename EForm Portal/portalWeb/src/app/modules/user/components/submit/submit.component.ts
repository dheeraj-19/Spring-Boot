import { Component } from '@angular/core';
import { SharedModule } from '../../../shared/shared.module';
import { FormService } from '../../services/form.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { UserStorageService } from '../../../auth/services/user-storage.service';

@Component({
  selector: 'app-submit',
  imports: [SharedModule],
  templateUrl: './submit.component.html',
  styleUrl: './submit.component.scss'
})
export class SubmitComponent {

  questions: any[] = [];
  formId!: number;
  userId!: number;
  responseForm!: FormGroup;

  constructor(private formService: FormService,
    private activatedRoute: ActivatedRoute,
    private message: NzMessageService,
    private router: Router,
    private notification: NzNotificationService,
    private fb: FormBuilder
  ) { this.responseForm = this.fb.group({}); }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      this.userId = UserStorageService.getUser()['id'];
      this.formId = +params.get('id');
      this.formService.getFormQuestions(this.formId).subscribe(res => {
        this.questions = res.questions;
        this.initializeForm();
      })
    })
  }

  initializeForm() {
    let group: any = {};
    this.questions.forEach(question => {
      if (question.questionType === 'CHECKBOX') {
        group['response_' + question.id] = new FormControl([]);   // Store multiple selections
      } else {
        group['response_' + question.id] = new FormControl('');
      }
    });
    this.responseForm = this.fb.group(group);
  }

  onCheckboxChange(event: any, controlName: string) {
    let selectedOptions = this.responseForm.get(controlName)?.value || [];
    if (event.target.checked) {
      selectedOptions.push(event.target.value);
    } else {
      selectedOptions = selectedOptions.filter((option: string) => option !== event.target.value);
    }
    this.responseForm.get(controlName)?.setValue(selectedOptions);
  }

  submitResponses() {

    let responses = Object.keys(this.responseForm.value).map(key => {
      let questionId = Number(key.replace('response_', ''));
      let answer = this.responseForm.value[key];

      // Convert array (checkbox) answers to comma-separated string
      if (Array.isArray(answer)) {
        answer = answer.join(',');
      }

      return {
        formId: this.formId,
        userId: this.userId,
        questionId: questionId,
        answer: answer
      };
    });

    this.formService.submitUserResponses(responses).subscribe(res => {
      this.notification.success('SUCCESS', 'Responses submitted successfully!', { nzDuration: 5000 });
      this.router.navigateByUrl("/admin/dashboard");
    }, error => {
      console.log(error);
      this.notification.error('ERROR', `${error.error}`, { nzDuration: 5000 });
    });
  }

}
