public class Tester {
    public static void main(String[] args) {
        StaticQueue<Integer> queue = new StaticQueue<>();
        queue.enqueue(10);
        queue.enqueue(1);
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(3);
        queue.enqueue(7);
        queue.enqueue(54);
        queue.enqueue(664);
        queue.enqueue(700);
        queue.enqueue(2345);
        queue.enqueue(34433);

        /*
        StaticStack<Integer> stack = new StaticStack<>();
        stack.push(10);
        stack.push(1);
        stack.push(6);
        stack.push(8);
        stack.push(3);
        stack.push(7);
        stack.push(54);
        stack.push(664);
        stack.push(700);
        stack.push(2345);
        stack.push(34433);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.push(666);
        System.out.println(stack.peek());

         */

    }
}
