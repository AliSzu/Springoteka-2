import { Outlet } from "react-router-dom";
import { Layout as AntLayout } from "antd";
import Header from "../../components/common/Header/Header";
import { Content } from "antd/es/layout/layout";
import NavigationHeader from "../../components/common/NavigationHeader/NavigationHeader";

const Layout = () => {
  return (
    <AntLayout style={{height: '100%'}}>
      <Header />
      <NavigationHeader/>
      <Content style={{ height: '100%', padding: '16px' }}>
        <Outlet />
      </Content>
    </AntLayout>
  );
};

export default Layout;
