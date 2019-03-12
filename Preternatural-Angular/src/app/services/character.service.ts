import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Character } from '../models/character.model';

@Injectable({
  providedIn: 'root'
})



export class CharacterService {

  apiUrl: string = "http://localhost:8085/characters";
  
  constructor(private httpClient: HttpClient) { 
    
    
  }


  public getAllCharacters(){
    return this.httpClient.get<Character[]>(`${this.apiUrl}/all`);
  }

  public getCharacterByFirstName(firstname: string){
    return this.httpClient.get<Character[]>(`${this.apiUrl}/getByFirstname/`+ firstname);
  }

  public getCharactersByLastName(lastname: string){
    return this.httpClient.get<Character[]>(`${this.apiUrl}/getByLastname/`+ lastname);
  }

  public getCharactersByRole(role: string){
    return this.httpClient.get<Character[]>(`${this.apiUrl}/getByRole/`+ role);
  }

  public getCharactersByRole2(role2: string){
    return this.httpClient.get<Character[]>(`${this.apiUrl}/getByRole2/`+ role2);
  }

  public getCharactersByAge(age: number){
    return this.httpClient.get<Character[]>(`${this.apiUrl}/getByAge/`+ age);
  }

  public getCharactersBySpecies(species: string){
    return this.httpClient.get<Character[]>(`${this.apiUrl}/getBySpecies/`+ species);
  }

  public getCharactersByStage(stage: string){
    return this.httpClient.get<Character[]>(`${this.apiUrl}/getByStage/`+ stage);
  }

  public createCharacter(character: Character){
    return this.httpClient.post(`${this.apiUrl}/create`, character);
  }
  
  public updateCharacter(character: Character){
    return this.httpClient.put(`${this.apiUrl}/update`, character);
  }
}
