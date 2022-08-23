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

  addTarea() {
    /*
    https://angular.io/guide/observables#subscribing
    Subscribe() es un método en Angular que conecta al observador
    a los eventos observables. Siempre que se realice algún cambio en estos
    observables, se ejecuta un código que observa los resultados o
    cambios utilizando el método de suscripción. Subscribe() es un método
    de la biblioteca rxjs, utilizada internamente por Angular.
    Te suscribes llamando al método subscribe() de
    la instancia, pasando un objeto observador para recibir
    las notificaciones.

    this es la referencia a la instancia en la que estamos.

    tareaService es el argumento que le pasamos al constructor
    de la clase para inyectar la dependencia. Es un objeto de
    la clase TareaService. 
    Esta clase, a su vez, está implementada en
    src\app\services\tarea.service.ts
    Vemos que uno de los métodos que tiene es precisamente
    saveTarea(), que toma un argumento de tipo Tarea y 
    retorna un objeto de tipo Observable<any>. Ahora bien,
    un Observable es un objeto que emite eventos a los
    cuales uno se puede suscribir, si está interesado en
    observarlos. Justamente, eso es lo que hacemos acá.
    */
    this.tareaService.saveTarea(this.tareaNueva).subscribe(
      /*
      https://angular.io/guide/observables#defining-observers

      Un controlador para recibir notificaciones observables
      implementa la interfaz Observer. Es un objeto que 
      define métodos de devolución de llamada para manejar 
      los tres tipos de notificaciones que un observable 
      puede enviar: nest, error, complete.
      Un objeto observador puede definir cualquier combinación de
      estos manipuladores. Si no proporciona un controlador para un
      tipo de notificación, el observador ignora las notificaciones
      de ese tipo.
      */
      {
        /*
        next | Obligatorio | Un controlador para cada valor 
        entregado. Llamado cero o más veces después de que 
        comienza la ejecución.
        */
        next: v => {
          console.log(v);
          this.router.navigate(['']);
        },
        /*
        error | Opcional | Un controlador para una 
        notificación de error. Un error detiene la 
        ejecución de la instancia observable.
        */
        error: e => {
          console.log(e);
        },
        /*
        complete | Opcional | Un controlador para la 
        notificación de ejecución completa. Se pueden 
        seguir entregando valores retrasados al 
        siguiente controlador una vez completada la ejecución.
        */
        complete: () => {
          console.info('complete');
        }
      }
    );
  }

}
