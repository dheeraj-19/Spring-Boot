import { Component } from '@angular/core';
import { SharedModule } from '../../../shared/shared.module';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AdminService } from '../../services/admin.service';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-form',
  imports: [SharedModule],
  templateUrl: './create-form.component.html',
  styleUrl: './create-form.component.scss'
})
export class CreateFormComponent {

  constructor(private fb: FormBuilder,
    private deviceService: AdminService,
    private notification: NzNotificationService,
    private router: Router,
  ) { }

  validateForm!: FormGroup;

  ngOnInit() {
    this.validateForm = this.fb.group({
      title: [null, Validators.required],
      description: [null, [Validators.required]],
    })
  }

  submitForm() {
    if (this.validateForm.valid) {
      this.deviceService.createForm(this.validateForm.value).subscribe(res => {
        this.notification.success(
          'SUCCESS',
          `Form Created Successfully!`,
          { nzDuration: 5000 }
        );
        this.router.navigateByUrl("/admin/dashboard");
      }, error => {
        this.notification.error(
          'ERROR',
          `${error.error}`,
          { nzDuration: 5000 }
        );
      });
    }
  }

}
