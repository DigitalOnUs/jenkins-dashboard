import { Component, OnInit } from '@angular/core';

declare const $: any;
declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
    { path: 'connections/new', title: 'Connection',  icon: 'dashboard', class: '' },
    { path: 'image/create', title: 'Images',  icon:'adjust', class: '' },
    { path: 'jenkins/status', title: 'Jenkins',  icon:'content_paste', class: '' },
    { path: 'pipeline/generator', title: 'Pipeline Generator',  icon:'library_books', class: '' }
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
      if ($(window).width() > 991) {
          return false;
      }
      return true;
  };
}
