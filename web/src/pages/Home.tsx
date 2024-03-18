import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";
import { Button } from "@/components/ui/button";
import { Dialog, DialogContent, DialogHeader, DialogTitle, DialogTrigger } from "@/components/ui/dialog";
import { Input } from "@/components/ui/input";
import { Textarea } from "@/components/ui/textarea";
import { useHome } from "@/hooks/useHome";
import { Label } from "@radix-ui/react-label";
import { PulseLoader } from "react-spinners";

export function HomePage() {
  const {
    posts,
    postForm,
    createModalVisibility,
    isLoading,
    setCreateModalVisibility,
    submitData
  } = useHome()
  const { handleSubmit, register } = postForm

  const emptyList = (
    <h2 className="text-2xl font-bold">NÃO HÁ POSTS</h2>
  );

  const gridPost = (
    <section className="w-full flex flex-col">
      <div className="w-full py-5">
        <h2 className="font-bold text-xl">Seu feed</h2>
      </div>
      <div className="max-w-full space-y-2 bg-red-50">
        {posts.map(post => (
          <div key={post.id} className="w-full flex gap-2 border-b-[1px] border-solid border-sky-500">
            <div>
              <Avatar>
                <AvatarImage src="https://github.com/shadcn.png" />
                <AvatarFallback>CN</AvatarFallback>
              </Avatar>
            </div>
            <div className="flex flex-col text-wrap">
              <h3 className="font-bold text-justify">{post.title}</h3>
              <div>{post.description}</div>
            </div>
          </div>
        ))}
      </div>
    </section>
  );

  const dialogPost = (
    <div className="absolute bottom-[3vh] left-[3vw]">
      <Dialog open={createModalVisibility} onOpenChange={() => setCreateModalVisibility(!createModalVisibility)}>
        <DialogTrigger onClick={() => setCreateModalVisibility(true)}>
          <button className="p-3 bg-sky-600 rounded">
            <span className="text-white font-bold">CRIAR POST</span>
          </button>
        </DialogTrigger>
        <DialogContent>
          <DialogHeader>
            <DialogTitle>Informações do Post</DialogTitle>
          </DialogHeader>
          <div>
            <form className="flex flex-col gap-2"
              onSubmit={handleSubmit(data => submitData(data, () => setCreateModalVisibility(false)))}
            >
              <Label className="text-sm">Título do post</Label>
              <Input type="text" {...register('title')} />
              <Label className="text-sm">Conteúdo do post</Label>
              <Textarea maxLength={500} placeholder="Até 500 caracteres"
                className="min-h-[200px]" {...register('description')} />
              <Button type="submit" disabled={isLoading}>
                {!isLoading && <span>CRIAR POST</span>}
                {isLoading && <PulseLoader color="#fff" size={8} />}
              </Button>
            </form>
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );

  return (
    <>
      <main className="p-2 flex-1 flex">
        {posts.length === 0 && emptyList}
        {posts.length > 0 && gridPost}
      </main>
      {dialogPost}
    </>
  );
}
