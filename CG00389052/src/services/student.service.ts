import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class StudentService {

    constructor(private http: HttpClient) { }

    getStudents() {
        return this.http.get('http://localhost:8080/students');
    }

    deleteStudent(sid: string) {
        return this.http.delete(`http://localhost:8080/students/${sid}`);
    }

}