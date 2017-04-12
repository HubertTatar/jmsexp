//module
import { BrowserModule }          from '@angular/platform-browser';
import { NgModule }               from '@angular/core';
import { AppRoutingModule }       from './app-routing.module';
import { BugModule }              from './bugs/bug.module';
import { CoreModule }             from './core/core.module';
import { HttpModule, JsonpModule } from '@angular/http';

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
    AppRoutingModule,
    CoreModule.forRoot(),
    HttpModule,
    JsonpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
