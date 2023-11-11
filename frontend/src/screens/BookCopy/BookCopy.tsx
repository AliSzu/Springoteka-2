import { Flex } from "antd";
import BookCopyDataOptions from "../../components/BookCopy/BookCopyDataOptions";
import BookCopyTable from "../../components/BookCopy/BookCopyTable";
import DeleteBookCopyModal from "../../components/BookCopy/Modal/DeleteBookCopyModal";

const Books = () => {
  return (
    <>
      <DeleteBookCopyModal />
      <Flex vertical={true} gap={"large"}>
        <BookCopyDataOptions />
        <BookCopyTable />
      </Flex>
    </>
  );
};

export default Books;
