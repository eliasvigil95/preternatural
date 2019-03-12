import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Power } from '../models/power.model';

@Injectable({
  providedIn: 'root'
})
export class PowerService {

  apiUrl: string = "http://localhost:8085/powers"
  constructor(private httpClient: HttpClient) { }

  public getAllPowers(){
    return this.httpClient.get<Power[]>(`${this.apiUrl}/all`)
  }

  public getPowerByName(name: string) {
    return this.httpClient.get<Power[]>(`${this.apiUrl}/getByName/` + name);
  }

  public deletePowerByName(name: string) {
    return this.httpClient.post(`${this.apiUrl}/delete`, {
      Name: name
    });
  }
  
  public createPower(power: Power) {
    return this.httpClient.post(`${this.apiUrl}/create`, power);
  }

  public updatePower(power: Power) {
    return this.httpClient.put(`${this.apiUrl}/update`, power);
  }
}
