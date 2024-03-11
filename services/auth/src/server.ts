import { app } from "./app"
import { environment } from './environment'

const { PORT } = environment

app.listen({
  host: '0.0.0.0',
  port: PORT
})
