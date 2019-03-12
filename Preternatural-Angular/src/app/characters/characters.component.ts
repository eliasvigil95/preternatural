import { Component, OnInit } from '@angular/core';
import { CharacterService } from '../services/character.service';
import { Character } from '../models/character.model';

@Component({
  selector: 'app-characters',
  templateUrl: './characters.component.html',
  styleUrls: ['./characters.component.scss']
})
export class CharactersComponent implements OnInit {

  constructor(private characterService: CharacterService) { }

  ngOnInit() {
    var createCharacter: Character = {
      ID: 0,
      First: "Caden",
      Last: "Stone",
      Age: 28,
      Description: "Caden is Luke's friend who was commited to an asylum after he was injected with the Preterneutralizer serum.",
      Picture: "http://www.google.com",
      Role1: "Tertiary",
      Role2: "Not Applicable",
      Species: "Human",
      Stage: "None"
    };

    var updateCharacter: Character = {
      ID: 5,
      First: "Hartley",
      Last: "Sinclair",
      Age: 17,
      Description: "Hartley is Jason's childhood friend and has been his confidant for a long time.",
      Picture: "http://www.google.com",
      Role1: "Secondary",
      Role2: "Love Interest",
      Species: "Human",
      Stage: "None"
    }

    this.characterService.getAllCharacters().subscribe((data) => {
      console.log(data);
    });
    this.characterService.getCharacterByFirstName("Hartley").subscribe((data) => {
      console.log(data);
    });
    this.characterService.getCharactersByLastName("Gray").subscribe((data) => {
      console.log(data);
    });
    this.characterService.getCharactersByAge(47).subscribe((data) => {
      console.log(data);
    });
    this.characterService.getCharactersByRole("Tertiary").subscribe((data) => {
      console.log(data);
    });
    this.characterService.getCharactersByRole2("Mentor").subscribe((data) => {
      console.log(data);
    });
    this.characterService.getCharactersBySpecies("Preterhuman").subscribe((data) => {
      console.log(data);
    });
    this.characterService.getCharactersByStage("Expert").subscribe((data) => {
      console.log(data);
    });
    this.characterService.createCharacter(createCharacter).subscribe((data) => {
      console.log(data);
    });
    this.characterService.updateCharacter(updateCharacter).subscribe((data) => {
      console.log(data);
    })
  }

}
