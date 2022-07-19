import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Tarea, TareaService } from 'src/app/services/tarea.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.scss']
})
export class AddComponent implements OnInit {

  tareaNueva: Tarea = { id: '', tarea: '', finalizado: false };

  constructor(
    private tareaService: TareaService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  // https://angular.io/guide/observables#subscribing
  // Subscribe() is a method in Angular that connects the observer 
  // to observable events. Whenever any change is made in these 
  // observable, a code is executed and observes the results or 
  // changes using the subscribe method. Subscribe() is a method 
  // from the rxjs library, used internally by Angular.
  //
  // You subscribe by calling the subscribe() method of 
  // the instance, passing an observer object to receive 
  // the notifications
  //
  // https://angular.io/guide/observables#defining-observers
  // A handler for receiving observable notifications implements 
  // the Observer interface. It is an object that defines callback 
  // methods to handle the three types of notifications that 
  // an observable can send:
  //
  // NOTIFICATION TYPE	DETAILS
  //
  // next	Required. A handler for each delivered value. 
  // Called zero or more times after execution starts.
  //
  // error	Optional. A handler for an error notification. 
  // An error halts execution of the observable instance.
  //
  // complete	Optional. A handler for the execution-complete 
  // notification. Delayed values can continue to be delivered 
  // to the next handler after execution is complete.
  //
  // An observer object can define any combination of 
  // these handlers. If you don't supply a handler for a 
  // notification type, the observer ignores notifications 
  // of that type.

  addTarea() {
    this.tareaService.saveTarea(this.tareaNueva).subscribe(
      {
        next: v => {
          console.log(v);
          this.router.navigate(['']);
        },
        error: e => {
          console.log(e);
        },
        complete: () => {
          console.info('complete');
        }
      }
    );
  }

}
