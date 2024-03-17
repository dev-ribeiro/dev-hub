import { User } from "@/models"
import { useForm } from "react-hook-form"

export function useSignIn() {
  const signInForm = useForm<User>()

  const submitData = (data: User) => {
    console.log(data)
  }

  return {
    signInForm,
    submitData
  }
}
