import { useEffect } from "react"
import { USER_KEY } from "@/utils/configs/sessionStorage.config"
import { ToastService } from "@/services/ToastService"
import { useNav } from "./useNav"
import { useSessionStorage } from "./useSessionStorage"
import { SessionStorageException } from "@/utils/exceptions/SessionStorageException"

export function useIsAuthenticatedUser() {
  const toastService = new ToastService()
  const { goTo } = useNav()
  const { findDataFromKey } = useSessionStorage()

  useEffect(() => {
    try {
      const user = findDataFromKey(USER_KEY)
      if (!user) {
        toastService.showError('Faça login novamente')
        goTo('/auth/login')
      }
    } catch(e) {
      if(e instanceof SessionStorageException) toastService.showError(e.message)
      else toastService.showError('Seu login expirou entre novamente')
      goTo('/auth/login')
    }
  }, [])

  return {}
}
