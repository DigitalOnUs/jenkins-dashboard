import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfileComponent } from './views/profile.component';
import { ProfileModule } from './views/profile.module';


export const ROUTES: Routes = [
    {
        path: 'user',
        component: ProfileComponent
    }
];

@NgModule({
    imports: [
        ProfileModule,
        RouterModule.forChild(ROUTES)
    ]
})
export class ProfileRouting {
    static routes = ROUTES;
}
