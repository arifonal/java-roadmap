package toolbox;

import java.util.List;

//arif önal
public final class ToolboxUtils {

    private ToolboxUtils() {  }

    public static <U> void printAll(List<U> list) {
        for (U element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static double sumNumbers(List<? extends Number> list) {
        double total = 0.0;
        for (Number n : list) {
            total += n.doubleValue();
        }
        return total;
    }


    public static void fillWithIntegers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
}
