import java.util.*;

class quicksort {
    
    static int partition(String[] names, int[] marks, int low, int high) {
        int pivot = marks[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (marks[j] >= pivot) {
                i++;
                int tempMarks = marks[i];
                marks[i] = marks[j];
                marks[j] = tempMarks;

                String tempName = names[i];
                names[i] = names[j];
                names[j] = tempName;
            }
        }

        int tempMarks = marks[i + 1];
        marks[i + 1] = marks[high];
        marks[high] = tempMarks;

        String tempName = names[i + 1];
        names[i + 1] = names[high];
        names[high] = tempName;

        return i + 1;
    }

    static void quickSort(String[] names, int[] marks, int low, int high) {
        if (low < high) {
            int pi = partition(names, marks, low, high);
            quickSort(names, marks, low, pi - 1);
            quickSort(names, marks, pi + 1, high);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> studentMap = new HashMap<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter marks of " + name + ": ");
            int marks = sc.nextInt();
            sc.nextLine();
            studentMap.put(name, marks);
        }

        String[] names = new String[n];
        int[] marks = new int[n];
        int idx = 0;
        for (Map.Entry<String, Integer> entry : studentMap.entrySet()) {
            names[idx] = entry.getKey();
            marks[idx] = entry.getValue();
            idx++;
        }

        quickSort(names, marks, 0, n - 1);

        System.out.println("\nStudent Rankings:");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + names[i] + " - " + marks[i]);
        }

        sc.close();
    }
}
