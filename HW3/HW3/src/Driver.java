/**
 *
 */
public class Driver {
    public static void main(String[] args) {
        // Create CellPhone objects
        CellPhone phone1 = new CellPhone(1, 200, 10);
        CellPhone phone2 = new CellPhone(2, 100, 10);
        Task task1 = new Task("T1", 10);
        phone1.addTask(task1);
        phone1.processTask(task1);

        System.out.println("Phone 1: " + phone1.toString());
        System.out.println("Phone 2: " + phone2.toString());

        System.out.println("Phone: " + phone1.equals(phone2));

        // Create Laptop objects
        Laptop laptop1 = new Laptop(1, 200, 10, true);
        Laptop laptop2 = new Laptop(2, 100, 10, false);

        Task task3 = new Task("T3", 30);
        laptop1.addTask(task3);
        laptop1.processTask(task3);

        System.out.println("Laptop 1: " + laptop1.toString());
        System.out.println("Laptop 2: " + laptop2.toString());
        System.out.println("Laptop: " + laptop1.equals(laptop2));
    }
}
