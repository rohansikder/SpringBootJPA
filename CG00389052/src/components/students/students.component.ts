import { Component } from '@angular/core';
import { StudentService } from '../../services/student.service'


@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent {
  students: any[] = [];
  constructor(private studentService: StudentService) { }

  //On intilizatoiion gets all students
  ngOnInit(): void {
    this.studentService.getStudents().subscribe((data: any) => {
      this.students = data as any[];
    });
  }

  //Calls the studentService with the sid to know which student to delete
  deleteStudent(sid: string) {
    this.studentService.deleteStudent(sid).subscribe(() => {
      // Remove the deleted student from the list
      this.students = this.students.filter(student => student.sid !== sid);
    });
  }

}
