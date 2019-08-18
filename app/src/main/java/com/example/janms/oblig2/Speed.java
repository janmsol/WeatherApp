package com.example.janms.oblig2;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict= false)
class Speed {

    @Attribute
    private float value;

    @Attribute
    private String name;

    public float getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Speed{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
