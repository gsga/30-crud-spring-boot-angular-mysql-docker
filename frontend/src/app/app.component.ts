import { Component } from '@angular/core';

/*
Estamos en el componente raíz de la aplicación.
Acá definimos el selector, es decir lo que va en el
tag que pretendemos usar para insertarlo.
Tanbién determinamos el template, ya sea porque damos
el nombre del archivo que lo contiene, como en este
caso, o porque lo damos inline.
Finalmente, determinamos la hoja de esilo usada.
*/
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

/*
Esta es la clase que exportamos, y es la que
tenemos que importar desde el archivo en el
que queramos incluir este componente.
Esta clase tiene una propiedad, que se llama
title, y contiene una string. Después veremos
que se usa con el mecamismo de interpolación,
en el template de este compoente.
*/
export class AppComponent {
  title = 'CRUD básico';
}
