import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  constructor(private authService: AuthenticationService, private router: Router) {}

  ngOnInit(): void {
    this.toggleTimeout();
    this.validateLogin();
  }

  isLoggedIn: boolean = true;
  role: string = '';

  toggle() {
    const menu = document.getElementById('event-menu');
    if (menu?.classList.contains('menu-active')) {
      menu?.classList.remove('menu-active');
      menu.classList.add('menu-inactive');
    } else {
      menu?.classList.remove('menu-inactive');
      menu?.classList.add('menu-active');
    }
  }

  toggleTimeout() {
    const menu = document.getElementById('event-menu');
    setInterval(() => {
      if (menu?.classList.contains('menu-active')) {
        menu?.classList.remove('menu-active');
        menu.classList.add('menu-inactive');
      }
    }, 5000);
  }

  validateLogin() {
    setInterval(() => {
      this.isLoggedIn = this.authService.isUserLogedIn;
    }, 500);
  }
  
  logout() {
    alert("Confirm to LogOut")
    this.authService.isUserLogedIn==false;
    sessionStorage.removeItem('jwtkey');
    sessionStorage.removeItem('userEmail');
    this.router.navigateByUrl("/login");
  }
}
