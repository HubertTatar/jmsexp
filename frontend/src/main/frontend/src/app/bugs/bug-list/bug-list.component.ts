import { Component, OnInit } from '@angular/core';

import { BugService }        from '../service/bug.service';
import { Bug }               from '../model/bug';

@Component({
  moduleId: module.id,
  selector: 'bug-list',
  templateUrl: 'bug-list.component.html',
  styleUrls: [ 'bug-list.component.css' ]
})
export class BugListComponent implements OnInit {

  private bugs: Bug[] = [];

  constructor (private bugService: BugService) {}

  ngOnInit() {
    console.log('ads');
    // this.getBugs();
    this.getAddedBugs();
  }

  getAddedBugs() {
    this.bugService.getAddedBugs()
      .subscribe(bugs => {
        console.log(bugs);
        this.bugs = bugs;
      },
      err => {
        console.log("unable to get added bug", err);
      });
  }
}
