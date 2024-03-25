import { iPost } from "./post";

export interface iJsonContent {
    posts: iPost[]
    total: number
    skip: number
    limit: number
}
