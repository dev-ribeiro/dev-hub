import { useToast } from "@/components/ui/use-toast";

export class ToastService {
  constructor(private toastController = useToast()) { }

  showSuccess(message: string) {
    this.toastController.toast({
      title: 'Sucesso',
      description: message,
      variant: 'success'
    })
  }

  showError(message: string) {
    this.toastController.toast({
      title: 'Erro',
      description: message,
      variant: 'destructive'
    })
  }
}
