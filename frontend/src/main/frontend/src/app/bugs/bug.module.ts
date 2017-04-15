import { NgModule }         from '@angular/core';

import { SharedModule }     from '../shared/shared.module';
import { BugRoutingModule } from './bugs-routing.module';
import { ReactiveFormsModule }   from '@angular/forms';

//component
import { BugListComponent } from './bug-list/bug-list.component';

//service
import { BugService }       from './service/bug.service';

//model
import { BugDetailComponent }        from './bug-detail/bug-detail.component';

@NgModule({
  imports: [
    SharedModule,
    BugRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [
    BugListComponent,
    BugDetailComponent
  ],
  exports: [],
  providers: [
    BugService
  ]
})
export class BugModule {

}
