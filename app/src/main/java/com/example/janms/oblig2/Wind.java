package com.example.janms.oblig2;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict= false)
class Wind {

    @Element
    private Speed speed;

    @Element
    private Direction direction;

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", direction=" + direction +
                '}';
    }
}
