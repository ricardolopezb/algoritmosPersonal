public class Tester {
    public static void main(String[] args) {

        DynamicStack<Integer> stack = new DynamicStack<>();
        System.out.println(stack.isEmpty());
        stack.push(10);
        stack.push(1);
        stack.push(6);
        stack.push(8);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());



        /*StaticQueue<Integer> queue = new StaticQueue<>();
        System.out.println(queue.isEmpty());
        queue.enqueue(10);
        queue.enqueue(1);
        queue.enqueue(6);
        queue.enqueue(8);
        System.out.println("1er dequeue debe ser 10: "+queue.dequeue());
        queue.enqueue(3);
        queue.enqueue(7);
        System.out.println("2do dequeue debe ser 1: "+queue.dequeue());
        queue.enqueue(54);
        queue.enqueue(664);
        System.out.println("2do dequeue debe ser 6: "+queue.dequeue());
        System.out.println("2do dequeue debe ser 8: "+queue.dequeue());
        System.out.println("2do dequeue debe ser 3: "+queue.dequeue());
        System.out.println("2do dequeue debe ser 7: "+queue.dequeue());
        System.out.println("2do dequeue debe ser 54: "+queue.dequeue());
        System.out.println("2do dequeue debe ser 664: "+queue.dequeue());



        System.out.println(queue.size());
        System.out.println(queue.isEmpty());*/



        /*StaticStack<Integer> stack = new StaticStack<>();
        System.out.println(stack.isEmpty());
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
        System.out.println(stack.isEmpty());
        stack.push(666);
        System.out.println(stack.peek());*/

    }
}
