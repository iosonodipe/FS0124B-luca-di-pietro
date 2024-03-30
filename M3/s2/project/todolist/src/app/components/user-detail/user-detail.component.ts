import { Component, Input } from '@angular/core';
import { iUser } from '../../models/iuser';
import { iTodo } from '../../models/itodo';
import { TodoService } from '../../services/todo.service';
import { map } from 'rxjs';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrl: './user-detail.component.scss'
})
export class UserDetailComponent {
@Input() user!: iUser
userTodosArray: iTodo[] = []

constructor(private todoSvc: TodoService){}

ngAfterContentInit(){
  this.todoSvc.$getTodosArray
  .pipe(map((todos) => todos.filter((todo) => todo.userId == this.user.id)))
  .subscribe(todos => this.userTodosArray = todos);
}

}
