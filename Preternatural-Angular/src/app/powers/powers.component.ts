import { Component, OnInit } from '@angular/core';
import { PowerService } from '../services/power.service';
import { Power } from '../models/power.model';

@Component({
  selector: 'app-powers',
  templateUrl: './powers.component.html',
  styleUrls: ['./powers.component.scss']
})
export class PowersComponent implements OnInit {

  constructor(public powerService: PowerService) { }

  ngOnInit() {
    var createPower: Power = {
      ID: 0,
      Name: "Object Surface Extension",
      Description: "The ability to extend the surfaces of objects.",
      Picture: "http://www.google.com",
      Stage: "Expert"

    };

    var updatePower: Power = {
      ID: 8,
      Name: "Object State Manipulation",
      Description: "The ability to age objects.",
      Picture: "http://www.google.com",
      Stage: "Advanced"
    };

    this.powerService.getAllPowers().subscribe((data) => {
      console.log(data);
    });

    this.powerService.getPowerByName("Object Form").subscribe((data) => {
      console.log(data);
    });

    this.powerService.deletePowerByName("Object Sizing").subscribe((data) => {
      console.log(data);
    });

    this.powerService.createPower(createPower).subscribe((data) => {
      console.log(data);
    });

    this.powerService.updatePower(updatePower).subscribe((data) => {
      console.log(data);
    });
  }

}
