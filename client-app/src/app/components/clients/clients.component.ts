import { Component, OnInit } from '@angular/core';
import { Client } from './client';
import { ClientService } from './client.service';


@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./client.component.css'],

})
export class ClientsComponent implements OnInit {

  clients: Client [] = [];
  private clientService : ClientService;

  constructor(clientService: ClientService ) {
    this.clientService = clientService;
   }

  ngOnInit(): void {

    this.clientService.getClients().subscribe(
       (clients) => {
        this.clients = clients;
      }
    );
    
  }
}
