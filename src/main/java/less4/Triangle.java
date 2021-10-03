package less4;

public class Triangle {

    public static double calculateTriangleSquare(int a, int b, int c) throws Exception {

        if (a <= 0 || b <= 0 || c <= 0) throw new Exception();
        double halfPerimeter = (a + b + c) / 2,
                halfPerimeterA = (halfPerimeter - a),
                halfPerimeterB = (halfPerimeter - b),
                halfPerimeterC = (halfPerimeter - c);

        return (halfPerimeter * halfPerimeterA * halfPerimeterB * halfPerimeterC);
    }

}
