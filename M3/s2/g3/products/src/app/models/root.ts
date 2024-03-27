import { iProduct } from "./product"

export interface iRoot {
  products: iProduct[]
  total: number
  skip: number
  limit: number
}
