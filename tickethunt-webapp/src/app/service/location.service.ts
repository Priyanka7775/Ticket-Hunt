import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LocationService {
  constructor(private http: HttpClient) {}

  getLocation(position: GeolocationCoordinates) {
    let latitude = position.longitude;
    let longitude = position.longitude;
    return this.http.get(
      'http://maps.googleapis.com/maps/api/geocode/json?latlng=' +
        latitude +
        ',' +
        longitude +
        '&sensor=true'
    );
  }
}
