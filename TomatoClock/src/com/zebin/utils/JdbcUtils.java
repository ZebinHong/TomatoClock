package com.zebin.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author ZebinHong
 * @create 2021-07-24-15:53
 */
public class JdbcUtils {
    /**
     * 开启数据库连接
     * @return
     * @throws Exception
     */
    QueryRunner qr = new QueryRunner();
//    public static Connection getConnection() throws Exception {
//
//        //1.获取四个参数信息
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
//        Properties pro = new Properties();
//        pro.load(is);
//        //
//        String user = pro.getProperty("user");
//        String password = pro.getProperty("password");
//        String url = pro.getProperty("url");
//        String driverClass = pro.getProperty("driverClass");
//        //2.加载驱动
//        Class.forName(driverClass);
//        //3.连接
//        Connection con = DriverManager.getConnection(url, user, password);
//        System.out.println("数据库连接成功:"+con);
//        return con;
//    }
    /**
     * 使用Druid数据库连接池技术
     */
    private static DataSource source1;
    static{
        try {
            Properties pros = new Properties();

            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");

            pros.load(is);

            source1 = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException{

        Connection conn = source1.getConnection();
        return conn;
    }
    /**
     * 关闭数据库连接
     * @param conn
     * @param ps
     */
    public static void resourceClose(Connection conn,PreparedStatement ps){
        if(ps!=null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 关闭数据库连接
     * @param conn
     * @param ps
     * @param rs
     */
    public static void resourceClose(Connection conn, PreparedStatement ps, ResultSet rs){
        /*if(ps!=null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(con!=null) {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }*/
        //调用工具类写法
        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(ps);
        DbUtils.closeQuietly(rs);
    }
}
