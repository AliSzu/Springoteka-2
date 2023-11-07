import { configureStore} from '@reduxjs/toolkit'
import { bookCopyApi } from '../service/bookCopies';
import { TypedUseSelectorHook, useDispatch, useSelector } from 'react-redux'


export const store = configureStore({
    reducer: {
        // Add the generated reducer as a specific top-level slice
        [bookCopyApi.reducerPath]: bookCopyApi.reducer,
    },
    // Adding the api middleware enables caching, invalidation, polling,
    // and other useful features of `rtk-query`.
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware().concat(bookCopyApi.middleware),
})

export type AppDispatch = typeof store.dispatch;
export const useAppDispatch: () => AppDispatch = useDispatch;
export const useAppSelector: TypedUseSelectorHook<RootState> = useSelector;
export type RootState = ReturnType<typeof store.getState>;
export default store;