package Model;

import Model.geometry.Position;
import Model.geometry.Size;

public class Box extends Element {
    protected Size size;
    public Box(Position position, Size size) {
        super(position);
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
