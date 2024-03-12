import Fastify from 'fastify'
import {
  authenticationController
} from './controllers'

const app = Fastify({ logger: true })

app.register(authenticationController, { prefix: '/api/auth' })

export { app }

