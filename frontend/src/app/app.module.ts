import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';

/*
Estas son las clases que exportan todos los módulos
que hemos creado nosotros para nuestra aplicación.
*/
import { AppComponent } from './app.component';
import { AddComponent } from './components/add/add.component';
import { EditComponent } from './components/edit/edit.component';
import { HomeComponent } from './components/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    EditComponent,
    AddComponent,
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})

/*
Esta es la clase del módulo principal de nuestra
aplicación, es la que hace que todo lo demás
funcione.
*/
export class AppModule { }
