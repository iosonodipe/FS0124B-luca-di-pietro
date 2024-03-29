import { Component } from '@angular/core';
import { iTodo } from '../../models/itodo';
import { TodoService } from '../../services/todo.service';
import { map } from 'rxjs';

@Component({
  selector: 'app-uncompleted',
  templateUrl: './uncompleted.component.html',
  styleUrl: './uncompleted.component.scss'
})
export class UncompletedComponent {
  uncompletedTodosArray: iTodo[] = [];

  constructor(private todoSvc: TodoService) {
    todoSvc.$getTodosArray
      .pipe(map((todos) => todos.filter((todo) => todo.completed == false)))
      .subscribe(todos => this.uncompletedTodosArray = todos);
  }
}
