package com.example.janms.oblig2;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict= false)
class Symbol {

    @Attribute
    private float number;

    @Attribute
    private String name;

    @Attribute
    private String var;

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }
}
