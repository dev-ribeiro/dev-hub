import notFoundImg from "@/assets/not_found.svg"
import { Link } from "react-router-dom";

export function NotFound() {

  return (
    <div className="min-h-screen w-full flex flex-col justify-center items-center gap-5 bg-sky-100">
      <img src={notFoundImg} alt="Imagem de 404" className="w-1/4" />
      <h1 className="font-bold text-xl md:text-3xl text-center">Página não encontrada</h1>
      <Link to='/auth/login' className="cursor-pointer">
      <span className="font-bold text-sm md:text-base text-sky-600">Voltar ao login</span>
      </Link>
    </div>
  );
}
