import { Badge, Space } from "antd";
import { useEffect, useState } from "react";
import { BookCopy } from "../../models/BookCopy";
import { Modal, Status } from "../../constants/enums";
import i18n from "../../i18n/i18n";
import type { TablePaginationConfig } from "antd/es/table";
import type { FilterValue } from "antd/es/table/interface";
import { useGetBookCopiesQuery } from "../../service/bookCopies";
import type { ProColumns } from '@ant-design/pro-components';
import Container from "../common/Container/Container";
import { ProTable } from '@ant-design/pro-components';
import { useTranslation } from "react-i18next";
import { useAppDispatch } from "../../store/store";
import { showModal } from "../../store/slices/modalSlice";


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

const columns: ProColumns<BookCopy>[] = [
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

  const {t} = useTranslation();
  const dispatch = useAppDispatch();

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

  const handleResetSelectedRows = () => setSelectedRowKeys([])

  const handleDelete = () => dispatch(showModal(Modal.deleteBookCopy))

  return (
    <Container>
      <ProTable<BookCopy>
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
        tableAlertOptionRender={() => {
          return (
            <Space size={16}>
              <a onClick={handleResetSelectedRows}>{t("option.cancel")}</a>
              <a onClick={handleDelete}>{t("option.delete")}</a>
            </Space>
          );
        }}
        tableAlertRender={(selectedItems) => t("alert.selectedItems", {number: selectedItems.selectedRowKeys.length})}
        scroll={{ x: 800 }}
        onChange={handleTableChange}
        search={false}
      />
    </Container>
  );
};

export default BookCopyTable;
