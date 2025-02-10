import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { NotFoundComponent } from './components/not-found/not-found.component';

export const routes: Routes = [
    {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full'
    },
    { path: 'home', component: HomeComponent },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: '**', component: NotFoundComponent }
];
