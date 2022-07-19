import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Tarea, TareaService } from 'src/app/services/tarea.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {

  tarea: Tarea = { id: '', tarea: '', finalizado: false };

  constructor(
    private tareaService: TareaService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.tarea.id = this.activatedRoute.snapshot.params['id'];
    this.tareaService.getUnaTarea(this.tarea.id).subscribe({
      next: v => {
        console.log(v);
        this.tarea = v;
      },
      error: e => {
        console.log(e);
      },
      complete: () => {
        console.info('complete');
      }
    });
  }

  saveTarea() {
    this.tareaService.editTarea(this.tarea.id, this.tarea).subscribe({
      next: v => {
        this.router.navigate(['']);
      },
      error: e => {
        console.log(e);
      },
      complete: () => {
        console.info('complete');
      }
    });
  }

}
