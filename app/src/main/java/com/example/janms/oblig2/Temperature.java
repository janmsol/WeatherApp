package com.example.janms.oblig2;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict= false)
class Temperature {

    @Attribute
    private float value;

    @Attribute
    private float min;

    @Attribute
    private float max;

    @Attribute
    private String unit;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "value=" + value + '\'' +
                ", min=" + min + '\'' +
                ", max=" + max + '\'' +
                ", unit='" + unit + '}';
    }
}
