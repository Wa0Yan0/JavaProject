package cn.wayan.one.test;

import cn.wayan.util.JDBCUtils;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class PersonTest {

    @Test
    public void test() {
        String sql = "select id,name,email,birth from customers where id = ?";
        customers cus = JDBCUtils.queryForCustomer(sql, 19);
        System.out.println(cus);
    }
}
