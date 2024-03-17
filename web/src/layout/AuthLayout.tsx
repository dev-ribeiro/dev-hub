import { Outlet } from "react-router-dom";

export function AuthLayout() {

  return (
    <div className="min-h-screen w-full p-2 flex items-center justify-center bg-sky-100">
      <Outlet />
    </div>
  );
}
