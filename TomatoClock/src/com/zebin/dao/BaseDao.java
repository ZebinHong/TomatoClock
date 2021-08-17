package com.zebin.dao;

import com.zebin.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.swing.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ZebinHong
 * @create 2021-07-25-18:14
 */
public abstract class BaseDao {
    private QueryRunner qr = new QueryRunner();
    public BaseDao(){
    }

    /**
     * 验证数据库是否连接
     */
    public static void isConnection(){
        Connection con=null;
        try {
            con = JdbcUtils.getConnection();
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, "数据库连接失败", "出错",JOptionPane.ERROR_MESSAGE);

        }
    }

    /**
     * 增删改操作
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql, Object ...args){
        int update = 0;
        Connection con=null;
        try {
            con = JdbcUtils.getConnection();
            update = qr.update(con, sql, args);
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, "数据库连接失败", "出错",JOptionPane.ERROR_MESSAGE);
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return update;
    }

    /**
     * 获取一个对象
     * @param sql
     * @param args
     * @return
     */
    public <T> T queryForOne(Class<T> type,String sql,Object ...args) {
        T query = null;
        Connection con=null;
        try {
            con = JdbcUtils.getConnection();
            query = qr.query(con, sql, new BeanHandler<T>(type), args);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 获取多个对象
     * @param args
     * @return
     */
    public <T> List<T> queryForList(Class<T> type,String sql,Object...args){
        List<T> querys = null;
        Connection con=null;
        try {
            con = JdbcUtils.getConnection();
            querys = qr.query(con, sql, new BeanListHandler<T>(type), args);
            return querys;
        } catch (SQLException e) {
            System.out.println("链接数据库出错");
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    /**
     * 获取一个但一值得方法，专门用来执行像 select count(*)...这样的sql语句
     *
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql,Object ...args){
        Object query = null;
        Connection con=null;
        try {
            con = JdbcUtils.getConnection();
            query = qr.query(con, sql, new ScalarHandler(), args);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
