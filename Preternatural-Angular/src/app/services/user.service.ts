import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  apiUrl: string = "http://localhost:8085/users";

  public getAllUsers() {
    return this.httpClient.get<User[]>(`${this.apiUrl}/all`);
  };

  public getUserByUsername(username: string) {
    return this.httpClient.get<User[]>(`${this.apiUrl}/` + username);
  };

  public deleteUserByUsername(username: string) {
    return this.httpClient.post(`${this.apiUrl}/delete`, {
      Username: username
    });
  };

  public createUser(user: User) {
    return this.httpClient.post(`${this.apiUrl}/create`, user);
  };

  public updateUser(user: User) {
    return this.httpClient.put(`${this.apiUrl}/update`, user);
  };
}
