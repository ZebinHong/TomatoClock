package com.zebin.service;

import com.zebin.bean.Tomato;

import java.sql.Date;
import java.util.List;

public interface TomatoService {
    public void addTomato(Tomato tomato);
    public void deleteTomatoById(int id);
    public void updateTomato(Tomato tomato);
    public List<Tomato> queryTomatoByDate(Date date);
    public List<Tomato> queryTomatos();
}
