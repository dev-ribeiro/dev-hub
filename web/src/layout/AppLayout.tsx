import { useIsAuthenticatedUser } from "@/hooks/useIsAuthenticatedUser";
import { Outlet } from "react-router-dom";

export function AppLayout() {
  useIsAuthenticatedUser()

  return (
    <div className="min-h-screen flex flex-col bg-sky-100">
      <header className="py-5 px-2 bg-sky-600">
        <h2 className="text-2xl font-bold text-white">DEV HUB</h2>
      </header>
      <div className="px-2 py-3 flex-1 flex gap-5">
        <aside className="flex-[1]"></aside>
        <div className="flex-[3] flex flex-col border-[1px] border-solid border-sky-800 rounded">
          <Outlet />
        </div>
        <aside className="flex-[1]"></aside>
      </div>
    </div>
  );
}
