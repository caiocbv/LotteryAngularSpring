import { logging } from 'protractor';
import { Component, OnInit } from '@angular/core';

import { LotteryService } from './../../services/lottery.service';

@Component({
  selector: 'app-add-random-ticket',
  templateUrl: './add-random-ticket.component.html',
  styleUrls: ['./add-random-ticket.component.css']
})

export class AddRandomTicketComponent implements OnInit {
  email : string = '';
  submitted = false;
  numbers = [];

  constructor(private lotteryService : LotteryService) { }

  ngOnInit(): void {
  }

  onKeyUp(evento: KeyboardEvent){
    this.email = (evento.target as HTMLInputElement).value;
  }


  generateTicket(): void{
    this.lotteryService.create(this.email)
    .subscribe(
      response => {
        console.log(response);
        this.numbers = response;
        this.submitted = true;
      },
      error => {
        console.log(error);
      });
  }

  newTicket(){
    this.email = '';
    this.submitted = false;
  }

}
