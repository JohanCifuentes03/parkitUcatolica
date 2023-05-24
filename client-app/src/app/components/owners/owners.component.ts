import { Component, OnInit } from '@angular/core';
import { ParkingOwner } from './owner';
import { ParkingOwnerService } from './owner.service';

@Component({
  selector: 'app-owners',
  templateUrl: './owners.component.html',
  styleUrls: ['./owners.component.css']
})
export class OwnersComponent implements OnInit {

  owners: ParkingOwner[] = [];

  constructor(private parkingOwnerService: ParkingOwnerService) {}

  ngOnInit(): void {
    this.parkingOwnerService.getAllParkingOwners().subscribe(
      (owners) => {
        this.owners = owners;
      }
    );
  }
}
