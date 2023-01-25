import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import { LocationService } from '../service/location.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  constructor(
    private authService: AuthenticationService,
    private router: Router,
    private locationService: LocationService
  ) { }

  ngOnInit(): void {
    this.toggleTimeout();
    this.validateLogin();
    this.getLocation();
    // this.role = sessionStorage.getItem('role');
    // console.log(this.authService.isUserLogedIn)
  }

  isLoggedIn: boolean = false;
  // role: any = sessionStorage.getItem('role');
  city: string = '';
  // Cities
  cities: string[] = [
    'Mumbai',
    'Pune',
    'Delhi',
    'Banglore',
    'Agra',
    'Noida',
    'Dehradun',
    'Chennie',
  ];
  citiesFilter: string[] = [];
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
      let email = sessionStorage.getItem('emailId')
      if (this.authService.isUserLogedIn) {
        this.isLoggedIn = this.authService.isUserLogedIn;
      } else if (email != null) {
        this.isLoggedIn = true;
      } else {
        this.isLoggedIn = false;
      }    
    }, 1000);
  }

  logout() {
    alert('Confirm to LogOut');
    this.authService.isUserLogedIn = false;
    sessionStorage.removeItem('jwtkey');
    sessionStorage.removeItem('userEmail');
    sessionStorage.clear();
    this.router.navigateByUrl('/login');
  }

  getLocation() {
    navigator.geolocation.getCurrentPosition(
      (position: GeolocationPosition) => {
        this.locationService.getLocation(position).subscribe((city: any) => {
          this.city = city.results[0].components.state_district;
        });
      }
    );
  }

  getCity() {
    const value = (document.getElementById('city') as HTMLInputElement).value;
    this.citiesFilter = this.cities.filter((x) =>
      x.toLocaleLowerCase().startsWith(value.toLocaleLowerCase().toString())
    );
  }
}
