import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../../services/project.service';
import { ActivatedRoute } from '@angular/router';

declare const $: any;
declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}
export const ROUTES: RouteInfo[] = [
  {
    path: 'connections/new',
    title: 'Provider',
    icon: 'dashboard',
    class: ''
  },
  {
    path: 'pipeline/generator',
    title: 'Jenkins Creation',
    icon: 'library_books',
    class: ''
  },
  {
    path: 'jenkins/status',
    title: 'Jenkins Exection',
    icon: 'content_paste',
    class: ''
  }
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];
  projectId: any;
  nameOfProject: any;

  constructor(
    private projectService: ProjectService,
    private router: ActivatedRoute
  ) {
    this.router.parent.parent.params.subscribe(
      params => (this.projectId = params.id)
    );
  }

  ngOnInit() {
    this.getProjectName();
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
    if ($(window).width() > 991) {
      return false;
    }
    return true;
  }

  getProjectName(): any {
    this.projectService
      .getProjectName(this.projectId)
      .subscribe(data => (this.nameOfProject = data));
  }
}
