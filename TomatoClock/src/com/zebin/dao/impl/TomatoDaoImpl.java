package com.zebin.dao.impl;

import com.zebin.bean.Tomato;
import com.zebin.dao.BaseDao;
import com.zebin.dao.TomatoDao;
import com.zebin.utils.JdbcUtils;

import java.sql.Date;
import java.util.List;

public class TomatoDaoImpl extends BaseDao implements TomatoDao {
    @Override
    public int addTomato(Tomato tomato) {
        String sql="insert into t_tomato(`work_time`,`date`,`count`,remark) VALUES(?,?,?,?)";
        return update(sql, tomato.getWorkTime(), tomato.getDate(), tomato.getCount(), tomato.getRemark());
    }

    @Override
    public int deleteTomatoById(int id) {
        String sql="delete t_tomato where id=?";
        return update(sql,id);
    }

    @Override
    public int updateTomato(Tomato tomato) {
        String sql="update t_tomato set work_time=?,`date`=?,`count`=?,remark=? where id=?";
        return update(sql,tomato.getWorkTime(),tomato.getDate(),tomato.getCount(),tomato.getRemark(),tomato.getId());
    }

    @Override
    public List<Tomato> queryTomatoByDate(Date date) {
        String sql = "select * from t_tomato where date=?";
        List<Tomato> tomatoes = queryForList(Tomato.class, sql, date);
        return tomatoes;
    }

    @Override
    public List<Tomato> queryTomatos() {
        String sql="select * from t_tomato";
        List<Tomato> tomatoes = queryForList(Tomato.class, sql);
        return tomatoes;
    }
}
