import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

/*
Necesitamos importar los componentes,
para luego poder usarlos. En esta aplicación tenemos
tres componentes, cada uno de los cuales está
implementado en 4 archivos, que están dentro de 
una carpeta que lleva el nombre del componente
El argumento entre las llaves {} es el nombre de
la clase que el componente exporta.
El argumento from da el path relativo de la carpeta
en la que está el componente, y da también los dos
primeros tokens del nombre de los archivos. Omite
la extensión o las extensiones, porque son obvias.
Como resultado de la importación, este módulo en
el que ahora estamos, "conoce" o dispone de información
sobre cada uno de los componentes importados: la clase
que define su estado y comportamiento, el template que
esquematiza su contenido, la hoja de estilo que modifica
su aspecto, y eventualmente los tests que le haremos.
*/
import { AddComponent } from './components/add/add.component';
import { EditComponent } from './components/edit/edit.component';
import { HomeComponent } from './components/home/home.component';

/*
La constante routes, de tipo Routes, es un array de
objetos. Cada uno de esos obejtos define un end point.
El valor de la clave path es, naturalmente, lo que está
en la URL, además del nombre de dominio y el puerto.
Por ejemplo, en mi PC, la URL http://localhost:4200/home
hace que se muestre el componente Home, con la lista
de las tareas que haya en la base de datos.
*/
const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'edit/:id', component: EditComponent },
  { path: 'add', component: AddComponent }
];

/*
https://angular.io/api/router/RouterModule
RouterModule
Agrega directivas y proveedores para la navegación 
dentro de la aplicación entre las vistas 
definidas en una aplicación. Utilice el 
servicio de enrutador angular para especificar 
de forma declarativa los estados de la 
aplicación y administrar las transiciones 
de estado.
El método forRoot() crea un NgModule 
que contiene todas las directivas, 
las rutas dadas y el propio servicio 
de enrutador.
*/
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

/*
Esta es la clase que se exporta, para poder
ser usada en otros componentes.
*/
export class AppRoutingModule { }
