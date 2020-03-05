import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Player } from '../domain/player';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http: HttpClient) {}


  public getPaginated(page: number, size: number): Observable<Player[]>{
    return this.http.get<Player[]>(`http://localhost:8080/page?page=${page},?size=${size}`);
  }

  



}
