import React from "react";
import ReactDOM from "react-dom/client";
import { RouterProvider } from "react-router-dom";
import { router } from "./router/router";
import "./index.css";
import { Provider } from "react-redux";
import store from "./store/store";
import enUS from 'antd/lib/locale/en_US';
import ConfigProvider from "antd/es/config-provider";
import { theme } from "./constants/theme";


ReactDOM.createRoot(document.getElementById("root")!).render(
  // <React.StrictMode>
    <ConfigProvider theme={{...theme}} locale={enUS}>
      <Provider store={store}>
        <RouterProvider router={router} />
      </Provider>
    </ConfigProvider>
  // </React.StrictMode>
);
