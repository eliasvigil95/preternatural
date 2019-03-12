import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../models/user.model';
import { WeaponService } from '../services/weapon.service';
import { Weapon } from '../models/weapon.model';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  
  constructor(private userService: UserService, private weaponService: WeaponService) { }

  ngOnInit() {


    var createWeapon: Weapon = {
      ID: 0,
      Name: "H.A.R.Dened Bullet",
      Description: "An upgraded version of the AR Suppression Bullet that dampens a Preterhuman's healing ability over time."
    }
    var updateWeapon: Weapon = {
      ID: 10,
      Name: "AR Suppression Bullet",
      Description: "An upgraded version of the Suppression Bullet that prevents Object Repair Specialists from repairing wounds inflicted with this weapon."
    }

    this.weaponService.getAllWeapons().subscribe((data) => {
      console.log(data);
    });

    this.weaponService.getWeaponByName("X Field").subscribe((data) => {
      console.log(data);
    });

    this.weaponService.deleteWeaponByName("Suppression Cuff").subscribe((data) => {
      console.log(data);
    }); 

    this.weaponService.createWeapon(createWeapon).subscribe((data) => {
      console.log(data);
    });

    this.weaponService.updateWeapon(updateWeapon).subscribe((data) => {
      console.log(data);
    })
    // var createUser: User = {
    //   ID: 0,
    //   First: "Nick",
    //   Last: "Zaitz", 
    //   Email: "nzaitz@mailinator.com",
    //   Username: "ZaitzN",
    //   Password: "Strobewreck",
    //   Role: "User"
    // };
    // var updateUser: User = {
    //   ID: 2,
    //   First: "Joe",
    //   Last: "Guzman", 
    //   Email: "jguzman95@mailinator.com",
    //   Username: "JGuzman",
    //   Password: "TheZaMaster",
    //   Role: "User"
    // };

    // this.userService.getAllUsers().subscribe((data) => {
    //   console.log(data);
    // });

    // this.userService.getUserByUsername("Vigilante").subscribe((data) => {
    //   console.log(data);
    // });

    // this.userService.deleteUserByUsername("TheZaMaster").subscribe((data) => {
    //   console.log(data);
    // });

    // this.userService.createUser(createUser).subscribe((data) => {
    //   console.log(data);
    // });

    // this.userService.updateUser(updateUser).subscribe((data) => {
    //   console.log(data);
    // });


  }

}
