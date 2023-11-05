import classes from "./Books.module.scss";
import { Table } from "antd";
import type { ColumnsType } from "antd/es/table";
import { useState } from "react";

interface DataType {
  key: React.Key;
  ISBN: number;
  title: string;
  author: string;
  status: string;
}

const columns: ColumnsType<DataType> = [
  {
    title: "Id",
    dataIndex: "key",
  },
  {
    title: "ISBN",
    dataIndex: "ISBN",
  },
  {
    title: "Title",
    dataIndex: "title",
  },
  {
    title: "Author",
    dataIndex: "author",
  },
  {
    title: "Status",
    dataIndex: "status",
  },
];

const data: DataType[] = [
  {
    key: '1',
    ISBN: 123132131,
    title: "Dziady",
    author: "Adam Mickiewicz",
    status: "Dostępna",
  },
  {
    key: '2',
    ISBN: 1234241,
    title: "Dziady",
    author: "Adam Mickiewicz",
    status: "Wypożyczona",
  },
];

const BookTable = () => {
  const [selectedRowKeys, setSelectedRowKeys] = useState<React.Key[]>([]);

  const onSelectChange = (newSelectedRowKeys: React.Key[]) => {
    console.log('selectedRowKeys changed: ', newSelectedRowKeys);
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
        dataSource={data}
      />
    </div>
  );
};

export default BookTable;
