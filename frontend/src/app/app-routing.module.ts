import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'pages',
    pathMatch: 'full'
  },
  {
    path: 'pages',
    loadChildren: () => import('./pages/pages.module').then(module => module.PagesModule)
  },
  {
    path: 'auth',
    loadChildren: () => import('./auth/auth.module').then(module => module.AuthModule)
  },
  {
    path: 'client',
    loadChildren: () => import('./modules/client/client.module').then(module => module.ClientModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
