import { User } from "@/models"
import { AuthService } from "@/services/AuthService"
import { ToastService } from "@/services/ToastService"
import { useForm } from "react-hook-form"
import { useLoading } from "./useLoading"
import { useSessionStorage } from "./useSessionStorage"
import { USER_KEY } from "@/utils/configs/sessionStorage.config"
import { SessionStorageException } from "@/utils/exceptions/SessionStorageException"
import { useNav } from "./useNav"

export function useSignUp() {
  const authService = new AuthService()
  const toastService = new ToastService()
  const signUpForm = useForm<User>()
  const { isLoading, display } = useLoading()
  const { saveDataInStorage } = useSessionStorage()
  const { goTo } = useNav()

  const submitData = (data: User) => {
    display(true);
    (async function () {
      try {
        await new Promise(resolve => setTimeout(() => resolve(null), 5000));
        const user = await authService.register(data);
        saveDataInStorage<User>(USER_KEY, user);
        toastService.showSuccess('Cadastro feito com sucesso');
        display(false);
        goTo("/app/home");
      } catch (e) {
        display(false);
        if (e instanceof SessionStorageException) toastService.showError(e.message);
        else toastService.showError('Não foi possível realizar o cadastro');
      }
    })();
  }

  return {
    signUpForm,
    isLoading,
    submitData
  }
}
