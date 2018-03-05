import { NgModule } from '@angular/core';
import { CreateImageComponent } from './create-image.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterializeModule } from 'angular2-materialize';
import { CommonModule } from '@angular/common';

@NgModule({
    imports: [ReactiveFormsModule, CommonModule, MaterializeModule, FormsModule],
    exports: [CreateImageComponent],
    declarations: [CreateImageComponent]
})
export class CreateImageModule { }
