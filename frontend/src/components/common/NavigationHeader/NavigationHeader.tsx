import { Menu } from "antd";
import type { MenuProps } from 'antd';
import { Header } from "antd/es/layout/layout";
import { useState } from "react";
import i18n from "../../../i18n/i18n";
import { UserOutlined } from "@ant-design/icons";
import {HiOutlineBookOpen, HiOutlineBuildingLibrary, HiOutlinePencil} from "react-icons/hi2" 



const items: MenuProps['items'] = [
  {
    label: i18n.t("menu.books"),
    key: 'books',
    icon: <HiOutlineBookOpen />
  },
  {
    label: i18n.t("menu.authors"),
    key: 'authors',
    icon: <HiOutlinePencil />
  },
  {
    label: i18n.t("menu.libraries"),
    key: 'libraries',
    icon: <HiOutlineBuildingLibrary />
  },
  {
    label: i18n.t("menu.users"),
    key: 'users',
    icon: <UserOutlined />
  },
];

const NavigationHeader = () => {
  const [current, setCurrent] = useState('mail');

  const onClick: MenuProps['onClick'] = (e) => {
    console.log('click ', e);
    setCurrent(e.key);
  };
  
  return (
    <Header style={{backgroundColor: 'white'}}>
      <Menu onClick={onClick} selectedKeys={[current]} mode="horizontal" items={items} />
    </Header>
  );
};

export default NavigationHeader;
