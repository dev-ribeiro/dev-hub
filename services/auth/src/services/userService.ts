import { User } from "../models";
import { UserRepository } from "../repositories/userRepository";
import { UserTO } from "../to";

export class UserService {

  constructor(private userRepository: UserRepository = new UserRepository()) { }

  findUserById(userTO: UserTO) { }

  login(userTO: UserTO) {
    const user = this.userRepository.findByEmail(userTO.email);

    const passwordMatch = user.password === userTO.password;

    if(!passwordMatch) throw new Error()

    return user
  }

  registerUser(user: User) {
    this.userRepository.save(user)
  }

}
