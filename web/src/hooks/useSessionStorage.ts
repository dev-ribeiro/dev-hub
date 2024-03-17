import { SessionStorageException } from "@/utils/exceptions/SessionStorageException"

export function useSessionStorage() {
  const saveDataInStorage = <T>(key: string, payload: T) => {
    try {
      const convertedPayload = JSON.stringify(payload)
      window.sessionStorage.setItem(key, convertedPayload)
    } catch (e) {
      throw new SessionStorageException('Não foi possível salvar os dados no storage')
    }
  }

  const findDataFromKey = <T>(key: string) => {
    const data = window.sessionStorage.getItem(key)
    if(data) return JSON.parse(data) as T
    else throw new SessionStorageException('Não há dados armazenados no storage')
  }

  return {
    saveDataInStorage,
    findDataFromKey
  }
}
