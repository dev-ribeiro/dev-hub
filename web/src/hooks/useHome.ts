import { Post, User } from "@/models"
import { PostService } from "@/services/PostService"
import { ToastService } from "@/services/ToastService"
import { PostDTO } from "@/utils/dto"
import { Direction } from "@/utils/enums/direction"
import { useEffect, useState } from "react"
import { useForm } from "react-hook-form"
import { useLoading } from "./useLoading"
import { useSessionStorage } from "./useSessionStorage"
import { USER_KEY } from "@/utils/configs/sessionStorage.config"

export function useHome() {
  const postService = new PostService()
  const toastService = new ToastService()
  const postForm = useForm<PostDTO>()
  const { isLoading, display } = useLoading()
  const { findDataFromKey } = useSessionStorage()
  const [posts, setPosts] = useState<Post[]>([])
  const [
    createModalVisibility,
    setCreateModalVisibility
  ] = useState(false)

  const submitData = (data: PostDTO, callback: () => void) => {
    async function sendData() {
      display(true)
      try {
        await new Promise((resolve) => setTimeout(() => resolve(null), 3000));
        const user = findDataFromKey<User>(USER_KEY)
        const post = await postService.createPost(data, user)
        setPosts(state => [post['response'], ...state])
        toastService.showSuccess('Criado com successo')
        callback()
      } catch (error) {
        toastService.showError('Não foi possível cadastrar o post')
      } finally {
        display(false)
      }
    }
    sendData()
  }

  useEffect(() => {
    try {
      async function fetchData() {
        const postTO = new PostDTO();
        postTO.size = 10;
        postTO.by = ['createdAt'];
        postTO.page = 1;
        postTO.direction = Direction.ASC;
        const response = await postService.findAll(postTO);
        setPosts(response['response'])
        toastService.showSuccess('Posts recuperados com sucesso')
      }
      fetchData()
    } catch (error) {
      toastService.showError('Não foi possível recuperar os posts')
    }
  }, [])

  return {
    posts,
    postForm,
    isLoading,
    submitData,
    createModalVisibility,
    setCreateModalVisibility
  }
}
