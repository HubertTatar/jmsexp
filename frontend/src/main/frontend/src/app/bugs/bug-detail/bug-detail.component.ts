import {Component, Input, OnInit}                               from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { forbiddenStringValidator }                        from '../../shared/validators/forbidden-string.validator'
import { BugService }                                      from '../service/bug.service';
import { Bug }                                             from "../model/bug";

@Component({
  moduleId: module.id,
  selector: 'bug-detail',
  templateUrl: 'bug-detail.component.html',
  styleUrls: ['bug-detail.component.css']
})
export class BugDetailComponent implements OnInit{
  private modalId = "bugModal";
  private bugForm: FormGroup;
  @Input() currnetBug: Bug = new Bug(null, null, null, 1, 1, null, null, null, null, null);

  constructor(private formB: FormBuilder, private bugService: BugService){}

  ngOnInit() {
    this.configureForm();
  }

  configureForm(bug?: Bug) {
    /* without formBuilder
      this.bugForm = new FormGroup({
      title: new FormControl(null, [Validators.required, forbiddenStringValidator(/doggy/i)]),
      status: new FormControl(1, Validators.required),
      severity: new FormControl(1, Validators.required),
      description: new FormControl(null, Validators.required)
    });*/
    if (bug) {
      this.currnetBug = bug;
    }
    this.bugForm = this.formB.group({
      title: [this.currnetBug.title , [Validators.required, forbiddenStringValidator(/doggy/i)]],
      status: [this.currnetBug.status, Validators.required],
      severity: [this.currnetBug.severity, Validators.required],
      description: [this.currnetBug.description, Validators.required]
    });
  }

  submitForm() {
    console.log(this.bugForm);
    this.addBug();
  }

  addBug() {
    this.currnetBug.title = this.bugForm.value["title"];
    this.currnetBug.status = this.bugForm.value["status"];
    this.currnetBug.severity = this.bugForm.value["severity"];
    this.currnetBug.description = this.bugForm.value["description"];
    this.bugService.addBug(this.currnetBug)
      .subscribe(bug => {
        console.log(bug);
        this.clearForm();
      },
      err => {
        console.log("unable to get added bug", err);
      });
  }

  clearForm() {
    this.bugForm.reset({
      status: 1,
      severity: 1
    });
    this.cleanBug();
  }

  cleanBug() {
    this.currnetBug = new Bug(null, null, null, 1, 1, null, null, null, null, null);
  }
}
