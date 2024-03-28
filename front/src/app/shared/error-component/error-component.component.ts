import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-error-component',
  standalone: true,
  imports: [],
  templateUrl: './error-component.component.html',
  styleUrl: './error-component.component.css'
})
export class ErrorComponentComponent {

  @Input('errorMessage') errorMessage: string = '';

  existsErrorMessage(): boolean {
    return Boolean(this.errorMessage);
  }

}
