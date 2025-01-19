public class Manager extends Employee implements Reportable {
    public Manager(String name, int age, int salary) {
        super(name, age, salary);
    }

    @Override
    public int calculateBonus(int workerAmount) {
        return workerAmount * 100;
    }

    public String generateReport(int workerAmount) {
        return "Name: " + getName() + "\n" +
        "Age: " + getAge() + "\n" +
        "Salary: " + getSalary() + "\n" +
        "Bonus: " + calculateBonus(workerAmount);
    }
}
