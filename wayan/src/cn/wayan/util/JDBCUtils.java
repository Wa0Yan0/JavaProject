package cn.wayan.util;

import cn.wayan.one.test.Order;
import cn.wayan.one.test.customers;
import com.mysql.cj.protocol.Resultset;

import java.beans.Statement;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
     * 二参数释放资源
     *
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

    /**
     * 三参数释放资源
     *
     * @param conn
     * @param ps
     * @param rs
     */
    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs) {
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
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 通用增删改
     *
     * @param sql  -sql语句
     * @param args - 可变长度的待填充数据
     */
    public static void modifySql(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 连接数据库
            conn = getConnection();
            // 预编译sql语句
            ps = conn.prepareStatement(sql);
            // 填充数据
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 执行
            ps.execute();
            System.out.println("数据库跟新成功！！！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            closeResource(conn, ps);
        }
    }

    /**
     * @function 通用查询，返回表中一条记录
     * @Description 利用反射构建一个空参类对象，通过获取到的列名和属性值，组成一个带参的类对象，返回
     * @param tClass -类名.class
     * @param sql    -sql语句
     * @param args   -可变长度的待填充数据
     * @param <T>
     * @return T 泛型的类对象
     */
    public static <T> T getInstance(Class<T> tClass, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            // 填充数据
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 查询后得到结果集
            rs = ps.executeQuery();
            // 获取结果集的元数据
            ResultSetMetaData metaData = rs.getMetaData();
            // 通过元数据获取结果集的列数
            int columnCount = metaData.getColumnCount();
            if (rs.next()) {
                // 通过反射构造一个类的空参类对象，通过存在的列名，设置属性值
                T t = tClass.getDeclaredConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {
                    // 获取属性值
                    Object value = rs.getObject(i + 1);
                    // 获取列名或别名
                    String columnClassName = metaData.getColumnLabel(i + 1);
                    // 通过反射，将列名变成对象
                    Field field = tClass.getDeclaredField(columnClassName);
                    // 私有属性，设置访问权限
                    field.setAccessible(true);
                    // 设置属性值
                    field.set(t, value);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResource(conn, ps, rs);
        }
        return null;
    }

    /**
     * @function 通用查询，返回表中多条记录
     * @Description 循环利用反射构建空参类对象，通过获取到的列名和属性值，组成带参的类对象，添加到集合中。循环结束，返回集合。
     * @param tClass -类名.class
     * @param sql    -sql语句
     * @param args   -可变长度的待填充数据
     * @param <T>
     * @return T 泛型的集合
     */
    public static <T> List<T> getInstances(Class<T> tClass, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            // 填充数据
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 查询后得到结果集
            rs = ps.executeQuery();
            // 获取结果集的元数据
            ResultSetMetaData metaData = rs.getMetaData();
            // 通过元数据获取结果集的列数
            int columnCount = metaData.getColumnCount();
            ArrayList<T> list = new ArrayList<>();
            while (rs.next()) {
                // 通过反射构造一个类的空参类对象，通过存在的列名，设置属性值
                T t = tClass.getDeclaredConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {
                    // 获取属性值
                    Object value = rs.getObject(i + 1);
                    // 获取列名或别名
                    String columnClassName = metaData.getColumnLabel(i + 1);
                    // 通过反射，将列名变成对象
                    Field field = tClass.getDeclaredField(columnClassName);
                    // 私有属性，设置访问权限
                    field.setAccessible(true);
                    // 设置属性值
                    field.set(t, value);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResource(conn, ps, rs);
        }
        return null;
    }



}
