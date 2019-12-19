import java.util.Objects;

public class Triangle {
    private Point2D pointA;
    private Point2D pointB;
    private Point2D pointC;

    //Создает Triangle по координатам трех точек.
    public Triangle(Point2D point1, Point2D point2, Point2D point3) {
        this.pointA = point1;
        this.pointB = point2;
        this.pointC = point3;
    }

    //Возвращает точку 1 треугольника.
    public Point2D getPoint1() {
        return pointA;
    }

    //Возвращает точку 2 треугольника.
    public Point2D getPoint2() {
        return pointB;
    }

    //Возвращает точку 3 треугольника.
    public Point2D getPoint3() {
        return pointC;
    }

    //Устанавливает точку 1 треугольника.
    public void setPoint1(Point2D point) {
        this.pointA = point;
    }

    //Устанавливает точку 2 треугольника.
    public void setPoint2(Point2D point) {
        this.pointB = point;
    }

    //Устанавливает точку 3 треугольника.
    public void setPoint3(Point2D point) {
        this.pointC = point;
    }

    //Возвращает длину стороны 1-2.
    public double getSide12() {
        return Math.sqrt(Math.pow(pointA.getX() - pointB.getX(), 2) + Math.pow(pointA.getY() - pointB.getY(), 2));
    }

    //Возвращает длину стороны 1-3.
    public double getSide13() {
        return Math.sqrt(Math.pow(pointA.getX() - pointC.getX(), 2) + Math.pow(pointA.getY() - pointC.getY(), 2));
    }

    //Возвращает длину стороны 2-3.
    public double getSide23() {
        return Math.sqrt(Math.pow(pointB.getX() - pointC.getX(), 2) + Math.pow(pointB.getY() - pointC.getY(), 2));
    }

    //Передвигает Triangle на (dx, dy).
    public void moveRel(int dx, int dy) {
        pointA.moveRel(dx, dy);
        pointB.moveRel(dx, dy);
        pointC.moveRel(dx, dy);
    }

    //Возвращает площадь треугольника.
    public double getArea() {
        return Math.sqrt((getPerimeter() / 2) * (getPerimeter() / 2 - getSide12()) * (getPerimeter() / 2 - getSide13()) *
                (getPerimeter() / 2 - getSide23()));
    }

    //Возвращает периметр треугольника.
    public double getPerimeter() {
        return getSide12() + getSide13() + getSide23();
    }

    //Определяет, лежит ли точка (x, y) внутри Triangle.
    // Если точка лежит на стороне треугольника, считается, что она лежит внутри.
    public boolean isInside(int x, int y) {
        return (pointA.getX() - x) * (pointB.getY() - pointA.getY()) - (pointB.getX() - pointA.getX()) * (pointA.getY() - y) >= 0 &&
                (pointB.getX() - x) * (pointC.getY() - pointB.getY()) - (pointC.getX() - pointB.getX()) * (pointB.getY() - y) >= 0 &&
                (pointC.getX() - x) * (pointA.getY() - pointC.getY()) - (pointA.getX() - pointC.getX()) * (pointC.getY() - y) >= 0
                ||
                (pointA.getX() - x) * (pointB.getY() - pointA.getY()) - (pointB.getX() - pointA.getX()) * (pointA.getY() - y) <= 0 &&
                        (pointB.getX() - x) * (pointC.getY() - pointB.getY()) - (pointC.getX() - pointB.getX()) * (pointB.getY() - y) <= 0 &&
                        (pointC.getX() - x) * (pointA.getY() - pointC.getY()) - (pointA.getX() - pointC.getX()) * (pointC.getY() - y) <= 0;
    }

    //Определяет, лежит ли точка point внутри Triangle. Если точка лежит на стороне треугольника, считается, что она лежит внутри.
    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(pointA, triangle.pointA) &&
                Objects.equals(pointB, triangle.pointB) &&
                Objects.equals(pointC, triangle.pointC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointA, pointB, pointC);
    }
}
