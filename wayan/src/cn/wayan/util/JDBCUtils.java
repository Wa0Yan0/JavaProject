package cn.wayan.util;

import java.beans.Statement;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    /**
     * 获取数据库连接
     *
     * @return Connection conn
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        /**
         * 读取配置文件中的数据
         */
        // 使用类构造器将配置文件变成字符流
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("MySQL.properties");
        // 创建properties集合存储字符流，含有key和value
        Properties pros = new Properties();
        // 将字符流加载到集合中
        pros.load(is);
        // 通过key来获取value
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        /**
         * 连接数据库
         */
        // 加载驱动
        Class.forName(driverClass);
        // 获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * 释放资源
     * @param conn
     * @param ps
     */
    public static void closeResource(Connection conn, PreparedStatement ps) {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
