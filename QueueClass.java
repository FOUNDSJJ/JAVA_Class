public class QueueClass {

    public static class MyQueue {

        private int capacity;
        private int[] arr;
        private int front, rear;
        private int size;

        MyQueue() {
            capacity = 2000;
            arr = new int[capacity];
            front = -1;
            rear = -1;
            size = 0;
        }

        private void expandQueue() {
            System.out.println("--队列元素超过容量，对队列进行扩展");
            capacity = 2 * capacity;
            int[] oldArr = arr;
            arr = new int[capacity];
            for (int i = rear - 1; i > front; i--)
                arr[i] = oldArr[i];
            System.out.println("--队列扩展完成！！！");
        }

        public void push(int val) {
            if (rear >= capacity - 1)
                expandQueue();
            rear++;
            arr[rear] = val;
            size++;
        }

        public boolean empty() {
            return size <= 0;
        }

        public void pop() {
            if (!empty()) {
                front++;
                size--;
            } else
                System.out.println("队列发生下溢出！！！");
        }

        public int peek() {
            if (!empty())
                return arr[front + 1];
            System.out.println("队列为空！！！");
            return Integer.MIN_VALUE;
        }

        public int getSize() {
            return size;
        }

    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println("**进程：队列创建成功");
        System.out.println("队列是否为空：" + myQueue.empty());
        System.out.println("队列的大小为：" + myQueue.getSize());
        System.out.println("**进程：下面将0~3999入队");
        for (int i = 0; i < 4000; i++)
            myQueue.push(i);
        System.out.println("**进程：0~3999入队完成");
        if (myQueue.peek() != Integer.MIN_VALUE)
            System.out.println("队首元素为：" + myQueue.peek());
        System.out.println("队列的大小为：" + myQueue.getSize());
        System.out.println("队列是否为空：" + myQueue.empty());
        System.out.println("**进程：下面将调用4001次myQueue.pop()");
        for (int i = 0; i < 4001; i++)
            myQueue.pop();
        if (myQueue.peek() != Integer.MIN_VALUE)
            System.out.println("队首元素为：" + myQueue.peek());
        System.out.println("**进程：myQueue.pop()调用结束");
        System.out.println("队列的大小为：" + myQueue.getSize());
        System.out.println("队列是否为空：" + myQueue.empty());
    }

}
