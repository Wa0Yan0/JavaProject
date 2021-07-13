package cn.wayan.one.test;

import cn.wayan.util.JDBCUtils;
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
            conn = JDBCUtils.getConnection();
            System.out.println(conn);

            /**
             * 预编译sql语句
             */
            String sql = "update customers set name = ? where id = ?";
            ps = conn.prepareStatement(sql);

            /**
             * 填充数据
             */
            ps.setObject(1,"高勋");
            ps.setObject(2,18);

            /**
             * 执行
             */
            ps.execute();
            System.out.println("跟新成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,ps);
        }

    }
}
