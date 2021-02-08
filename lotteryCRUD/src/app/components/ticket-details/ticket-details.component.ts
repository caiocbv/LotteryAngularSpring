import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { LotteryService } from './../../services/lottery.service';


@Component({
  selector: 'app-ticket-details',
  templateUrl: './ticket-details.component.html',
  styleUrls: ['./ticket-details.component.css']
})
export class TicketDetailsComponent implements OnInit {
  currentTicket = {
    email: '',
    jogo: []
  };
  message = '';

  submitted = false;

  constructor(

      private lotteryService : LotteryService,
      private route: ActivatedRoute,
      private router: Router

  ) { }

  ngOnInit(): void {
    this.message = '';
  }

  onKeyUp(evento: KeyboardEvent){
    this.currentTicket.email = (evento.target as HTMLInputElement).value;
  }

  getTicket(email: any): void {
   this.lotteryService.findByEmail(email)
      .subscribe(
        data => {
          this.currentTicket.jogo = data;
          this.submitted = true;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

}
