import { Outlet } from "react-router-dom";
import { Layout as AntLayout } from "antd";
import Header from "../../components/common/Header/Header";
import { Content } from "antd/es/layout/layout";
import NavigationHeader from "../../components/common/NavigationHeader/NavigationHeader";
import classes from "./Layout.module.scss"

const Layout = () => {
  return (
    <AntLayout className={classes.layout}>
      <Header />
      <NavigationHeader/>
      <Content style={{ height: '100%', padding: '16px', width: "100%", maxWidth: '100rem', margin: "auto" }}>
        <Outlet />
      </Content>
    </AntLayout>
  );
};

export default Layout;
