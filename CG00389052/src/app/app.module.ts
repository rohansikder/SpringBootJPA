import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LecturersComponent } from '../components/lecturers/lecturers.component';
import { StudentsComponent } from '../components/students/students.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateLecturerComponent } from '../components/update-lecturer/update-lecturer.component';


//Routes / urls for all components
const routes: Routes = [
  { path: 'lecturers', component: LecturersComponent },
  { path: 'students', component: StudentsComponent },
  { path: 'update-lecturer/:lid', component: UpdateLecturerComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    LecturersComponent,
    StudentsComponent,
    UpdateLecturerComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
