import { Component, OnInit } from '@angular/core';

import { TareaService } from 'src/app/services/tarea.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  lista: any = [];
  // Esta es la inyección de la dependencia. 
  // https://angular.io/guide/dependency-injection#injecting-services
  // Injecting services lets a component access their features and data.
  // To inject a dependency in a component's constructor(), supply a 
  // constructor argument with the dependency type. 
  constructor(private tareaService: TareaService) { }

  ngOnInit(): void {
    this.listarTareas();
  }

  // Cuando un método retorna un Observable, eso significa
  // que ese observable es un emisor de eventos o datos.
  // Eso se llama "push".
  // Si yo quiero que el objeto que llamó al método se entere,
  // necesito subscribe(). Es decir, el Observable emite de vez en cuando,
  // o sea hace un push. El observador se susbscribe al evento que
  // el Observable emite, y de ese modo se entera cada vez que hay
  // un push.
  // Si yo lo llamo, me retorna un Observable. Pero si no me
  // suscribo no me entero. Es decir no tengo la capacidad
  // de procesar el Observable. Pero ya que lo recibí, lo
  // puedo retornar a mi vez. O sea, el que se tiene que
  // suscribir es el que necesita procesar ese observable.
  listarTareas() {
    this.tareaService.getTareas().subscribe(
      {
        next: v => {
          console.log(v);
          this.lista = v;
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

  delete(id: string) {
    this.tareaService.deleteTarea(id).subscribe(
      {
        next: v => {
          this.ngOnInit();
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
