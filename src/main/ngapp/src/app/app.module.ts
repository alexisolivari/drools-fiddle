import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { VisualisationComponent } from './visualisation/visualisation.component';
import { LogsComponent } from './logs/logs.component';
import { RulesComponent } from './user/rules/rules.component';
import { FactsComponent } from './user/facts/facts.component';
import {DRLService} from './services/drl.service';
import {EventsService} from './services/events.service';
import {FactsService} from './services/facts.service';
import { RouterModule, Routes} from '@angular/router';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user/user.component';
import {NgJsonEditorModule} from 'ang-jsoneditor';
import {Bootstrap3FrameworkModule, JsonSchemaFormModule} from 'angular2-json-schema-form';
import {HttpClientModule} from '@angular/common/http';
import {Location, LocationStrategy, PathLocationStrategy} from '@angular/common';
import {VisModule} from 'ng2-vis';
import {NgxToggleModule} from 'ngx-toggle';
import {PopoverModule} from 'ngx-popover';
import {AceEditorModule} from 'ng2-ace-editor';
import {AngularFontAwesomeModule} from 'angular-font-awesome';
import {StepFunctionsService} from "./services/step-functions.service";
import {SocketService} from "./services/socket.service";
import {NgIoConfig, NgIoModule} from "ng-io";


const appRoutes: Routes = [
  { path: '', component: HomeComponent},
  { path: '**', redirectTo: ''}
];

const config: NgIoConfig = { url: 'ws://localhost/websocket/log', options: {} };



@NgModule({
    declarations: [
    AppComponent,
    HeaderComponent,
    VisualisationComponent,
    LogsComponent,
    RulesComponent,
    FactsComponent,
    HomeComponent,
    UserComponent

  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes), // The router module helps you to control the path of your page.
    AceEditorModule, // This is the module for Ace, the text editor in the Rules part.
    NgJsonEditorModule, // This is a library for Json
    Bootstrap3FrameworkModule, // Those two lines set the module for json-schema-form
    JsonSchemaFormModule.forRoot(Bootstrap3FrameworkModule), // it helps us to create the form in the Facts part.
    HttpClientModule, // This is the module that allows us an interaction with the backend, we can get and post thanks to this.
    VisModule, // This is the module for Vis, Vis allows us to vew the network connections in the Visualisation part.
    NgxToggleModule, // This is the module that allows us to do the live button in the header
    PopoverModule, // This is the module that allows to pop the information legend in the visualisation part.
    AngularFontAwesomeModule,
    NgIoModule.forRoot(config)
  ],
  providers: [
      DRLService,
      EventsService,
      FactsService,
      Location,
      {provide: LocationStrategy, useClass: PathLocationStrategy},
      StepFunctionsService,
      SocketService],

  bootstrap: [AppComponent]
})
export class AppModule { }
