import { NgModule } from '@angular/core';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterializeModule } from 'angular2-materialize';
import { CommonModule } from '@angular/common';
import { ImageService } from '../../../../services/image.service';
import { CreateImageComponent } from './creation-images.component';


@NgModule({
    imports: [ReactiveFormsModule, CommonModule, MaterializeModule, FormsModule],
    exports: [CreateImageComponent],
    declarations: [CreateImageComponent],
    providers:[ImageService]
})
export class CreateImageModule { }
