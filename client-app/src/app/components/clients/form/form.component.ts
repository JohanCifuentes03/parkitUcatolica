import { Component, OnInit } from '@angular/core';
import { Client } from '../client';
import { ClientService } from '../client.service';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
})
export class FormComponent implements OnInit {

  public client: Client = new Client();
  public title: string = 'Create Client';
  
  constructor(
    private clientService: ClientService, 
    private router: Router,
    private activatedRoute: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    this.loadClient();
  }

  public loadClient(): void {
    this.activatedRoute.params.subscribe(params => {
      let id = params['id'];
      if (id) {
        this.clientService.getClient(id).subscribe(client => this.client = client);
      }
    });
  }

  public edit(): void {
    this.clientService.createClient(this.client).subscribe(client => {
      this.router.navigate(['/clients']);
      Swal.fire({
        title: 'Cliente editado',
        icon: 'success',
        text: `Cliente ${client.nombre} editado exitosamente`,
      });
    });
  }
}
