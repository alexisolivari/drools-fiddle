import { Component, OnInit } from '@angular/core';
import {EventsService} from '../../services/events.service';
import {Subscription} from 'rxjs';
import {SocketService} from "../../services/socket.service";

/* This component displays what we call the user part of the app
it is the part that includes the Rules and the facts. */

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {
  /* tabsSubscription: Subscription;
  activeArray: any[]; */

  constructor(private eventsService: EventsService, private socketService: SocketService) { }

  ioConnection: any;

  ngOnInit() { /*
    this.tabsSubscription = this.eventsService.tabsSubject.subscribe(
          (tabs: any[]) => {
              this.activeArray = tabs;
          }
      );
      this.eventsService.emitTabsSubject();
    console.log(this.activeArray); */
  //this.initIoConnection();

  }

    /* private initIoConnection(): void {

         this.ioConnection = this.socketService.onMessage()
            .subscribe((message: Message) => {
                this.messages.push(message);
            });

        this.socketService.onMessage(event)
            .subscribe((res) => {
              if (res === 'pong'){
                console.log('keep-alive: Pong');
              }
                console.log('connected');
            });

        this.socketService.onEvent(Event.DISCONNECT)
            .subscribe(() => {
                console.log('disconnected');
            });
    } */



}
