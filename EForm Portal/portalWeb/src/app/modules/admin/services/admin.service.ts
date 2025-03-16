import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASIC_URL = "http://localhost:8080/"

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }

  createForm(formDto): Observable<any> {
    return this.http.post(BASIC_URL + `api/form`, formDto);
  }

  getAllForm(): Observable<any> {
    return this.http.get(BASIC_URL + `api/form`);
  }

  addQuestionInform(questionDto): Observable<any> {
    return this.http.post(BASIC_URL + `api/form/question`, questionDto);
  }

  getFormQuestions(id: number): Observable<any> {
    return this.http.get(BASIC_URL + `api/form/${id}`);
  }

  submitUserResponses(responses: any[]) {
    return this.http.post('api/form/submit-response', responses);
  }

  getAllFormSubmissions(): Observable<any> {
    return this.http.get(BASIC_URL + `api/form/form-submissions`);
  }
}
