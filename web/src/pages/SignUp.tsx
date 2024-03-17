import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { useSignUp } from "@/hooks/useSignUp";
import { Link } from "react-router-dom";

export function SignUpPage() {
  const { signUpForm, submitData } = useSignUp()
  const { register, handleSubmit } = signUpForm

  return (
    <main className="w-full md:w-1/2 p-3 rounded bg-white">
      <h1 className="text-center mb-5 text-sky-500 font-bold">DEV HUB</h1>
      <form onSubmit={handleSubmit(submitData)} className="flex flex-col gap-3">
        <Label htmlFor="firstName" className="text-xs">
          Primeiro nome:
        </Label>
        <Input type="text" {...register('firstName')} required />

        <Label htmlFor="lastName" className="text-xs">
          Sobrenome:
        </Label>
        <Input type="text" {...register('lastName')} required />

        <Label htmlFor="email" className="text-xs">
          Informe seu e-mail:
        </Label>
        <Input type="email" {...register('email')} required />

        <Label htmlFor="cellPhone" className="text-xs">
          Celular:
        </Label>
        <Input type="tel" {...register('cellPhone')} />

        <Label htmlFor="password" className="text-xs">
          Informe a senha:
        </Label>
        <Input type="password" {...register('password')} required />

        <Button type="submit">
          <span>CADASTRAR</span>
        </Button>

        <Link to="/auth/login" className="mt-3 text-center">
          <span className="text-xs text-sky-600">
            Já tem conta? Faça login.
          </span>
        </Link>
      </form>
    </main>
  );
}
