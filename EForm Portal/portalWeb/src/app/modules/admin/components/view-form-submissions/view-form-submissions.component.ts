import { Component } from '@angular/core';
import { SharedModule } from '../../../shared/shared.module';
import { AdminService } from '../../services/admin.service';
import { NzCollapseModule } from 'ng-zorro-antd/collapse';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzPaginationModule } from 'ng-zorro-antd/pagination';

@Component({
  selector: 'app-view-form-submissions',
  imports: [SharedModule, NzCollapseModule, NzTableModule, NzPaginationModule],
  templateUrl: './view-form-submissions.component.html',
  styleUrl: './view-form-submissions.component.scss'
})
export class ViewFormSubmissionsComponent {

  submissions: any[] = [];
  users: any[] = [];

  constructor(private adminService: AdminService) { }

  ngOnInit() {
    this.getAllFormSubmissions();
  }

  getAllFormSubmissions() {
    this.adminService.getAllFormSubmissions().subscribe(res => {
      this.submissions = res;
      console.log(this.submissions);
      this.groupSubmissionsByUser();
    })
  }

  groupSubmissionsByUser() {
    let userMap = new Map();

    this.submissions.forEach(sub => {
      if (!userMap.has(sub.userName)) {
        userMap.set(sub.userName, { userName: sub.userName, forms: new Map() });
      }

      let user = userMap.get(sub.userName);

      if (!user.forms.has(sub.formTitle)) {
        user.forms.set(sub.formTitle, { formTitle: sub.formTitle, submissions: [] });
      }

      user.forms.get(sub.formTitle).submissions.push(sub);
    });

    this.users = Array.from(userMap.values()).map(user => {
      return {
        userName: user.userName,
        forms: Array.from(user.forms.values())
      };
    });
  }

}
