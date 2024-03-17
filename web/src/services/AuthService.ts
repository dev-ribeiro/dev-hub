import { api } from "@/lib/api";
import { User } from "@/models";
import { AxiosResponse } from "axios";

export class AuthService {
  constructor(private http = api) { }

  async login(user: User) {
    type Response = AxiosResponse<User>
    const response: Response = await this.http.post('/auth/login', user)
    return response.data
  }

  async register(user: User) {
    type Response = AxiosResponse<User>
    const response: Response = await this.http.post('/auth/register', user)
    return response.data
  }
}
