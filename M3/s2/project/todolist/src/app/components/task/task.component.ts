import { Component, Input } from '@angular/core';
import { iTodo } from '../../models/itodo';
import { TodoService } from '../../services/todo.service';
import { iUser } from '../../models/iuser';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrl: './task.component.scss',
})
export class TaskComponent {
  @Input() todo!: iTodo;

  constructor(private todoSvc: TodoService, private userSvc: UserService) {}

  updateComplete(todo: iTodo) {
    this.todoSvc.updateTodos(todo);
  }

  getUser(userIdTodo: number): iUser | null{
    return this.userSvc.getUserById(userIdTodo)
  }
}
