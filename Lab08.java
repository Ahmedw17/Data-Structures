import java.util.HashMap;
import java.util.Scanner;
public class Lab08 {
    public static void main(String[] args) {
        
        HashMap<Integer, String> students = new HashMap<>();
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== Insert ===");
        students.put(101, "Sara");
        students.put(102, "Ali");
        students.put(103, "Mona");
        System.out.println("Records added successfully.\n");
       
        System.out.println("=== Search ===");
        System.out.print("Enter student ID to search: ");
        int searchId = input.nextInt();
        if (students.containsKey(searchId)) {
            System.out.println("Record Found: " + students.get(searchId));
        } else {
            System.out.println("Record not found.");
        }
      
        System.out.println("\n=== Delete ===");
        System.out.print("Enter student ID to delete: ");
        int deleteId = input.nextInt();
        if (students.containsKey(deleteId)) {
            students.remove(deleteId);
            System.out.println("Record Deleted.");
        } else {
            System.out.println("Record not found.");
        }
        
        System.out.println("\n=== Remaining Records ===");
        System.out.println(students);
        input.close();
    }
}
