import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
      System.out.println("Unsorted Array ---------------------------------------------------");
      ArrayList<Integer> integerList = Lab4.getList();
      Lab4.outputList(integerList);

      System.out.println("\n\nBubble sort results ----------------------------------------------");
      long startTime = System.nanoTime();
      ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(new ArrayList<>(integerList));
      long endTime = System.nanoTime();
      long duration = (endTime - startTime);
      System.out.println("Bubble sort took: " + duration + " nanoseconds");
      Lab4.outputList(bubbleSortedList);

      System.out.println("\n\nInsertion sort results -------------------------------------------");
      startTime = System.nanoTime();
      ArrayList<Integer> insertionSortedList = Lab4.insertionSort(new ArrayList<>(integerList));
      endTime = System.nanoTime();
      duration = (endTime - startTime);
      System.out.println("Insertion sort took: " + duration + " nanoseconds");
      Lab4.outputList(insertionSortedList);
  }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    for (int i = 1; i < integerList.size(); i++) {
        int key = integerList.get(i);
        int j = i - 1;
        while (j >= 0 && integerList.get(j) > key) {
            integerList.set(j + 1, integerList.get(j));
            j = j - 1;
        }
        integerList.set(j + 1, key);
    }
    return integerList;
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
    int n = integerList.size();
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (integerList.get(j) > integerList.get(j + 1)) {
                int temp = integerList.get(j);
                integerList.set(j, integerList.get(j + 1));
                integerList.set(j + 1, temp);
            }
        }
    }
    return integerList;
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
        while ((line = br.readLine()) != null) {
            integerList.add(Integer.parseInt(line));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (int i = 0; i < integerList.size(); i++) {
        System.out.print(integerList.get(i) + " ");
    }
  }
}
//I would use he Merge Sort method
//Yes the bubble sort took longer, and yes due to the amount of repeats through the list for swaps
//Bubble sort seems easier since its easier to understand and code