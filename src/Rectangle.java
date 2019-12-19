import java.util.Objects;

public class Rectangle {
    private Point2D pointA;
    private Point2D pointC;

    //Создает Rectangle по координатам углов - левого верхнего и правого нижнего.
    public Rectangle(Point2D leftTop, Point2D rightBottom) {
        this.pointA = leftTop;
        this.pointC = rightBottom;
    }

    //Создает Rectangle по координатам углов - левого верхнего и правого нижнего.
    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this(new Point2D(xLeft, yTop), new Point2D(xRight, yBottom));
    }

    //Создает Rectangle, левый нижний угол которого находится в начале координат,
    // а  длина (по оси X) и ширина (по оси Y) задаются.
    public Rectangle(int length, int width) {
        this(0, -width, length, 0);
    }

    //Создает Rectangle с размерами (1,1), левый нижний угол которого находится в начале координат.
    public Rectangle() {
        this(1,1);
    }

    //Возвращает левую верхнюю точку Rectangle.
    public Point2D getTopLeft() {
        return pointA;
    }

    //Устанавливает левую верхнюю точку Rectangle.
    public void setTopLeft(Point2D topLeft) {
        this.pointA = topLeft;
    }

    //Возвращает правую нижнюю точку Rectangle.
    public Point2D getBottomRight() {
        return pointC;
    }

    //Устанавливает правую нижнюю точку Rectangle.
    public void setBottomRight(Point2D bottomRight) {
        this.pointC = bottomRight;
    }

    //Возвращает длину прямоугольника.
    public int getLength() {
        return getBottomRight().getX() - getTopLeft().getX();
    }

    //Возвращает ширину прямоугольника.
    public int getWidth() {
        return getBottomRight().getY() - getTopLeft().getY();
    }

    //Передвигает Rectangle на (dx, dy).
    public void moveRel(int dx, int dy) {
        pointA.moveRel(dx, dy);
        pointC.moveRel(dx, dy);
    }

    //Увеличивает стороны Rectangle в (nx, ny) раз при сохранении координат левой верхней вершины.
    public void enlarge(int nx, int ny) {
        pointC.moveTo(pointA.getX() + getLength() * nx, pointA.getY() + getWidth() * ny);
    }

    //Возвращает площадь прямоугольника.
    public double getArea() {
        return getLength() * getWidth();
    }

    //Возвращает периметр прямоугольника.
    public double getPerimeter() {
        return (getLength() + getWidth()) * 2;
    }

    //Определяет, лежит ли точка (x, y) внутри Rectangle. Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(int x, int y) {
        return (x >= getTopLeft().getX()) && (x <= getBottomRight().getX()) &&
                (y <= getBottomRight().getY()) && (y >= getTopLeft().getY());
    }

    //Определяет, лежит ли точка point внутри Rectangle. Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
    }

    //Определяет, пересекается  ли Rectangle с другим Rectangle. Считается, что прямоугольники пересекаются,
    // если у них есть хоть одна общая точка.
    public boolean isIntersects(Rectangle rectangle) {
        return !(getTopLeft().getY() > rectangle.getBottomRight().getY() ||
                getBottomRight().getY() < rectangle.getTopLeft().getY()
                ||
                getTopLeft().getX() > rectangle.getBottomRight().getX() ||
                getBottomRight().getX() < rectangle.getTopLeft().getX());
    }

    //Определяет, лежит ли rectangle целиком внутри текущего Rectangle.
    public boolean isInside(Rectangle rectangle) {
        return isInside(rectangle.getTopLeft()) && isInside(rectangle.getBottomRight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(pointA, rectangle.pointA) &&
                Objects.equals(pointC, rectangle.pointC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointA, pointC);
    }
}
