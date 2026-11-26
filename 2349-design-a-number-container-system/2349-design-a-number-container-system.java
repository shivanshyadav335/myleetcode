import java.util.HashMap;
import java.util.TreeSet;

class NumberContainers {

    HashMap<Integer, Integer> indexMap;
    HashMap<Integer, TreeSet<Integer>> numberMap;

    public NumberContainers() {
        indexMap = new HashMap<>();
        numberMap = new HashMap<>();
    }

    public void change(int index, int number) {

        // Check if index already has a number
        if (indexMap.containsKey(index)) {
            int oldNumber = indexMap.get(index);

            // Remove index from old number's set
            numberMap.get(oldNumber).remove(index);
        }

        // Update index with new number
        indexMap.put(index, number);

        // Add index to new number's set
        numberMap.putIfAbsent(number, new TreeSet<>());
        numberMap.get(number).add(index);
    }

    public int find(int number) {

        if (!numberMap.containsKey(number) ||
            numberMap.get(number).isEmpty()) {
            return -1;
        }

        // Return smallest index
        return numberMap.get(number).first();
    }
}
