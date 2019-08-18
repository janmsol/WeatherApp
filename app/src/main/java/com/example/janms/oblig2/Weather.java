package com.example.janms.oblig2;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict= false)
class Weather {

    @Attribute
    private float number;

    @Attribute
    private String value;

    @Attribute
    private String icon;

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "number=" + number +
                ", value='" + value + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
