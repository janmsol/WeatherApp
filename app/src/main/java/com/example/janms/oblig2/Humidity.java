package com.example.janms.oblig2;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict= false)
class Humidity {

    @Attribute
    private float value;

    @Attribute
    private char unit;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public char getUnit() {
        return unit;
    }

    public void setUnit(char unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Humidity{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}
