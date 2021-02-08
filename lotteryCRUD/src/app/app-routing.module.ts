import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TicketDetailsComponent } from './components/ticket-details/ticket-details.component';
import { AddRandomTicketComponent } from './components/add-random-ticket/add-random-ticket.component';

const routes: Routes = [
  { path: '', redirectTo: 'add', pathMatch: 'full' },
  { path: 'tickets', component: TicketDetailsComponent },
  { path: 'add', component: AddRandomTicketComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
