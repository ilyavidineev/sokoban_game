package model;


import static model.Model.FIELD_CELL_SIZE;

public abstract class CollisionObject extends GameObject {
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        switch (direction) {
            case UP:
                return (this.x == gameObject.x && this.y - FIELD_CELL_SIZE == gameObject.y);
            case DOWN:
                return (this.x == gameObject.x && this.y + FIELD_CELL_SIZE == gameObject.y);
            case LEFT:
                return (this.x - FIELD_CELL_SIZE == gameObject.x && this.y == gameObject.y);
            case RIGHT:
                return (this.x + FIELD_CELL_SIZE == gameObject.x && this.y == gameObject.y);
            default:
                return false;
        }
    }

}
