import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { IPerson } from '../interfaces/IPerson';
import { ILoginResponse } from '../interfaces/ILoginResponse';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private http = inject(HttpClient);
  private URL: string = 'http://localhost:8080';

  constructor() { }

  getData(): Observable<IPerson[]> {
    return this.http.get<IPerson[]>(`${this.URL}/excel-processor/get-data`)
  }

  login({ email, password }: { email: string, password: string }): Observable<ILoginResponse> {
    return this.http.post<ILoginResponse>(`${this.URL}/auth/login`, {
      email,
      password
    })
  }

  uploadFile(file: File) {
    const formData = new FormData();
    formData.append("file", file);
    return this.http.post(`${this.URL}/excel-processor/upload`, formData);
  }


}
