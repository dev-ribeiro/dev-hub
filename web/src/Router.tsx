import { BrowserRouter, Route, Routes } from "react-router-dom";
import { AuthLayout, AppLayout } from "@/layout";
import { NotFound, SignInPage, SignUpPage } from "@/pages";

export function Router() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/app" element={<AppLayout />}></Route>
        <Route path="/auth" element={<AuthLayout />}>
          <Route path="/auth/login" element={<SignInPage />} />
          <Route path="/auth/register" element={<SignUpPage />} />
        </Route>
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  );
}
