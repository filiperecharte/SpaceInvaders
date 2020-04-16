import Model.Position;
import Model.Ship;

public class Application {
    public static void main(String[] args) {
        Ship s = new Ship(new Position(0,0) );
        System.out.println("Hello World!");
        System.out.println(s.getDesign());

        String a = "abc";
        System.out.println(a);
    }
}
