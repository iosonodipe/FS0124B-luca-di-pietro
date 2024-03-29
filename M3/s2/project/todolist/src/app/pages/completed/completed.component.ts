import { Component } from '@angular/core';
import { iTodo } from '../../models/itodo';
import { filter, map } from 'rxjs';
import { TodoService } from '../../services/todo.service';

@Component({
  selector: 'app-completed',
  templateUrl: './completed.component.html',
  styleUrl: './completed.component.scss',
})
export class CompletedComponent {
  completedTodosArray: iTodo[] = [];

  constructor(private todoSvc: TodoService) {
    todoSvc.$getTodosArray
      .pipe(map((todos) => todos.filter((todo) => todo.completed == true)))
      .subscribe(todos => this.completedTodosArray = todos);
  }
}
