import classes from "./Books.module.scss";
import { Badge, Table } from "antd";
import type { ColumnsType } from "antd/es/table";
import { useState } from "react";
import { BookCopy } from "../../models/BookCopy";
import { Status } from "../../constants/enums";
import i18n from "../../i18n/i18n";

interface BookCopyTableProps {
  bookCopyData: BookCopy[];
}

const getBadgeColor = (status: Status) => {
  switch (status) {
    case Status.Available:
      return "green";
    case Status.onLoan:
      return "red";
    default:
      return "gray";
  }
};

const columns: ColumnsType<BookCopy> = [
  {
    title: i18n.t("column.id"),
    dataIndex: "id",
    key: "id",
  },
  {
    title: i18n.t("column.ISBN"),
    dataIndex: "ISBN",
    key: "ISBN",
  },
  {
    title: i18n.t("column.title"),
    dataIndex: "title",
    key: "title",
  },
  {
    title: i18n.t("column.author"),
    dataIndex: ["author", "firstName", "lastName"],
    render: (_, text) => (
      <div>
        {text.author.firstName} {text.author.lastName}
      </div>
    ),
    key: "author",
  },
  {
    title: i18n.t("column.status"),
    dataIndex: "status",
    render: (_, text) => {
      return (
        <Badge
          color={getBadgeColor(text.status)}
          text={i18n.t(`status.${text.status}`)}
        />
      );
    },
    key: "status",
  },
];

const BookCopyTable = ({ bookCopyData }: BookCopyTableProps) => {
  const [selectedRowKeys, setSelectedRowKeys] = useState<React.Key[]>([]);

  const onSelectChange = (newSelectedRowKeys: React.Key[]) => {
    console.log("selectedRowKeys changed: ", newSelectedRowKeys);
    setSelectedRowKeys(newSelectedRowKeys);
  };

  const rowSelection = {
    selectedRowKeys,
    onChange: onSelectChange,
  };

  return (
    <div className={classes.container}>
      <Table
        rowSelection={rowSelection}
        columns={columns}
        dataSource={bookCopyData}
        rowKey={(record) => record.id}
      />
    </div>
  );
};

export default BookCopyTable;
