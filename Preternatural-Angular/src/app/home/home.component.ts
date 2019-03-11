import { Component, OnInit } from '@angular/core';
import { CharacterService } from '../services/character.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private characterService: CharacterService) { }

  ngOnInit() {
    this.characterService.getAllCharacters().subscribe((data) => {
      console.log(data);
    })
  }

}
