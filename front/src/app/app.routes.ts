import { Routes } from '@angular/router';
import { AuthGuard } from './guards/Auth.guard';

export const routes: Routes = [
    {
        path: '',
        redirectTo: '/dashboard',
        pathMatch: 'full'
    },
    {
        path: 'auth',
        loadChildren: () => import('./auth/auth.routes').then((m) => m.routes)
    },
    {
        path: 'dashboard',
        loadChildren: () => import('./dashboard/dashboard.routes').then((m) => m.routes),
        canActivate: [AuthGuard]
    }
];
