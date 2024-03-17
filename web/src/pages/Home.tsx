import { useHome } from "@/hooks/useHome";

export function HomePage() {
  const {} = useHome()

  return (
    <main>
      <span>HOME</span>
    </main>
  );
}
