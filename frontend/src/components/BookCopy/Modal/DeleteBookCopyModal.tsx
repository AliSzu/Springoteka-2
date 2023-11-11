import { Modal } from "../../../constants/enums";
import { hideModal, selectModalState } from "../../../store/slices/modalSlice";
import { useAppDispatch, useAppSelector } from "../../../store/store";
import { Modal as AntModal, Button } from "antd";

const DeleteBookCopyModal = () => {
  const isOpen = useAppSelector(selectModalState(Modal.deleteBookCopy));
  const dispatch = useAppDispatch();

  const handleClose = () => dispatch(hideModal(Modal.deleteBookCopy))

  return (
    <AntModal
      title="Basic Modal"
      open={isOpen}
      onCancel={handleClose}
      footer={[<Button key="back">Return</Button>]}
    >
      <p>Some contents...</p>
      <p>Some contents...</p>
      <p>Some contents...</p>
    </AntModal>
  );
};

export default DeleteBookCopyModal;
