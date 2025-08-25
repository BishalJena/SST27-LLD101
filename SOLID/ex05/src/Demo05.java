
public class Demo05 {
    static int areaAfterResize(Shape s){
        if (s instanceof Rectangle) {
            Rectangle r = (Rectangle) s;
            r.setWidth(5); r.setHeight(4);
        } else if (s instanceof Square) {
            Square sq = (Square) s;
            sq.setSide(4);
        }
        return s.area();
    }
    public static void main(String[] args) {
        System.out.println(areaAfterResize(new Rectangle())); // 20
        System.out.println(areaAfterResize(new Square()));    // 16
    }
}
