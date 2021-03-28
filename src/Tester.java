import stack.*;
import queue.*;
import util.IsEmptyException;

public class Tester {
    public static void main(String[] args) {

        try {
            DynamicQueue<Integer> queue = new DynamicQueue<>();
            System.out.println("isEmpty(True) - "+queue.isEmpty());

            queue.enqueue(10);
            queue.enqueue(1);
            queue.enqueue(6);
            queue.enqueue(8);

            System.out.println("1er dequeue debe ser 10: " + queue.dequeue());
            System.out.println("Size, debe ser 3: "+queue.size());

            queue.enqueue(3);
            queue.enqueue(7);

            System.out.println("2do dequeue debe ser 1: " + queue.dequeue());

            queue.enqueue(54);
            queue.enqueue(664);

            System.out.println("3 dequeue debe ser 6: " + queue.dequeue());
            System.out.println("4 dequeue debe ser 8: " + queue.dequeue());
            System.out.println("5 dequeue debe ser 3: " + queue.dequeue());

            queue.enqueue(999);

            System.out.println("isEmpty (False): "+ queue.isEmpty());
            System.out.println("6 dequeue debe ser 7: " + queue.dequeue());
            System.out.println("7 dequeue debe ser 54: " + queue.dequeue());
            System.out.println("8 dequeue debe ser 664: " + queue.dequeue());
            System.out.println("9 dequeue debe ser 999: " + queue.dequeue());


            System.out.println("Size debe ser 0: "+queue.size());
            System.out.println("isEmpty (True) - "+ queue.isEmpty());

            queue.dequeue();

        } catch (IsEmptyException e){
            System.out.println(e.getMessage());
        }



    /*
        try {

            StaticStack<Integer> stack = new StaticStack<>();
            System.out.println(stack.isEmpty());
            stack.stack(10);
            stack.stack(1);
            stack.stack(6);
            stack.stack(8);
            System.out.println(stack.isEmpty());
            System.out.println(stack.peek());
            stack.pop();
            System.out.println(stack.peek());
            System.out.println("Empty? (false)");
            System.out.println(stack.isEmpty());
            stack.empty();
            System.out.println("Empty? (true)");
            System.out.println(stack.isEmpty());
            stack.pop();

            System.out.println(stack.isEmpty());

        } catch(IsEmptyException e){
            System.out.println(e.getMessage());
        }





        /*stack.StaticStack<Integer> stack = new stack.StaticStack<>();
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
