import { HttpErrorResponse, HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';

export const httpInterceptor: HttpInterceptorFn = (req, next) => {
    const router = inject(Router);
    const authToken = localStorage.getItem("token");



    const validRoute = (): boolean => {
        return !req.url.includes('/auth')
    }

    const authReq = req.clone({
        setHeaders: {
            Authorization: validRoute() ? `Bearer ${authToken}` : ''
        }
    });

    return next(authReq).pipe(
        catchError((err: any) => {
            if (err instanceof HttpErrorResponse) {
                if(err.status === 403) {
                    router.navigateByUrl('/auth/login')
                }
            }

            return throwError(() => err);
        })
    );
};