package com.example.janms.oblig2;

import org.simpleframework.xml.Root;

@Root(strict= false)
public class Timezone {
    private String id;
    private int utcOffsetMin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUtcOffsetMin() {
        return utcOffsetMin;
    }

    public void setUtcOffsetMin(int utcOffsetMin) {
        this.utcOffsetMin = utcOffsetMin;
    }

    @Override
    public String toString() {
        return "{" + "id: " + id + '\'' +
                ", utcOffsetMin: " + utcOffsetMin + '}';
    }
}
