/*
 * Driver to test ArrayList(ObjectList), Stack and Queue
 * methods
 * 
 * @author Connor Lauerman
 * @version 10/13/2019
 */

public class ArrayBasedDataStructuresDriver {

    public static void main(String[] args) {
        stackTests();
        queueTests();
        arrayListTests();
    }

    private static void arrayListTests() {
       System.out.println("\n ArrayList testing");
        ArrayList a = new ArrayList();
        ArrayList b = new ArrayList();
        ArrayList c = a;
        //Insert Test
        a.insert('B', 0);
        a.insert('t',1);
        a.insert('a',0);
        //Testing add
        a.add('o');
        b.add('h');
        b.add('a');
        System.out.println(b.toString());
        
        System.out.println("Testing to String \n");
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println("Testing equals \n");
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println("Testing isEmpty and remove \n");
        System.out.println(a.isEmpty());
        while(a.isEmpty() == false) {
            System.out.println(a.remove(0));           
        }
        System.out.println(a.isEmpty());
        System.out.println();
        System.out.println("Testing size \n");
        System.out.println("Size " + b.size());
        System.out.println("Testing remove \n");
        System.out.println(b.remove(0));
        System.out.println("Testing OutOfBoundsRemove");
        System.out.println(b.remove(6));
        System.out.println("Testing size \n");
        System.out.println("Size " + b.size());
        System.out.println("Testing indexOf \n");
        System.out.println(b.indexOf('d'));
        System.out.println(b.indexOf('z'));
        System.out.println("Testing get, remove, get \n");
        System.out.println(b.get(0));
        System.out.println(b.remove(0));
        System.out.println(b.get(0));
        System.out.println(b.get(-1));
        System.out.println(b.get(9000));

    }

    private static void queueTests() {
        System.out.println("\n Testing  queue methods");
        
        Queue a = new Queue();
        Queue b = new Queue();
        Queue c = a;
        System.out.println("Testing enqueue and size \n");
        a.enqueue('B');
        a.enqueue('a');
        a.enqueue('t');
        System.out.println("Size " + b.size());
        b.enqueue('a');
        System.out.println("Size " + b.size());
        b.enqueue('b');
        System.out.println("Size " + b.size());
        b.enqueue('c');
        System.out.println("Size " + b.size());
        System.out.println("Testing to String \n");
        System.out.println(b.toString());
        
        System.out.println("Testing dequeue \n");
        System.out.println(b.dequeue());
        System.out.println("Size " + b.size());
        System.out.println(b.toString());

        System.out.println("Testing equals \n");
        System.out.println(a.equals(c));
        System.out.println(a.equals(b));
        System.out.println(a.toString());
        
        
        System.out.println("Testing isEmpty and dequeue \n");
        System.out.println(a.isEmpty());
        while(a.isEmpty() == false) {
            System.out.println(a.dequeue());
        }
        System.out.println(a.isEmpty());

    }
    private static void stackTests() {
        System.out.println("Testing stack methods \n");
        Stack a = new Stack();
        Stack b = new Stack();
        Stack c = a;
        System.out.println("Testing push and size \n");
        a.push('B');
        a.push('a');
        a.push('t');
        System.out.println("Size " + b.size());
        b.push('x');
        System.out.println("Size " + b.size());
        b.push('y');
        System.out.println("Size " + b.size());
        b.push('z');
        System.out.println("Size " + b.size());
        System.out.println("Testing pop \n");
        System.out.println(b.pop());
        System.out.println("Size " + b.size());
       
        
        System.out.println("Testing toString \n");
        System.out.println(a.toString());
        System.out.println(b.toString());

        System.out.println("Testing isEmpty \n");
        System.out.println(a.isEmpty());
        while(a.isEmpty() == false) {
            System.out.println(a.pop());
        }
        System.out.println(a.isEmpty());
        System.out.println(a.toString());
        
        System.out.println("Testing equals \n");
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
    }
}

