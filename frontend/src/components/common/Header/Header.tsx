import { Header as AntHeader } from "antd/es/layout/layout"
import classes from "./Header.module.scss"
import { Flex } from "antd"

const Header = () => {
    return (
        <AntHeader className={classes.header}>
            <Flex gap="small">
                <div>1</div>
                <div>2</div>
            </Flex>
        </AntHeader>
    )
}

export default Header