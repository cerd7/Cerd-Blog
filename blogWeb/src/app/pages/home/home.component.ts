import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BackgroundComponent } from "../../components/background/background.component";

@Component({
  selector: 'app-home',
  imports: [
    RouterModule,
    BackgroundComponent
],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
    resetZoom(){
      document.body.style.zoom = "1.0";
    }
}
