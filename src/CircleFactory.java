public class CircleFactory {
    private static int count = 0;

    //Создает Circle по координатам центра и значению радиуса.
    public static Circle createCircle(Point2D center, int radius) {
        count++;
        return new Circle(center, radius);
    }

    //Возвращает количество Circle, созданных с помощью метода createCircle.
    public static int getCircleCount() {
        return count;
    }

    //Устанавливает количество Circle, созданных с помощью метода createCircle, равным 0
    // (иными словами, реинициализирует фабрику).
    public static void reset() {
        count = 0;
    }
}
