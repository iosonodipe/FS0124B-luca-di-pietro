import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrl: './searchbar.component.scss'
})
export class SearchbarComponent {

  searchedUser: string = ''

  @Output()
  searchedUserChanged: EventEmitter<string> = new EventEmitter<string>()

  onSearchdUserChanged(){
    this.searchedUserChanged.emit(this.searchedUser)
  }
}
