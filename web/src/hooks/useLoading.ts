import { useState } from "react"

export function useLoading() {
  const [isLoading, setIsLoading] = useState(false)

  const display = (payload: boolean) => setIsLoading(payload)

  return {
    isLoading,
    display
  }
}
