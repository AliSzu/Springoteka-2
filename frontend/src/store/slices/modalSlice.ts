import { createSelector, createSlice, PayloadAction } from "@reduxjs/toolkit";
import { ModalState } from "../../models/Modal";
import { Modal } from "../../constants/enums";
import { RootState } from "../store";

const initialState: ModalState = {
    [Modal.deleteBookCopy]: {
        isOpen: true
    },
    id: "",
}

export const modalSlice = createSlice({
    name: 'modalSlice',
    initialState,
    reducers: {
        showModal: (state, action: PayloadAction<Modal>) => {
            state[action.payload].isOpen = true
        },
        hideModal: (state, action: PayloadAction<Modal>) => {
            state[action.payload].isOpen = false
        }
    }
})

export const { showModal, hideModal } = modalSlice.actions;

export const selectModalState = (modalType: Modal) => createSelector(
    [(state: RootState) => state.modal],
    (dialog) => dialog[modalType].isOpen
)