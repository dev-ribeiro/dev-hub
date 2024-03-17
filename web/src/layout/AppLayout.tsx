import { useIsAuthenticatedUser } from "@/hooks/useIsAuthenticatedUser";
import { Outlet } from "react-router-dom";

export function AppLayout() {
  useIsAuthenticatedUser()

  return (
    <div className="min-h-screen bg-sky-100">
      <header className="py-5 px-2 bg-sky-600">
        <h2 className="text-2xl font-bold text-white">DEV HUB</h2>
      </header>
      <div className="px-2 pt-3 flex-1 flex">
        <aside className="flex-[1]"></aside>
        <div className="flex-[3]">
          <Outlet />
        </div>
        <aside className="flex-[1]"></aside>
      </div>
    </div>
  );
}
