import { ChangeDetectorRef, Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';
import { MatChipsModule } from '@angular/material/chips';
import { MatIconModule } from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {FormsModule} from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
import { PostService } from '../../services/Service-Post/post.service';

@Component({
  selector: 'app-create-post',
  standalone: true,
  imports: [
    MatCardModule,
    MatFormFieldModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatChipsModule,
    MatIconModule,
    FormsModule,
    MatInputModule,
    CommonModule
],
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.scss']
})

export class CreatePostComponent {
  
  postForm!: FormGroup;
  tags: string[] = [];

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private cdRef: ChangeDetectorRef,
    private postService: PostService,
  ){}

  ngOnInit() {
  this.postForm = this.fb.group({
    name: [null, Validators.required],
    content: [null, [Validators.required, Validators.maxLength(5000)]],
    img: [null, Validators.required],
    postedBy: [null, Validators.required],
  });
  }

    add(event: any) {
    const value = event.target.value.trim();
    if (value) {
      this.tags.push((value));
      event.target.value = '';

      this.cdRef.detectChanges();
    }
  }

    remove(index: any) {
      this.tags.splice(index, 1);
  }
    createPost(){
      const data = this.postForm.value;
      data.tags = this.tags;

      if(this.postForm.invalid){
        alert("Please fill all required fields!!!");
        return;
      }
          this.postService.createNewPost(data).subscribe(res =>{
          alert("Post created successfully !!!");
          this.router.navigateByUrl("/view-post/last");
      }, error=>{   
          alert("Something went wrong!!!");
    })
  }
  
    onKeyDown(event: KeyboardEvent){
      event.preventDefault();
  }
}
