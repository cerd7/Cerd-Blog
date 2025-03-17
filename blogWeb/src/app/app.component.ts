import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BackgroundComponent } from "./components/background/background.component";

@Component({
  selector: 'app-root',
  imports: [
    RouterOutlet,
    BackgroundComponent
],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title: any;
}
