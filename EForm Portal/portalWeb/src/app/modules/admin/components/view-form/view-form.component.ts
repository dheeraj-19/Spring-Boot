import { Component } from '@angular/core';
import { SharedModule } from '../../../shared/shared.module';
import { AdminService } from '../../services/admin.service';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { NzNotificationService } from 'ng-zorro-antd/notification';

@Component({
  selector: 'app-view-form',
  imports: [SharedModule],
  templateUrl: './view-form.component.html',
  styleUrl: './view-form.component.scss'
})
export class ViewFormComponent {

  questions: any[] = [];
  formId: any;
  responseForm!: FormGroup;

  constructor(private adminService: AdminService,
    private activatedRoute: ActivatedRoute,
    private fb: FormBuilder,
    private notification: NzNotificationService
  ) { this.responseForm = this.fb.group({}); }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      this.formId = +params.get('id');
      this.adminService.getFormQuestions(this.formId).subscribe(res => {
        this.questions = res.questions;
        this.initializeForm();
      })
    })
  }

  initializeForm() {
    let group: any = {};
    this.questions.forEach(question => {
      if (question.questionType === 'CHECKBOX') {
        group['response_' + question.id] = [[]];  // Store multiple selections
      } else {
        group['response_' + question.id] = [''];
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


}
