import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Parking } from './parking';

@Injectable({
  providedIn: 'root'
})
export class ParkingService {
  private urlEndPoint: string = 'http://localhost:8080/api/parkings';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  getAllParkings(): Observable<Parking[]> {
    return this.http.get<Parking[]>(this.urlEndPoint);
  }

  getParkingById(id: number): Observable<Parking> {
    const url = `${this.urlEndPoint}/${id}`;
    return this.http.get<Parking>(url);
  }

  createParking(parking: Parking): Observable<Parking> {
    return this.http.post<Parking>(this.urlEndPoint, parking, { headers: this.httpHeaders });
  }

  
  updateParking(parking: Parking): Observable<Parking> {
    const url = `${this.urlEndPoint}/${parking.codigo}`;
    return this.http.put<Parking>(url, parking, { headers: this.httpHeaders });
  }

  deleteParking(id: number): Observable<void> {
    const url = `${this.urlEndPoint}/${id}`;
    return this.http.delete<void>(url);
  }
}
