import java.util.Objects;

public class Cylinder extends Circle{

    private int height;

    //№1. Создает Cylinder по координатам центра, значению радиуса и высоте.
    public Cylinder(Point2D center, int radius, int height) {
        super(center,radius);
        this.height = height;
    }

    //№2. Создает Cylinder по координатам центра, значению радиуса и высоте.
    public Cylinder(int xCenter, int yCenter, int radius, int height) {
        this(new Point2D(xCenter, yCenter), radius, height);
    }

    //№3. Создает Cylinder  с центром в точке (0, 0) с указанными радиусом и высотой.
    public Cylinder(int radius, int height) {
        this(new Point2D(0, 0), radius, height);
    }

    //№4. Создает Cylinder  с центром в точке (0, 0) с радиусом 1 и высотой 1.
    public Cylinder() {
        this(1,1);
    }


    //№9. Возвращает высоту Cylinder.
    public int getHeight() {
        return height;
    }

    //№10. Устанавливает высоту Cylinder.
    public void setHeight(int height) {
        this.height = height;
    }

    //№15. Возвращает объем цилиндра.
    public double getVolume() {
        return getArea() * getHeight();
    }

    //№16. Определяет, лежит ли точка (x, y, z) внутри Cylinder.
    // Если точка лежит на поверхности, считается, что она лежит внутри.
    public boolean isInside(int x, int y, int z) {
        return super.isInside(x, y) && getHeight() >= z && z >= 0;
    }

    //№17. Определяет, лежит ли точка point внутри Cylinder. Если точка лежит на поверхности, считается, что она лежит внутри.
    public boolean isInside(Point3D point) {
        return isInside(point.getX(),point.getY(),point.getZ());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cylinder cylinder = (Cylinder) o;
        return height == cylinder.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), height);
    }
}
