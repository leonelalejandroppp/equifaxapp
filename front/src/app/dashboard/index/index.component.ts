import { Component, inject } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import {MatTableModule} from '@angular/material/table';
import { IPerson } from '../../interfaces/IPerson';
import { HttpService } from '../../services/http.service';
import { UploadFileComponent } from '../upload-file/upload-file.component';

@Component({
  selector: 'app-index',
  standalone: true,
  imports: [MatTableModule, MatButtonModule, UploadFileComponent],
  templateUrl: './index.component.html',
  styleUrl: './index.component.css'
})
export class IndexComponent {
  apiService = inject(HttpService);

  displayedColumns: string[] = ['id', 'name', 'rut', 'address', 'country'];
  dataSource: IPerson[] = [];

  hasData(): boolean {
    return Boolean(this.dataSource.length)
  }

  handleClickGetData() {
    this.apiService.getData().subscribe(
      {
        next: (data) => {
          console.log(data);
          this.dataSource = data;
        }
      }
    )
  }
}
