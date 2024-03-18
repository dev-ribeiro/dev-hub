import { PostDTO, ResponseDTO } from "@/utils/dto";
import { api } from "@/lib/api";
import { Post, User } from "@/models";
import { AxiosResponse } from "axios";

export class PostService {
  constructor(private http = api) { }

  async findAll(postTO: PostDTO) {
    type Response = AxiosResponse<ResponseDTO<Post[]>>
    const response: Response = await this.http.post('/post/findall', postTO)
    return response.data
  }

  async createPost(post: PostDTO, user: User) {
    const postDTO = Object.assign(new PostDTO(), post)
    postDTO.createdAt = new Date().toISOString()
    postDTO.updatedAt = new Date().toISOString()
    postDTO.user = Object.assign(new User(), user)
    type Response = AxiosResponse<ResponseDTO<Post>>
    const response: Response = await this.http.post('/post/create', postDTO)
    return response.data
  }
}
