import { Badge, Table } from "antd";
import { useEffect, useState } from "react";
import { BookCopy } from "../../models/BookCopy";
import { Status } from "../../constants/enums";
import i18n from "../../i18n/i18n";
import type { ColumnsType, TablePaginationConfig } from "antd/es/table";
import type { FilterValue, SorterResult } from "antd/es/table/interface";
import { useGetBookCopiesQuery } from "../../service/bookCopies";
import Container from "../common/Container/Container";

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

interface TableParams {
  pagination?: TablePaginationConfig;
  sortField?: string;
  sortOrder?: string;
  filters?: Record<string, FilterValue>;
}

const BookCopyTable = () => {
  const [selectedRowKeys, setSelectedRowKeys] = useState<React.Key[]>([]);
  const [tableParams, setTableParams] = useState<TableParams>({
    pagination: {
      current: 1,
      pageSize: 10,
    },
  });

  const { data, isFetching } = useGetBookCopiesQuery({
    pageSize: tableParams.pagination?.pageSize,
    pageNumber: tableParams.pagination?.current,
  });

  useEffect(() => {
    if (data) {
      setTableParams({
        pagination: {
          current: data.pageable.pageNumber,
          pageSize: data.pageable.pageSize,
          total: data.pageable.totalElements,
        },
      });
    }
  }, [data]);

  const onSelectChange = (newSelectedRowKeys: React.Key[]) => {
    console.log("selectedRowKeys changed: ", newSelectedRowKeys);
    setSelectedRowKeys(newSelectedRowKeys);
  };

  const rowSelection = {
    selectedRowKeys,
    onChange: onSelectChange,
  };

  const handleTableChange = (pagination: TablePaginationConfig) => {
    setTableParams({
      pagination,
    });
  };

  return (
    <Container>
      <Table
        rowSelection={rowSelection}
        columns={columns}
        dataSource={data && !isFetching ? data.content : []}
        loading={isFetching}
        rowKey={(record) => record.id}
        pagination={{
          ...tableParams.pagination,
          showSizeChanger: true,
          pageSizeOptions: ["5", "10", "15"],
        }}
        onChange={handleTableChange}
      />
    </Container>
  );
};

export default BookCopyTable;
