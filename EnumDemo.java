public class EnumDemo {

    public enum TrafficLight {
        RED, YELLOW, GREEN;

        public static void printTrafficLight() {
            for (var color : values()) {
                System.out.printf("%-15s %s ", "Color:" + color, "Index:" + color.ordinal());
                System.out.println();
            }
        }
    }

    public static String translateTrafficLight(TrafficLight light) {
        String message = "";
        switch (light) {
            case RED -> message = "现在是红灯，禁止通行！！！";
            case YELLOW -> message = "现在是黄灯，请减速观察后通过！！！";
            case GREEN -> message = "现在是绿灯，可以通行！！！";
        }
        return message;
    }

    public static void main(String[] args) {
        System.out.println("--打印红绿灯枚举信息");
        TrafficLight.printTrafficLight();
        System.out.println("\n--输出每种颜色的等的信息");
        for (var color : TrafficLight.values()) {
            System.out.printf("%-15s", "Color:" + color);
            System.out.println("Message:" + translateTrafficLight(color));
        }
    }
}
