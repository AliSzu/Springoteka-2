import { ThemeConfig } from "antd";

export const theme: ThemeConfig = Object.freeze({
    token: {
      colorPrimary: "#759B9B",
      borderRadius: 4
    },
    components: {
      Layout: {
        bodyBg: "none",
        headerBg: "#759B9B"
      },
      Menu: {
        activeBarHeight: 0,
        activeBarBorderWidth: 0
      }
    }
  });
