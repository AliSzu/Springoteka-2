import BookCopyTable from "../../components/BookCopy/BookCopyTable";
import { useGetBookCopiesQuery } from "../../service/bookCopies";

const Books = () => {
  // const { data } = useGetBookCopiesQuery();
  // console.log(data);
  return (
    <>
      <BookCopyTable />
    </>
  );
};

export default Books;
