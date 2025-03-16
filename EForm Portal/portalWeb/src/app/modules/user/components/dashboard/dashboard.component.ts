import { Component } from '@angular/core';
import { SharedModule } from '../../../shared/shared.module';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { FormService } from '../../services/form.service';

@Component({
  selector: 'app-dashboard',
  imports: [SharedModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

  forms = []

  constructor(private notification: NzNotificationService,
    private formService: FormService
  ) { }

  ngOnInit() {
    this.getAllForms();
  }

  getAllForms() {
    this.formService.getAllForm().subscribe(res => {
      this.forms = res;
    }, error => {
      this.notification.error(
        'ERROR',
        `Something Went Wrong. Try Again`,
        { nzDuration: 5000 }
      )
    })
  }


}
