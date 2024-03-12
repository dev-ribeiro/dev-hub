import { User } from "../models";

const data: User[] = []

export class UserRepository {
  save(payload: User) {
    data.push(payload)
  }

  findById(id: string) { }

  findByEmail(email: string) {
    const user = data.find(u => u.email === email)

    if (!user) throw new Error()

    return user
  }
}
