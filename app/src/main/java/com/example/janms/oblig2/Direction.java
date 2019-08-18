package com.example.janms.oblig2;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict= false)
class Direction {

    @Attribute
    private float value;

    @Attribute
    private String code;

    @Attribute
    private String name;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "value=" + value +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
