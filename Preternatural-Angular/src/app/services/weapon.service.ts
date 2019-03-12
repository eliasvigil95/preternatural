import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Weapon } from '../models/weapon.model';

@Injectable({
  providedIn: 'root'
})
export class WeaponService {

  apiUrl: string = "http://localhost:8085/weapons"

  constructor(private httpClient: HttpClient) {}

  public getAllWeapons(){
    return this.httpClient.get<Weapon[]>(`${this.apiUrl}/all`);
  };

  public getWeaponByName(name: string) {
    return this.httpClient.get<Weapon[]>(`${this.apiUrl}/getByName/` + name);
  };

  public deleteWeaponByName(name: string) {
    return this.httpClient.post(`${this.apiUrl}/delete`, {
      Name: name
    });
  };

  public createWeapon(weapon: Weapon) {
    return this.httpClient.post(`${this.apiUrl}/create`, weapon);
  };

  public updateWeapon(weapon: Weapon) {
    return this.httpClient.put(`${this.apiUrl}/update`, weapon);
  }
}
