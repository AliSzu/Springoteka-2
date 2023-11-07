import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react'
import { BookCopy } from '../models/BookCopy'

export const bookCopyApi = createApi({
    reducerPath: 'bookCopiesApi',
    baseQuery: fetchBaseQuery({ baseUrl: import.meta.env.VITE_BACKEND_URL }),
    endpoints: (builder) => ({
        getBookCopies: builder.query<BookCopy[], void>({
            query: () => `/bookCopies`,
        }),
    }),
})

export const {
    useGetBookCopiesQuery
} = bookCopyApi