import { User } from ".";

export class Post {
    id: string;
    user: User;
    title: string;
    description: string;
    createdAt: Date;
    updatedAt: Date;
}
