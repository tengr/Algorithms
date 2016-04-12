import java.util.*;
public class NonDeterministicFizzBuzz {
    public static void main(String args[]) {
        HashMap<Integer, String> pool =
            new HashMap<Integer, String>();
        while (pool.size() < 100) {
            int i = (int) (Math.random() * 100);
            System.out.println("i = " + i);
            if (!pool.containsKey(i)) {
                String val = "";
                val += (i % 3 == 0) ? "Fizz" : "";
                val += (i % 5 == 0) ? "Buzz" : "";
                val = (val.equals("")) ? "" + i : val;
                pool.put(i, val);
                System.out.println(val);
            }
        }
    }
}