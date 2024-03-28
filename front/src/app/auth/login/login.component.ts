import { Component, inject } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { HttpService } from '../../services/http.service';
import { Router } from '@angular/router';
import { ErrorComponentComponent } from '../../shared/error-component/error-component.component';



@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, MatFormFieldModule, MatInputModule, MatButtonModule, ErrorComponentComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  errorMessage: string = ''

  userForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required])
  });

  apiService = inject(HttpService);
  router = inject(Router);

  onSubmit() {
    console.log(this.userForm.value);
    this.apiService.login({
      email: this.userForm.value.email || '',
      password: this.userForm.value.password || ''
    }).subscribe(
      {
        next: (data) => {
          this.setToken(data.token)
          this.goToDashboard()
        },
        error: () => {
          this.errorMessage = "Credenciales inválidas"
        }
      }
    )
  }

  private setToken (token: string) {
    localStorage.setItem('token', token);
  }

  private goToDashboard () {
    this.router.navigateByUrl('/dashboard')
  }

}
