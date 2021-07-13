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
url=jdbc:mysql://localhost:3306/test
driverClass=com.mysql.cj.jdbc.Driver
```