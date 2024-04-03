import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss',
})
export class RegisterComponent {
  form!: FormGroup;
  generi: string[] = ['uomo', 'donna', 'altro'];

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.form = this.fb.group({
      nome: this.fb.control(null, [Validators.required]),
      cognome: this.fb.control(null, [Validators.required]),
      authData: this.fb.group({
        password: this.fb.control(null, [Validators.required]),
        confirm_password: this.fb.control(null, [Validators.required]),
        username: this.fb.control(null, [Validators.required]),
      }),
      genere: this.fb.control(null, [Validators.required]),
      biografia: this.fb.control(null, [Validators.required])
    });
  }

  isValid(fieldName:string):boolean{
    const field = this.form.get(fieldName)

    if(!field) return false

    return field.valid
  }

  mostraDati(){
    console.log(this.form.value);
  }

}
