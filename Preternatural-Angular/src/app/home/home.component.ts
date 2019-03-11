import { Component, OnInit } from '@angular/core';
import { CharacterService } from '../services/character.service';
import { Character } from '../models/character.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  // var createCharacter: Character = {
  //   first: "Caden",

  // }
  constructor(private characterService: CharacterService) { }

  ngOnInit() {
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
    this.characterService.getCharactersByStage("Expert").subscribe((data => {
      console.log(data);
    }))

  }

}
