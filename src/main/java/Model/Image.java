package Model;

import java.util.ArrayList;

public class Image extends Box {

    private ArrayList<Pixel> matrix;

    public Image() {
        super(new Position(0, 0), new Size(0, 0));
        matrix = new ArrayList<>();
    }

    public void addPixel(Pixel pixel) {
        matrix.add(pixel);
    }

    public void removePixel(Position position) {
        for (int i = 0; i < matrix.size(); i++) {
            if (matrix.get(i).getPosition().equals(position)) {
                matrix.remove(i);
                break;
            }
        }
    }

    public void updateSize() {

    }


}
