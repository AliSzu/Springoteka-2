export type Query<T>  ={
    content: T[],
    pageable: Pageable
}

export interface Pageable {
    pageNumber: number,
    pageSize: number,
    totalElements: number
}

export interface QueryArgs {
    pageSize: number,
    pageNumber: number
}