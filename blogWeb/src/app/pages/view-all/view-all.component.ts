import { Component, OnInit } from '@angular/core';
import { PostService } from '../../services/Service-Post/post.service';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { CommonModule } from '@angular/common';
import { MatGridListModule } from '@angular/material/grid-list';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-view-all',
  imports: [
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    RouterModule,
    CommonModule,
    MatGridListModule
],
  templateUrl: './view-all.component.html',
  styleUrl: './view-all.component.scss'
})
export class ViewAllComponent implements OnInit{
  allPosts:any;

  constructor(private postService: PostService){}

    ngOnInit(): void {
      this.getAllPosts();
    }

    getAllPosts(){
      this.postService.getAllPosts().subscribe(res =>{
        console.log(res);
        this.allPosts = res;
      }, error =>{
        alert("Something went wrong!!!")
      })
    }
}
