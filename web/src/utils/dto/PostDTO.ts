import { User } from "@/models";
import { Direction } from "@/utils/enums/direction";

export class PostDTO {
    id: string;
    user: User;
    title: string;
    description: string;
    createdAt: string;
    updatedAt: string;
    page: number;
    size: number;
    direction: Direction;
    by: string[];
}
