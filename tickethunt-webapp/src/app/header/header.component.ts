import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  constructor() { }

  ngOnInit(): void {
    this.toggleTimeout();
  }
  
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

}