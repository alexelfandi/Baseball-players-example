import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { IndexComponent } from './index/index.component';
import { HttpClientModule } from '@angular/common/http';
import { PlayerService } from './service/player.service';
import { TeamsComponent } from './teams/teams.component';
import { PlayersComponent } from './players/players.component';

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    TeamsComponent,
    PlayersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [PlayerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
