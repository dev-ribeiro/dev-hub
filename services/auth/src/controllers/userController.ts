import { FastifyInstance, FastifyRequest } from 'fastify';
import { UserTO } from '../to/UserTO';
import { UserService } from '../services';

export async function userController(app: FastifyInstance) {
  const userService = new UserService()

  app.post('/user/findbyid', async (
    request: FastifyRequest<{ Body: UserTO }>,
    reply
  ) => {
    try {

    } catch (error) {
      return reply.status(400).send()
    }
  })
}
