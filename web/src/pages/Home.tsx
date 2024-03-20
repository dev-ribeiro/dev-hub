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
    <div className="flex-1 flex justify-center items-center">
      <h2 className="text-2xl font-bold">NÃO HÁ POSTS</h2>
    </div>
  );

  const gridPost = (
    <section className="flex-1 flex flex-col">
      <div className="pb-5">
        <h2 className="font-bold text-xl">Seu feed</h2>
      </div>
      <div className="space-y-5">
        {posts.map(post => {
          const createdAtFormated = new Date(post.createdAt)
            .toLocaleDateString('pt-BR', { hour: '2-digit', minute: '2-digit' })

          return (
            <div key={post.id}
              className="flex-1 pb-2 flex gap-2 border-b-[1px] border-solid border-sky-500">
              <div className="w-10 h-10">
                <Avatar>
                  <AvatarImage src="https://github.com/shadcn.png" />
                  <AvatarFallback>CN</AvatarFallback>
                </Avatar>
              </div>
              <div className="w-[90%]">
                <h3 className="font-bold text-justify">{post.title}</h3>
                <span className="max-w-full inline-block break-words">{post.description}</span>
                <p className="text-end">
                  Postado por <strong>{post.user.firstName}</strong>, em {createdAtFormated}
                </p>
              </div>
            </div>
          )
        })}
      </div>
    </section>
  );

  const dialogPost = (
    <div className="absolute bottom-[3vh] left-[3vw]">
      <Dialog open={createModalVisibility} onOpenChange={() => setCreateModalVisibility(!createModalVisibility)}>
        <DialogTrigger onClick={() => setCreateModalVisibility(true)}>
          <button className="p-3 fixed bottom-[2vh] left-[1vw] bg-sky-600 rounded">
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
    <main className="p-3 max-w-[300px] md:max-w-screen-md">
      {posts.length === 0 && emptyList}
      {posts.length > 0 && gridPost}
      {dialogPost}
    </main>
  );
}
