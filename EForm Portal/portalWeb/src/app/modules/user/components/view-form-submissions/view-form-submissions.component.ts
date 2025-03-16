import { Component } from '@angular/core';
import { SharedModule } from '../../../shared/shared.module';
import { NzCollapseModule } from 'ng-zorro-antd/collapse';
import { NzPaginationModule } from 'ng-zorro-antd/pagination';
import { NzTableModule } from 'ng-zorro-antd/table';
import { AdminService } from '../../../admin/services/admin.service';
import { FormService } from '../../services/form.service';

@Component({
  selector: 'app-view-form-submissions',
  imports: [SharedModule, NzCollapseModule, NzTableModule, NzPaginationModule],
  templateUrl: './view-form-submissions.component.html',
  styleUrl: './view-form-submissions.component.scss'
})
export class ViewFormSubmissionsComponent {

  submissions: any[] = [];

  constructor(private formService: FormService) { }

  ngOnInit() {
    this.getUserFormSubmissions();
  }

  getUserFormSubmissions() {
    this.formService.getAllUserSubmissions().subscribe(res => {
      this.submissions = res;
      this.groupSubmissionsByForm(this.submissions);
    })
  }

  groupSubmissionsByForm(submissions: any[]) {
    let formMap = new Map();

    submissions.forEach(sub => {
      if (!formMap.has(sub.formId)) {
        formMap.set(sub.formId, { formId: sub.formId, formTitle: sub.formTitle, submissions: [] });
      }
      formMap.get(sub.formId).submissions.push(sub);
    });

    this.submissions = Array.from(formMap.values());
  }

}
