import BookCopyTable from "../../components/BookCopy/BookCopyTable";
import { useGetBookCopiesQuery } from "../../service/bookCopies";

const Books = () => {
  const { data } = useGetBookCopiesQuery();
  return (
  <>{data && <BookCopyTable bookCopyData={data} />}</>
  )
};

export default Books;
