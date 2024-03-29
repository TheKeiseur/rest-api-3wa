import { Component, OnInit } from '@angular/core';
import {Client} from "../model/client";
import {ClientService} from "../services/client.service";

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.scss']
})
export class ClientListComponent implements OnInit {

  clients!: Client[];

  constructor(private clientService : ClientService) { }

  ngOnInit(): void {
    this.clientService.findAll().subscribe(data => this.clients = data);
  }

}
