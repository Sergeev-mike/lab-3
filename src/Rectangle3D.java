import java.util.Objects;

public class Rectangle3D extends Rectangle {
    private int height;

    //№1. Создает Rectangle3D по координатам углов основания (левого верхнего и правого нижнего) и высотой.
    public Rectangle3D(Point2D leftTop, Point2D rightBottom, int height) {
        super(leftTop, rightBottom);
        this.height = height;
    }

    //№2. Создает Rectangle3D по координатам углов основания (левого верхнего и правого нижнего) и высотой.
    public Rectangle3D(int xLeft, int yTop, int xRight, int yBottom, int height) {
        this(new Point2D(xLeft, yTop), new Point2D(xRight, yBottom), height);
        //new Point2D(xLeft, yTop), new Point2D(xRight, yBottom)
    }

    //№3. Создает Rectangle3D, левый нижний угол которого находится в начале координат,
    // а  длина, ширина и высота задаются.
    public Rectangle3D(int length, int width, int height) {
        this(0, -width, length, 0, height);
    }

    //№4. Создает Rectangle3D с размерами (1, 1, 1), левый нижний угол которого находится в начале координат.
    public Rectangle3D() {
        this(1, 1, 1);
    }

    //№7. Возвращает высоту параллелепипеда.
    public int getHeight() {
        return height;
    }

    //№10. Устанавливает высоту параллелепипеда.
    public void setHeight(int height) {
        this.height = height;
    }

    //№17. Возвращает объем параллелепипеда.
    public double getVolume() {
        return getArea() * getHeight();
    }

    //№20. Определяет, лежит ли точка (x, y, z) внутри Rectangle3D.
    // Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(int x, int y, int z) {
        return isInside(x, y) && isInside(x, z) && isInside(y, z);
    }

    //№21. Определяет, лежит ли точка point внутри Rectangle3D.
    // Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(Point3D point) {
        return isInside(point.getX(), point.getY(), point.getZ());
    }

    //№23. Определяет, лежит ли rectangle3D целиком внутри текущего Rectangle3D.
    public boolean isInside(Rectangle3D rectangle) {
        return super.isInside(rectangle) &&
                (getHeight() <= rectangle.getHeight() && getArea() <= rectangle.getArea()
                        ||
                        getHeight() >= rectangle.getHeight() && getArea() >= rectangle.getArea());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle3D that = (Rectangle3D) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), height);
    }
}
