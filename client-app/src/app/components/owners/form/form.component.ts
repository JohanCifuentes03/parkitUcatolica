import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { ParkingOwner } from '../owner';
import { ParkingOwnerService } from '../owner.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
})
export class FormComponent implements OnInit {

  public owner: ParkingOwner = new ParkingOwner();
  public title: string = 'Crear dueño';

  constructor(
    private parkingOwnerService: ParkingOwnerService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.loadOwner();
  }

  public loadOwner(): void {
    this.activatedRoute.params.subscribe(params => {
      let id = params['id'];
      if (id) {
        this.parkingOwnerService.getParkingOwnerById(id).subscribe(owner => this.owner = owner);
      }
    });
  }

  public edit(): void {
    this.parkingOwnerService.updateParkingOwner(this.owner).subscribe(updatedOwner => {
      this.router.navigate(['/owners']);
      Swal.fire({
        title: 'Dueño editado',
        icon: 'success',
        text: `Dueño ${updatedOwner.nombre} editado exitosamente`,
      });
    });
  }
}
