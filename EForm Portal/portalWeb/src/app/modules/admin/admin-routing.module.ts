import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { CreateFormComponent } from './components/create-form/create-form.component';
import { AddQuestionInFormComponent } from './components/add-question-in-form/add-question-in-form.component';
import { ViewFormComponent } from './components/view-form/view-form.component';
import { ViewFormSubmissionsComponent } from './components/view-form-submissions/view-form-submissions.component';

const routes: Routes = [
  { path: 'dashboard', component: DashboardComponent },
  { path: 'create-form', component: CreateFormComponent },
  { path: 'add-question/:id', component: AddQuestionInFormComponent },
  { path: 'view-form/:id', component: ViewFormComponent },
  { path: 'view-form-submissions', component: ViewFormSubmissionsComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
