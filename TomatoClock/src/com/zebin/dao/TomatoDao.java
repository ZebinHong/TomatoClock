package com.zebin.dao;

import com.zebin.bean.Tomato;

import java.sql.Date;
import java.util.List;

public interface TomatoDao {
    public int addTomato(Tomato tomato);
    public int deleteTomatoById(int id);
    public int updateTomato(Tomato tomato);
    public List<Tomato> queryTomatoByDate(Date date);
    public List<Tomato> queryTomatos();
}
