import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title:   string = 'client-app';
  course:  string = 'Curso Spring 5 con Angular 7';
  teacher: string = 'Andres Guzman';
}
