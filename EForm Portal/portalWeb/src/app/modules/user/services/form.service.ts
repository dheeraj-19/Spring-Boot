import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { UserStorageService } from '../../auth/services/user-storage.service';

const BASIC_URL = "http://localhost:8080/";

@Injectable({
  providedIn: 'root'
})
export class FormService {

  constructor(private http: HttpClient) { }

  getAllForm(): Observable<any> {
    return this.http.get(BASIC_URL + `api/form`);
  }

  getFormQuestions(id: number): Observable<any> {
    return this.http.get(BASIC_URL + `api/form/${id}`);
  }

  submitUserResponses(responses: any[]): Observable<any> {
    return this.http.post(BASIC_URL + `api/form/submit-form`, responses);
  }

  getAllUserSubmissions(): Observable<any> {
    return this.http.get(BASIC_URL + `api/form/form-submissions/${UserStorageService.getUserId()}`);
  }
}
