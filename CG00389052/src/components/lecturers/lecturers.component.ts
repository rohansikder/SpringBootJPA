import { Component, OnInit } from '@angular/core';
import { LecturerService } from '../../services/lecturer.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-lecturers',
  templateUrl: './lecturers.component.html',
  styleUrls: ['./lecturers.component.css']
})

export class LecturersComponent implements OnInit {


  lecturers: any[] = [];

  constructor(private lecturerService: LecturerService, private router: Router,) { }

  ngOnInit(): void {
    this.lecturerService.getLecturers().subscribe((data: any) => {
      this.lecturers = data as any[];
    });
  }

  putUpdateLecture(lid: string) {
    this.router.navigate(['/update-lecturer', lid]);
  }
}
