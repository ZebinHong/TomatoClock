package com.zebin.service.impl;

import com.zebin.bean.Tomato;
import com.zebin.dao.impl.TomatoDaoImpl;
import com.zebin.service.TomatoService;

import java.sql.Date;
import java.util.List;

public class TomatoServiceImpl implements TomatoService {
    TomatoDaoImpl tdi = new TomatoDaoImpl();

    @Override
    public void addTomato(Tomato tomato) {
        tdi.addTomato(tomato);
    }

    @Override
    public void deleteTomatoById(int id) {
        tdi.deleteTomatoById(id);
    }

    @Override
    public void updateTomato(Tomato tomato) {
        tdi.updateTomato(tomato);
    }

    @Override
    public List<Tomato> queryTomatoByDate(Date date) {
        return tdi.queryTomatoByDate(date);
    }

    @Override
    public List<Tomato> queryTomatos() {
        return tdi.queryTomatos();
    }
}
