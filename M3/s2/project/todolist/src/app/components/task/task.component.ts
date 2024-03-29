import { Component, Input } from '@angular/core';
import { iTodo } from '../../models/itodo';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrl: './task.component.scss',
})
export class TaskComponent {
  @Input() todo!: iTodo;
}
