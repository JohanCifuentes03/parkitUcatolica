import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ParkingOwner } from './owner';

@Injectable({
  providedIn: 'root'
})
export class ParkingOwnerService {
  private urlEndPoint: string = 'http://localhost:8080/api/parkin-owners';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  getAllParkingOwners(): Observable<ParkingOwner[]> {
    return this.http.get<ParkingOwner[]>(this.urlEndPoint);
  }

  getParkingOwnerById(id: number): Observable<ParkingOwner> {
    const url = `${this.urlEndPoint}/${id}`;
    return this.http.get<ParkingOwner>(url);
  }

  createParkingOwner(parkingOwner: ParkingOwner): Observable<ParkingOwner> {
    return this.http.post<ParkingOwner>(this.urlEndPoint, parkingOwner, { headers: this.httpHeaders });
  }

  updateParkingOwner(parkingOwner: ParkingOwner): Observable<ParkingOwner> {
    const url = `${this.urlEndPoint}/${parkingOwner.codigo}`;
    return this.http.put<ParkingOwner>(url, parkingOwner, { headers: this.httpHeaders });
  }

  deleteParkingOwner(id: number): Observable<void> {
    const url = `${this.urlEndPoint}/${id}`;
    return this.http.delete<void>(url);
  }
}
