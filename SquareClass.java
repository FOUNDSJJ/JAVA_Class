public class SquareClass {

    public static class Square implements Cloneable {
        private int length;

        public Square(int len) {
            this.length = len;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass())
                return false;
            Square obj1 = (Square) obj;
            return length == obj1.length;
        }

        @Override
        public String toString() {
            return "Square[length=" + length + "]";
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public void setLength(int len) {
            length = len;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("**进程：创建square1,length=100，通过square1.clone()创建square2");
        Square square1 = new Square(100);
        Square square2 = (Square) square1.clone();
        System.out.println("square1:"+square1);
        System.out.println("square2:"+square2);
        System.out.println("square1是否和square2相同："+square2.equals(square1));
        System.out.println("**进程：将square2的length重置为200");
        square1.setLength(200);
        System.out.println("square1:"+square1);
        System.out.println("square2:"+square2);
        System.out.println("square1是否和square2相同："+square2.equals(square1));
    }

}
