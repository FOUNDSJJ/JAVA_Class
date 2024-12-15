public class GenericsDemo {

    public static class Animal {
        private final String name;

        public Animal(String n) {
            name = n;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "name: " + name;
        }
    }

    public static class Bird extends Animal {
        private final String color;

        public Bird(String n, String c) {
            super(n);
            this.color = c;
        }

        public String getColor() {
            return color;
        }

        @Override
        public String toString() {
            return super.toString() + "   color: " + color;
        }
    }

    public static class Lion extends Animal {
        private final int age;

        public Lion(String n, int a) {
            super(n);
            this.age = a;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return super.toString() + "   age: " + age;
        }
    }

    public static class Cage<T extends Animal> extends java.util.HashSet<T> {
        public Cage() {
            super();
        }
    }

    public static void main(String[] args) {
        System.out.println("--实例化Animal、Bird、Lion对象");
        var animal = new Animal("动物");
        System.out.println("animal: " + animal.toString());
        var bird = new Bird("鸟类", "白色");
        System.out.println("bird: " + bird.toString());
        var lion = new Lion("狮子", 3);
        System.out.println("lion: " + lion.toString());
        System.out.println("--实例化Cage对象");
        var myCage = new Cage<>();
        System.out.println("myCage.add(animal): "+myCage.add(animal));
        System.out.println("myCage.add(bird): "+myCage.add(bird));
        System.out.println("myCage.add(animal): "+myCage.add(lion));
        System.out.println("--遍历myCage");
        for (var data : myCage) {
            System.out.println(data.toString());
        }
    }

}
