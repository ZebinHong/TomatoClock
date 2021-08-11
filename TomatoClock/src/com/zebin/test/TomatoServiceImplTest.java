package com.zebin.test;

import com.zebin.bean.Tomato;
import com.zebin.service.impl.TomatoServiceImpl;

import java.sql.Date;

import static org.junit.Assert.*;

public class TomatoServiceImplTest {

    @org.junit.Test
    public void addTomato() {
        TomatoServiceImpl tsi = new TomatoServiceImpl();
        tsi.addTomato(new Tomato(0,25,new Date(System.currentTimeMillis()),1,null));
    }
}