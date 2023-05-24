import { Component, OnInit } from '@angular/core';
import { Parking } from './parking';
import { ParkingService } from './parking.service';

@Component({
  selector: 'app-parking',
  templateUrl: './parking.component.html',
  styleUrls: ['./parking.component.css']
})
export class ParkingComponent implements OnInit {

  parkings: Parking[] = [];

  
  constructor(private parkingService: ParkingService) {}

  ngOnInit(): void {
    this.parkingService.getAllParkings().subscribe(
      (parkings) => {
        this.parkings = parkings;
      }
    );
  }
}
