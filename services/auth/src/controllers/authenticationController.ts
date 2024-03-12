import { randomUUID } from 'node:crypto'
import { FastifyInstance, FastifyRequest, RouteGenericInterface } from 'fastify'
import { User } from '../models'
import { UserService } from '../services'
import { UserTO } from '../to'

export async function authenticationController(app: FastifyInstance) {

  app.post('/register', (
    request: FastifyRequest<{ Body: User }>,
    reply
  ) => {
    try {
      const userService = new UserService()

      const user = new User()

      user.id = randomUUID()

      Object.assign(user, request.body)

      userService.registerUser(user)

      return reply.status(200).send(user)
    } catch (error) {
      console.error(error)

      return reply.status(400).send()
    }
  })

  app.post('/login', async (
    request: FastifyRequest<{ Body: UserTO }>,
    reply
  ) => {
    try {
      console.log(request.body)

      const userService = new UserService()

      const authenticated = userService.login(request.body)

      return reply.status(200).send(authenticated)

    } catch (error) {
      console.error(error)

      return reply.status(400).send()
    }
  })
}
