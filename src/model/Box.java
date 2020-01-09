package model;

import java.awt.*;

public class Box extends CollisionObject implements Movable {

    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(x - width / 2, y - height / 2, width, height);
        graphics.setColor(Color.ORANGE.darker());
        graphics.drawRect(x - (width - 6) / 2, y - (height - 6) / 2, (width - 7), (height - 7));
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }
}
