import { Flex } from "antd";
import BookCopyDataOptions from "../../components/BookCopy/BookCopyDataOptions";
import BookCopyTable from "../../components/BookCopy/BookCopyTable";

const Books = () => {
  return (
    <Flex vertical={true} gap={"large"}>
      <BookCopyDataOptions />
      <BookCopyTable />
    </Flex>
  );
};

export default Books;
