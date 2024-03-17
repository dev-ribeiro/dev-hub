import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { useSignIn } from "@/hooks/useSignIn";

export function SignInPage() {
  const {
    signInForm,
    submitData
  } = useSignIn()

  const { register, handleSubmit } = signInForm

  return (
    <main className="md:w-1/4 p-3 rounded bg-white">
      <form onSubmit={handleSubmit(submitData)} className="flex flex-col gap-3">
        <Label htmlFor="email">Informe seu e-mail:</Label>
        <Input type="email" {...register('email')} />
        <Label htmlFor="password">Informe a senha:</Label>
        <Input type="password" {...register('password')} />
        <Button className="bg-sky-400">
          <span>ENTRAR</span>
        </Button>
      </form>
    </main>
  );
}
