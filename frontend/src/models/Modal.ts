import { Modal } from "../constants/enums";

export type ModalState = {
    [modal in Modal]: {isOpen: boolean} 
} & {id?: string}