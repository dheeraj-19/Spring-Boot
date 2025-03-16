import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { SubmitComponent } from './components/submit/submit.component';
import { ViewFormSubmissionsComponent } from './components/view-form-submissions/view-form-submissions.component';

const routes: Routes = [
  { path: 'dashboard', component: DashboardComponent },
  { path: 'submit-form/:id', component: SubmitComponent },
  { path: 'view-form-submissions', component: ViewFormSubmissionsComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
