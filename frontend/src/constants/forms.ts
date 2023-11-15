import i18n from "../i18n/i18n";
import { SelectOption } from "../models/Forms";
import { Status } from "./enums";

export const SELECT_BOOK_FILTER_OPTIONS: SelectOption[] = [
    {
        label: i18n.t("option.ISBN"),
        value: "isbn"
    },
    {
        label: i18n.t("option.title"),
        value: "title"
    },
    {
        label: i18n.t("option.author"),
        value: "author"
    },
    {
        label: i18n.t("option.status"),
        value: "status"
    },

]

export const SELECT_STATUS_OPTIONS: SelectOption[] = [
    {
        label: i18n.t("status.AVAILABLE"),
        value: Status.Available.toString()
    },
    {
        label: i18n.t("status.ON_LOAN"),
        value: Status.onLoan.toString()
    },
]

