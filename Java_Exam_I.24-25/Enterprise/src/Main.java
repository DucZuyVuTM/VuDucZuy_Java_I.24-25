public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("Zuy2", 30, 10000);
        Developer developer = new Developer("Zuy", 16, 6000);

        manager.calculateBonus(300);
        developer.calculateBonus(30);

        System.out.println("Developer:");
        System.out.println(developer.getName());
        System.out.println(developer.getAge());
        System.out.println(developer.getSalary());

        System.out.println("--------");

        System.out.println("Manager:");
        System.out.println(manager.generateReport(300));
    }
}
