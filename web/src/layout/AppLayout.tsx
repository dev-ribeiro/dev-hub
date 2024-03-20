import { useIsAuthenticatedUser } from "@/hooks/useIsAuthenticatedUser";
import { Outlet } from "react-router-dom";

export function AppLayout() {
  useIsAuthenticatedUser()

  return (
    <div className="min-h-screen flex flex-col items-center bg-sky-100">
      <header className="self-stretch py-5 px-2 bg-sky-600">
        <h2 className="text-2xl font-bold text-white">DEV HUB</h2>
      </header>
      <div className="m-3 flex flex-col items-start border-[1px] border-solid border-sky-800 rounded">
        <Outlet />
      </div>
    </div>
  );
}
