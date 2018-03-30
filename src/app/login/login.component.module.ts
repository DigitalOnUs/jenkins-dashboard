
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";
import { MatStepperModule, MatStepperIntl } from "@angular/material";
import { LoginViewComponent } from "./login.component";



@NgModule({
  imports: [
    ReactiveFormsModule,
    CommonModule,
    FormsModule,
  ],
  declarations: [LoginViewComponent],
  exports: [LoginViewComponent],
  providers: []
})
export class LoginModule {}