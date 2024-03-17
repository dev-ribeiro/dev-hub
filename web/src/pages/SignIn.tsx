import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { useSignIn } from "@/hooks/useSignIn";
import { Link } from "react-router-dom";
import { PulseLoader } from "react-spinners";

export function SignInPage() {
  const {
    signInForm,
    submitData,
    isLoading
  } = useSignIn()

  const { register, handleSubmit } = signInForm

  const submitButton = isLoading
    ? (<Button disabled>
      <PulseLoader color="#fff" size={8} />
    </Button>)
    : (<Button>
      <span>ENTRAR</span>
    </Button >)

  return (
    <main className="w-full md:w-1/2 p-3 rounded bg-white">
      <h1 className="text-center mb-5 text-sky-500 font-bold">DEV HUB</h1>
      <form onSubmit={handleSubmit(submitData)} className="flex flex-col gap-3">
        <Label htmlFor="email" className="text-xs">
          Informe seu e-mail:
        </Label>
        <Input type="email" {...register('email')} required />
        <Label htmlFor="password" className="text-xs">
          Informe a senha:
        </Label>
        <Input type="password" {...register('password')} required />
        {submitButton}
        <Link to="/auth/register" className="mt-3 text-center">
          <span className="text-xs text-sky-600">
            Não tem conta? Cadastre-se agora
          </span>
        </Link>
      </form>
    </main>
  );
}
