package com.example.janms.oblig2;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict= false)
class Precip {

    @Attribute
    private String mode;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "Precip{" +
                "mode='" + mode + '\'' +
                '}';
    }
}
