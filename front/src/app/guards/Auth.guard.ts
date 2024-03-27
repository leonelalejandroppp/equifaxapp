import { CanActivateFn, Router } from '@angular/router';
import { Injectable, inject } from '@angular/core';



export const AuthGuard: CanActivateFn =  (route, state) => {
  const token = localStorage.getItem("token")
  const router = inject(Router);
  if(token) return true;

  return router.navigateByUrl("/auth/login")

};