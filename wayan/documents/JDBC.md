### 样例
```java
package cn.wayan.one.test;

import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class PersonTest {

    @Test
    public void test() {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
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
            conn = DriverManager.getConnection(url,user,password);
            System.out.println(conn);

            /**
             * 预编译sql语句
             */
            String sql = "insert into customers(name,email,birth) values(?,?,?)";
            ps = conn.prepareStatement(sql);

            /**
             * 填充数据
             */
            ps.setString(1,"王岩");
            ps.setString(2,"wayan@gmail.com");
            // 日期转化
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("1999-10-28");
            ps.setDate(3,new java.sql.Date(date.getTime()));

            /**
             * 执行
             */
            ps.execute();
            System.out.println("插入成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            /**
             * 释放资源
             */
            try {
                if(ps!=null)
                    ps.close();
                if(conn!=null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
```

### IDEA连接MySQL

- 自定义类
```java
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
Connection conn = DriverManager.getConnection(url,user,password);
System.out.println(conn);
```

- 配置文件:MySQL.properties
```java
user=root
password=102866
url=jdbc:mysql://localhost:3306/test?characterEncoding=utf8
driverClass=com.mysql.cj.jdbc.Driver
```

### 插入操作
- 预编译sql语句
```java

String sql = "insert into customers(name,email,birth) values(?,?,?)";
PreparedStatement ps = conn.prepareStatement(sql);
```
-  填充数据
```java
ps.setString(1,"王岩");
ps.setString(2,"wayan@gmail.com");
// 日期转化
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Date date = sdf.parse("1999-10-28");
ps.setDate(3,new java.sql.Date(date.getTime()));
```
- 执行
```java
ps.execute();
```

