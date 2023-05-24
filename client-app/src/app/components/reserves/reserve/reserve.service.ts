import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reserve } from './reserve';

@Injectable({
  providedIn: 'root'
})
export class ReserveService {
  private urlEndPoint: string = 'http://localhost:8080/api/reserves';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  getAllReservas(): Observable<Reserve[]> {
    return this.http.get<Reserve[]>(this.urlEndPoint);
  }

  getReservaById(codigo: number): Observable<Reserve> {
    const url = `${this.urlEndPoint}/${codigo}`;
    return this.http.get<Reserve>(url);
  }

  createReserva(reserve: Reserve): Observable<Reserve> {
    return this.http.post<Reserve>(this.urlEndPoint, reserve, { headers: this.httpHeaders });
  }

  updateReserva(reserve: Reserve): Observable<Reserve> {
    const url = `${this.urlEndPoint}/${reserve.codigo}`;
    return this.http.put<Reserve>(url, reserve, { headers: this.httpHeaders });
  }

  deleteReserva(codigo: number): Observable<void> {
    const url = `${this.urlEndPoint}/${codigo}`;
    return this.http.delete<void>(url);
  }
}
