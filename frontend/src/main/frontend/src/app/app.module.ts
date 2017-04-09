//module
import { BrowserModule }          from '@angular/platform-browser';
import { NgModule }               from '@angular/core';
import { AppRoutingModule }       from './app-routing.module';
import { BugModule }              from './bugs/bug.module';

//Component
import { AppComponent }           from './app.component';
import { NavbarComponent }        from './navbar/navbar.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    BugModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
