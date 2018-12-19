import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AppRoutingModule,routingComponents } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
	routingComponents	
      ],
  imports: [	
  BrowserModule,
	HttpClientModule,
	FormsModule,
	ReactiveFormsModule,
	AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }