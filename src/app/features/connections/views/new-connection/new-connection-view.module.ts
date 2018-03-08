import { NewConnectionViewComponent } from './new-connection-view.component';
import { NgModule } from "@angular/core";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {MaterializeModule} from "angular2-materialize";

@NgModule({
    imports: [ReactiveFormsModule, CommonModule, MaterializeModule, FormsModule],
    declarations:[NewConnectionViewComponent],
    exports: [NewConnectionViewComponent]
})
export class NewConnectionViewModule {}