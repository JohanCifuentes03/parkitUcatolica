import { Component, OnInit } from '@angular/core';
import { Reserve } from './reserve';
import { ReserveService } from './reserve.service';

@Component({
  selector: 'app-reserve',
  templateUrl: './reserve.component.html',
  styleUrls: ['./reserve.component.css']
})
export class ReserveComponent implements OnInit {


  reserves: Reserve[] = [];

  
  constructor(private reserveService: ReserveService) {}

  ngOnInit(): void {
    this.reserveService.getAllReservas().subscribe(
      (reserves) => {
        this.reserves = reserves;
      }
    );
  }

}
