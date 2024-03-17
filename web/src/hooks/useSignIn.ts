import { User } from "@/models"
import { useForm } from "react-hook-form"
import { USER_KEY } from "@/utils/configs/sessionStorage.config"
import { SessionStorageException } from "@/utils/exceptions/SessionStorageException"
import { AuthService } from "@/services/AuthService"
import { ToastService } from "@/services/ToastService"
import { useNav } from "./useNav"
import { useSessionStorage } from "./useSessionStorage"
import { useLoading } from "./useLoading"

export function useSignIn() {
  const authService = new AuthService()
  const toastService = new ToastService()
  const signInForm = useForm<User>()
  const { isLoading, display } = useLoading()
  const { saveDataInStorage } = useSessionStorage()
  const { goTo } = useNav()

  const submitData = (data: User) => {
    display(true);
    (async function () {
      try {
        const user = await authService.login(data);
        saveDataInStorage<User>(USER_KEY, user);
        toastService.showSuccess('Login feito com sucesso');
        display(false);
        goTo("/app/home");
      } catch (e) {
        display(false);
        if (e instanceof SessionStorageException) toastService.showError(e.message);
        else toastService.showError('Não foi possível realizar o login');
      }
    })();
  }

  return {
    signInForm,
    submitData,
    isLoading
  }
}
