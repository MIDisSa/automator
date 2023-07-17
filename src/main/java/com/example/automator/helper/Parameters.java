package com.example.automator.helper;

import com.opencsv.bean.CsvBindByName;

public class Parameters {

    @CsvBindByName
    private String parameter1;

    @CsvBindByName
    private String parameter2;

    public String getParameter1() {
        return parameter1;
    }

}
