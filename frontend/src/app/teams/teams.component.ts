import { Component, OnInit } from '@angular/core';
import { PlayerService } from '../service/player.service';
import { Player } from '../domain/player';

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {



  constructor(private playerService: PlayerService) { }

  ngOnInit(): void {



  }

  

}
