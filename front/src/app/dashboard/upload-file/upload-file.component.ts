import { Component, ElementRef, ViewChild, inject } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { HttpService } from '../../services/http.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-upload-file',
  standalone: true,
  imports: [MatButtonModule],
  templateUrl: './upload-file.component.html',
  styleUrl: './upload-file.component.css'
})
export class UploadFileComponent {

  apiService = inject(HttpService);
  toastr = inject(ToastrService);

  @ViewChild('fileUpload') fileUpload: ElementRef | undefined;

  file: File | null = null;


  hasFile(): boolean {
    return Boolean(this.file)
  }

  onFileSelected(event: any) {
    const file: File = event.target.files[0];
    if (file) {
      this.file = file;
    }
  }

  handleClickUploadFile() {
    if (this.file) {
      this.apiService.uploadFile(this.file).subscribe({
        next: () => {
          console.log('test ok')
          this.file = null;
          this.toastr.success('Archivo cargado OK', 'Subir archivo');

          if(this.fileUpload){
            this.fileUpload.nativeElement.value = null;
          }
        }
      })
    }
  }

}
