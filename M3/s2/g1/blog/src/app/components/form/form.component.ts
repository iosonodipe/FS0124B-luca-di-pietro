import {
  Component,
  ElementRef,
  EventEmitter,
  Output,
  ViewChild,
  viewChild,
} from '@angular/core';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrl: './form.component.scss',
})
export class FormComponent {
  @Output() postEdit = new EventEmitter<string>();
  @ViewChild('post_title')
  postTitle!: ElementRef;
  @ViewChild('post_text')
  postText!: ElementRef;

  sendData(): void {
    this.postEdit.emit(this.postTitle.nativeElement.value)
    this.postEdit.emit(this.postText.nativeElement.value)
  }
}
