import { Component } from '@angular/core';
import { TodoService } from '../../services/todo.service';
import { iTodo } from '../../models/itodo';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {

  todosArray: iTodo[] = [];

  constructor(private todoSvc: TodoService) {
    this.todoSvc.$getTodosArray.subscribe((todos) => (this.todosArray = todos));
  }

}
