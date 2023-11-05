import { createBrowserRouter } from "react-router-dom";
import Books from "../screens/Books/Books";
import Layout from "./Layout/Layout";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout />,
    children: [
        {
            path: "/",
            element: <Books/>
        }
    ]
  },
]);