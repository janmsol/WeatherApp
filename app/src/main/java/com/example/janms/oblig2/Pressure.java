package com.example.janms.oblig2;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict= false)
class Pressure {

    @Attribute
    private float value;

    @Attribute
    private String unit;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Pressure{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                '}';
    }
}
