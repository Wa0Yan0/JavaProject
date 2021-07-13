package cn.wayan.one.test;

import cn.wayan.util.JDBCUtils;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Properties;

public class PersonTest {

    @Test
    public void test() {
        String sql = "select id,name,email from customers";
        List<customers> orders = JDBCUtils.getInstances(customers.class, sql);
        orders.forEach(System.out::println);
    }
}
