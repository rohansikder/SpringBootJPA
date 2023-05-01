import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class LecturerService {

    constructor(private http: HttpClient) { }

    //Gets all lectures using get request
    getLecturers() {
        return this.http.get('http://localhost:8080/lecturers');
    }

    //Updates a lectures using PUT request
    updateLecturer(lid: string, name: string, taxBand: string, salaryScale: number) {
        return this.http.put(`http://localhost:8080/lecturer/${lid}`, {
            name: name,
            taxBand: taxBand,
            salaryScale: salaryScale
        });
    }
}