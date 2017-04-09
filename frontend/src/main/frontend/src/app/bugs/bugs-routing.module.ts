import { NgModule }                 from '@angular/core';
import { RouterModule, Routes }     from '@angular/router';

import { BugListComponent }         from "./bug-list/bug-list.component";


const bugsRoutes: Routes = [
  {
    path: '', redirectTo: 'bugs', pathMatch: 'full'},
  { path: 'bugs', component: BugListComponent },
  { path: '**', redirectTo: 'bugs' }
];

@NgModule({
  imports: [
    RouterModule.forChild(bugsRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class BugRoutingModule {}
