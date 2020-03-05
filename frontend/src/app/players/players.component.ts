import { Component, OnInit } from '@angular/core';
import { Player } from '../domain/player';
import { PlayerService } from '../service/player.service';
import { Page } from '../domain/page';
import { TooltipPosition } from '@angular/material/tooltip';
import { ThemePalette } from '@angular/material/core';

@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.css']
})
export class PlayersComponent implements OnInit {

  paginatedObject: Page = new Page();
  paginationProperties: [];

  constructor(private playerService: PlayerService) { }

  ngOnInit(): void {

    this.getPage();

  }

  nextPage(){
    this.getPage(this.paginatedObject.pageNumber + 1, this.paginatedObject.pageSize)
  }

  previousPage(){
    this.getPage(this.paginatedObject.pageNumber - 1, this.paginatedObject.pageSize)
  }

  lastPage(){
    this.getPage(this.paginatedObject.totalPages, this.paginatedObject.pageSize)
  }

  firstPage(){
    this.getPage(0, this.paginatedObject.pageSize)
  }


  getPage(page:  number = 0, size: number = 10){

    this.playerService.getPaginated(page, size).subscribe((data) => {
      this.paginatedObject.content = data["content"];
      this.paginationProperties = data["pageable"];
      this.paginatedObject.pageNumber = this.paginationProperties["pageNumber"];
      this.paginatedObject.pageSize = this.paginationProperties["pageSize"];
      this.paginatedObject.totalElements = data["totalElements"];
      this.paginatedObject.totalPages = data["totalPages"] - 1
    
    });

  }

}
