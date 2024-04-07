import { Component } from '@angular/core';
import { ProfileService } from './profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.scss',
})
export class ProfileComponent {
  constructor(private profileSvc: ProfileService) {}

  firstName: string = '';
  lastName: string = '';
  email: string = '';
  favorites: number[] = [];

  ngOnInit() {
    this.profileSvc.$user.subscribe((user) => {
      this.firstName = user.firstName;
      this.lastName = user.lastName;
      this.email = user.email;
    });
  }
  ngOnDestroy() {
    this.firstName = '';
    this.lastName = '';
    this.email = '';
    this.favorites = [];
  }
}
