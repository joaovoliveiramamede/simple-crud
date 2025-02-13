import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar-pages',
  templateUrl: './navbar-pages.component.html',
  styleUrls: ['./navbar-pages.component.scss']
})
export class NavbarPagesComponent {
  authLoginRedirect: string = "/auth/login"
}
