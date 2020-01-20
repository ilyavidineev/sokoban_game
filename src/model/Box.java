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
        graphics.fillRect(x - (width - 8) / 2, y - (height - 8) / 2, (width - 8), (height - 8));
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }
}
