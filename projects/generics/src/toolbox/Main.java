package toolbox;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Box<String> names = new Box<>();
        names.add("Ali");
        names.add("Ayşe");
        names.add("Zeynep");
        System.out.println("=== String Kutusu ===");
        System.out.println(names);
        System.out.println();


        Box<Double> doubles = new Box<>();
        doubles.add(12.3);
        doubles.add(11.2);
        doubles.add(11.0);


        double total = ToolboxUtils.sumNumbers(
                List.of(doubles.get(0), doubles.get(1), doubles.get(2)));

        System.out.println("=== Double Kutusu ===");
        System.out.println("Toplam: " + total);
        System.out.println();


        List<Number> nums = new ArrayList<>();
        ToolboxUtils.fillWithIntegers(nums);
        System.out.println("=== Integer Listesi ===");
        ToolboxUtils.printAll(nums);
        System.out.println();


        System.out.println("=== Çiftler ===");
        System.out.println(new Pair<>("Elma", 5));
        System.out.println(new Pair<>("Armut", 12));


    }
}
