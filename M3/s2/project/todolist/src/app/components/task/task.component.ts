import { Component, Input } from '@angular/core';
import { iTodo } from '../../models/itodo';
import { TodoService } from '../../services/todo.service';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrl: './task.component.scss',
})
export class TaskComponent {
  @Input() todo!: iTodo;

  constructor(private todoSvc: TodoService) {}

  updateComplete(todo: iTodo) {
    this.todoSvc.updateTodos(todo);
  }
}
