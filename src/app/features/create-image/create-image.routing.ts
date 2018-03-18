import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateImageComponent } from './views/create-image.component';
import { CreateImageModule } from './views/create-image.module';

export const ROUTES: Routes = [
    {
        path: 'create',
        component: CreateImageComponent
    }
];

@NgModule({
    imports: [
        CreateImageModule,
        RouterModule.forChild(ROUTES)
    ]
})
export class CreateImageRouting {
    static routes = ROUTES;
}
