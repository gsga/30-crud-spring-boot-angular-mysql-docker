import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

/*
https://angular.io/api/core/Injectable
Decorator that marks a class as available to be provided and injected as a dependency.
providedIn Determines which injectors will provide the injectable.
'root' : The application-level injector in most apps.
Esta clase estará disponible para inyección de 
dependencias, y será provista en 
*/
@Injectable({
  providedIn: 'root'
})

export class TareaService {

  // Este es el endpoint del backend para los servicios de esta clase.
  private url: string = "http://localhost:8080/api/tareas";

  /*
  inyección de dependencia.
  Esta clase tendrá una propiedad http de tipo HttpClient.
  https://angular.io/api/common/http/HttpClient
  Performs HTTP requests. This service is available 
  as an injectable class, with methods to perform HTTP 
  requests. Each request method has multiple signatures, 
  and the return type varies based on the signature 
  that is called (mainly the values of observe 
  and responseType).
  */
  constructor(private http: HttpClient) { }

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

  // https://rxjs.dev/guide/observable
  // Observable
  // Observables are lazy Push collections of multiple values. 
  // They fill the missing spot in the following table:

  //        SINGLE     MULTIPLE
  // Pull   Function   Iterator
  // Push   Promise    Observable

  // https://luukgruijs.medium.com/understanding-creating-and-subscribing-to-observables-in-angular-426dbf0b04a3

  // OBSERVABLES ARE LAZY

  // You could think of lazy observables as newsletters. 
  // For each subscriber a new newsletter is created. 
  // They are then only send to those people, and not to anyone else.

  // OBSERVABLES CAN HAVE MULTIPLE VALUES OVER TIME

  // Now if you keep that subscription to the newsletter open, 
  // you will get a new one every once and a while. 
  // The sender decides when you get it but all you have 
  // to do is just wait until it comes straight into your inbox.

  // OBSERVABLES VS PROMISES

  // This is a key difference as promises always return only one value. 
  // Another thing is that observables are cancelable. 
  // If you don’t want your newsletter anymore, you unsubscribe. 
  // With promises this is different, you can’t cancel a promise. 
  // If the promise is handed to you, the process that will produce 
  // that promise’s resolution is already underway, and you generally 
  // don’t have access to prevent that promise’s resolution from executing.

  // PUSH VS PULL

  // Push and pull are two different ways that describe how a 
  // data producer communicates with the data consumer.
  // Observables push. 

  // PULL

  // When pulling, the data consumer decides when it get’s 
  // data from the data producer. The producer is unaware 
  // of when data will be delivered to the consumer.
  // Every javascript function uses the pull. The function is 
  // a Producer of data, and the code that calls the function 
  // is consuming it by “pulling” out a single return value from its call.

  // PUSH

  // When pushing, it works the other way around. The data producer 
  // (the creator of the newsletter) decides when the consumer 
  // (the subscriber to the newsletter) gets the data.

  getTareas(): Observable<any> {
    return this.http.get(this.url);
  }

  getUnaTarea(id: string): Observable<any> {
    return this.http.get(this.url + '/' + id);
  }

  saveTarea(tarea: Tarea): Observable<any> {
    return this.http.post(this.url, tarea);
  }

  editTarea(id: string, tarea: Tarea): Observable<any> {
    return this.http.put(this.url + '/' + id, tarea);
  }

  deleteTarea(id: string): Observable<any> {
    return this.http.delete(this.url + '/' + id);
  }
}

export interface Tarea {
  id: string;
  tarea: string;
  finalizado: boolean;
}