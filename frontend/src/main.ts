import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

/*
La clase AppModule tiene toda la información
sobre los otros componentes de la aplicación.
Está implementada, como se indica en el argumento
de from, en el archivo app.module.ts que está
en la carpeta ./app.
*/
import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
