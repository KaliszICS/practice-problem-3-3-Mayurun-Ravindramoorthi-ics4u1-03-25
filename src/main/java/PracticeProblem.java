import java.util.*;

public class PracticeProblem {

    // 1. All permutations (with duplicates allowed)
    public static ArrayList<String> perms(String str) {
        ArrayList<String> result = new ArrayList<>();
        permute(str.toCharArray(), 0, result);
        return result;
    }

    private static void permute(char[] chars, int index, ArrayList<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            permute(chars, index + 1, result);
            swap(chars, index, i); // backtrack
        }
    }

    // 2. Unique permutations (no duplicates in result)
    public static ArrayList<String> permsUnique(String str) {
        Set<String> resultSet = new HashSet<>();
        permuteUnique(str.toCharArray(), 0, resultSet);
        return new ArrayList<>(resultSet);
    }

    private static void permuteUnique(char[] chars, int index, Set<String> resultSet) {
        if (index == chars.length) {
            resultSet.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            if (canSwap(chars, index, i)) {
                swap(chars, index, i);
                permuteUnique(chars, index + 1, resultSet);
                swap(chars, index, i); // backtrack
            }
        }
    }

    private static boolean canSwap(char[] chars, int start, int current) {
        for (int i = start; i < current; i++) {
            if (chars[i] == chars[current]) {
                return false;
            }
        }
        return true;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Optional: test in main
    public static void main(String[] args) {
        System.out.println("All permutations of 'aab': " + perms("aab"));
        System.out.println("Unique permutations of 'aab': " + permsUnique("aab"));
    }
}