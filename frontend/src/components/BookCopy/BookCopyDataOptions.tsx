import { Button, Flex, Input, Select, Typography } from "antd";
import Container from "../common/Container/Container";
import {
  SELECT_BOOK_FILTER_OPTIONS,
  SELECT_STATUS_OPTIONS,
} from "../../constants/forms";
import { useTranslation } from "react-i18next";
import { useState } from "react";

const BookCopyDataOptions = () => {
  const [value, setValue] = useState<string>("");
  const { t } = useTranslation();
  const filterOption = (
    input: string,
    option?: { label: string; value: string }
  ) => (option?.label ?? "").toLowerCase().includes(input.toLowerCase());

  const handleChange = (value: string) => {
    setValue(value);
  };

  return (
    <Container>
      <Flex gap="middle" vertical={true}>
        <Flex gap="middle" align="center">
          <Typography.Text strong>{t("search")} :</Typography.Text>
          <Select
            showSearch
            placeholder={t("placeholder.searchBy")}
            optionFilterProp="children"
            style={{ minWidth: "10rem" }}
            onChange={handleChange}
            filterOption={filterOption}
            options={SELECT_BOOK_FILTER_OPTIONS}
          />
          {value === "status" ? (
            <Select
              showSearch
              placeholder={t("placeholder.searchBy")}
              optionFilterProp="children"
              style={{ minWidth: "10rem" }}
              filterOption={filterOption}
              options={SELECT_STATUS_OPTIONS}
            />
          ) : (
            value && (
              <Input placeholder="Wpisz fraze" style={{ maxWidth: "10rem" }} />
            )
          )}
        </Flex>
        <Flex gap="middle" justify="space-between">
          <div>tutaj bedzie mozna wybrac date</div>
          <Flex gap="small" style={{minWidth: '12rem'}}>
            <Button block>Reset</Button>
            <Button type="primary" block>Szukaj</Button>
          </Flex>
        </Flex>
      </Flex>
    </Container>
  );
};

export default BookCopyDataOptions;
