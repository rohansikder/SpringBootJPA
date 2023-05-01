import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { LecturerService } from '../../services/lecturer.service';

@Component({
  selector: 'app-update-lecturer',
  templateUrl: './update-lecturer.component.html',
  styleUrls: ['./update-lecturer.component.css']
})
export class UpdateLecturerComponent implements OnInit {
  lid: string = '';
  name: string = '';
  taxBand: string = '';
  salaryScale: number = 0;

  constructor(
    private route: ActivatedRoute,
    private lecturerService: LecturerService,
    private router: Router
  ) {}

  //On intiliazsation gets all lid from url
  ngOnInit(): void {
    const lidParam = this.route.snapshot.paramMap.get('lid');
    if (lidParam !== null) {
      this.lid = lidParam;
    } else {
      console.log("Lid Is not available")
    }
  }

  //When submit button is pressed form details are sent to lecturer service
  onSubmit(): void {
    this.lecturerService.updateLecturer(
      this.lid,
      this.name,
      this.taxBand,
      this.salaryScale
    ).subscribe(result => {
      console.log(result);
      this.router.navigate(['/lecturers']);
    }, error => {
      console.log(error);
    });
  }
}
