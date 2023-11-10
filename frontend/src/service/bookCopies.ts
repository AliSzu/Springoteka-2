import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react'
import { BookCopy } from '../models/BookCopy'
import { Query, QueryArgs } from '../models/Query'
import { ApiPaths } from '../constants/paths'

export const bookCopyApi = createApi({
    reducerPath: 'bookCopiesApi',
    baseQuery: fetchBaseQuery({ baseUrl: import.meta.env.VITE_BACKEND_URL }),
    endpoints: (builder) => ({
        getBookCopies: builder.query<Query<BookCopy>, Partial<QueryArgs>>({
            query: (args) => ({
                url: `${ApiPaths.BookCopies}`,
                params: {
                    pageSize: args.pageSize,
                    pageNumber: args.pageNumber
                }
            }),
        }),
    }),
})

export const {
    useGetBookCopiesQuery
} = bookCopyApi