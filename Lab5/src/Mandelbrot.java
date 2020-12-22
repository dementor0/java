import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
    public static final int LIMIT = 2000;                 //максимальное количество итераций

    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    public int numIterations(double x, double y) {
        ComplexNum cmplx = new ComplexNum(0, 0);                // метод который создаст коплексное число
        int iterator = 0;

        while (iterator < LIMIT && cmplx.getSquaredModule() < 4) {
            cmplx.makeSquaredInPoint(x, y);                            //возводим в квадрат точку

            iterator++;
        }

        if (iterator == LIMIT) return -1;

        return iterator;                           // если условие iterator <= LIMIT && cmplx.getSquaredModule() < 4 не выполняется
    }
    @Override
    public String toString() { return "Mandelbrot"; }
}
