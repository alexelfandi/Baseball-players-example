import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { TeamsComponent } from './teams/teams.component';
import { PlayersComponent } from './players/players.component';


const routes: Routes = [
  {path: "", component: IndexComponent},
  {path: "index", component: IndexComponent},
  {path: "teams", component: TeamsComponent},
  {path: "players", component: PlayersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  
}
