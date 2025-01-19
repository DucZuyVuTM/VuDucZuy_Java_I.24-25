public class Developer extends Employee {
    public Developer(String name, int age, int salary) {
        super(name, age, salary);
    }

    @Override
    public int calculateBonus(int projectAmount) {
        return projectAmount * 200;
    }
}
