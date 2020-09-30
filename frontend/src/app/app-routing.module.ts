import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateRoomComponent } from './components/create-room/create-room.component';
import { RoomDetailsComponent } from './components/room-details/room-details.component';
import { RoomListComponent } from './components/room-list/room-list.component';
import { UpdateRoomComponent } from './components/update-room/update-room.component';

const routes: Routes = [
  { path: '', redirectTo: 'rooms', pathMatch: 'full' },
  { path: 'rooms', component: RoomListComponent },
  { path: 'add', component: CreateRoomComponent },
  { path: 'update/:id', component: UpdateRoomComponent },
  { path: 'details/:id', component: RoomDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }