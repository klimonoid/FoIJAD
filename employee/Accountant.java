package employee;

public class Accountant {

    private final Integer managerSalary = 3000;
    private final Integer executiveSalary = 2000;
    private final Integer staffSalary = 1000;

    public enum Role {
        MANAGER (0.3),
        EXECUTIVE (0.2),
        STAFF(0.1);

        private final Double percentage;

        Role(Double percentage) {
            this.percentage = percentage;
        }

        public Double getPercentage(){ return percentage;}
    }

    public void paySalary(Employee employee) {
        StringBuilder builder = new StringBuilder();
        if (employee.getRole() == Employee.Role.MANAGER) {
            builder.append("The salary of the manager " + employee.getSurName() +
                    employee.getGivenName() + " in the amount of $" +
                    managerSalary.toString() + " was paid.");
        } else if (employee.getRole() == Employee.Role.EXECUTIVE) {
            builder.append("The salary of the executive " + employee.getSurName() +
                    employee.getGivenName() + " in the amount of $" +
                    executiveSalary.toString() + " was paid.");
        } else {
            builder.append("The salary of the staff " + employee.getSurName() +
                    employee.getGivenName() + " in the amount of $" +
                    staffSalary.toString() + " was paid.");
        }
        System.out.println(builder.toString());
    }

    public void payPremium(Employee employee) {
        StringBuilder builder = new StringBuilder();
        if (employee.getRole() == Employee.Role.MANAGER) { // 30%
            builder.append("The salary of the manager " + employee.getSurName() +
                    employee.getGivenName() + " in the amount of $");
            builder.append((managerSalary * Role.MANAGER.percentage));
            builder.append(" was paid.");
        } else if (employee.getRole() == Employee.Role.EXECUTIVE) { // 20%
            builder.append("The salary of the executive " + employee.getSurName() +
                    employee.getGivenName() + " in the amount of $");
            builder.append((managerSalary * Role.EXECUTIVE.percentage));
            builder.append(" was paid.");
        } else { // 10%
            builder.append("The salary of the staff " + employee.getSurName() +
                    employee.getGivenName() + " in the amount of $");
            builder.append((managerSalary * Role.STAFF.percentage));
            builder.append(" was paid.");
        }
        System.out.println(builder.toString());
    }
}
