import { BrowserRouter, Route, Routes } from "react-router-dom";
import { AuthLayout, AppLayout } from "@/layout";
import { HomePage, NotFound, SignInPage, SignUpPage } from "@/pages";

export function Router() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/app" element={<AppLayout />}>
          <Route path="/app/home" element={<HomePage />} />
        </Route>
        <Route path="/auth" element={<AuthLayout />}>
          <Route path="/auth/login" element={<SignInPage />} />
          <Route path="/auth/register" element={<SignUpPage />} />
        </Route>
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  );
}
