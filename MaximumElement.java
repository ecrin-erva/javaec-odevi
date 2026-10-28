
package odev;

import java.util.ArrayList;
import java.util.Scanner;

public class MaximumElement   {

    public static Integer max(ArrayList<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }

        int maximum = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > maximum) {
                maximum = list.get(i);
            }
        }

        return maximum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.print("Enter integers (0 to end): ");

        int number = input.nextInt();

        while (number != 0) {
            numbers.add(number);
            number = input.nextInt();
        }

        Integer largest = max(numbers);

        if (largest == null) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("The largest number is " + largest);
        }

        input.close();
    }
}


