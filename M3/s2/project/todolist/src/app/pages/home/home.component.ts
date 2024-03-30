import { Component } from '@angular/core';
import { TodoService } from '../../services/todo.service';
import { iTodo } from '../../models/itodo';
import { iUser } from '../../models/iuser';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {

  todosArray: iTodo[] = [];
  usersArray: iUser[] = [];
  searchedUser: string = ''

  constructor(private todoSvc: TodoService, private userSvc: UserService) {
    this.todoSvc.$getTodosArray.subscribe((todos) => (this.todosArray = todos));
    this.userSvc.$getUsersArray.subscribe((users) => (this.usersArray = users));
  }

  onSearchedUserEntered(searchedUser: string){
    this.searchedUser = searchedUser
  }

}
