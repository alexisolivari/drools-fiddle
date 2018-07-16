import { Injectable } from '@angular/core';
import {Location, LocationStrategy, PathLocationStrategy} from "@angular/common";

import {Observable} from "rxjs";
import { map } from 'rxjs/operators';
import {SocketIo} from "ng-io";

@Injectable({
    providedIn: 'root'
})
export class SocketService {
    /* location: Location;

    constructor(location: Location, private socket: SocketIo) {
        this.location = location;
    }

    public onOpen(){
        console.log('Open');
    }

    public send(message): void {
        this.socket.emit( message);
    }

     public onMessage(): Observable<any> {
        return new Observable<any>(observer => {
            this.socket.on('message', (data) => observer.next(data));
        });
    }

    public onMessage (event) {
        return this.socket
            .fromEvent("message").pipe(map( data => data ));
    }
    */

}
