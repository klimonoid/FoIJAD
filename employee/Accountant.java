package employee;


public class Accountant {

    public void paySalary(Employee employee) {
        StringBuilder builder = new StringBuilder();
        if (employee.getRole() == Role.MANAGER) {
            builder.append("The salary of the manager " + employee.getSurName() +
                    employee.getGivenName() + " in the amount of $" +
                    employee.getSalary().toString() + " was paid.");
        } else if (employee.getRole() == Role.EXECUTIVE) {
            builder.append("The salary of the executive " + employee.getSurName() +
                    employee.getGivenName() + " in the amount of $" +
                    employee.getSalary().toString() + " was paid.");
        } else {
            builder.append("The salary of the staff " + employee.getSurName() +
                    employee.getGivenName() + " in the amount of $" +
                    employee.getSalary().toString() + " was paid.");
        }
        System.out.println(builder.toString());
    }

    public void payPremium(Employee employee) {
        StringBuilder builder = new StringBuilder();
        if (employee.getRole() == Role.MANAGER) { // 30%
            builder.append("The salary of the manager " + employee.getSurName() +
                    employee.getGivenName() + " in the amount of $");
            builder.append((employee.getSalary() * Role.MANAGER.getPercentage()));
            builder.append(" was paid.");
        } else if (employee.getRole() == Role.EXECUTIVE) { // 20%
            builder.append("The salary of the executive " + employee.getSurName() +
                    employee.getGivenName() + " in the amount of $");
            builder.append((employee.getSalary() * Role.EXECUTIVE.getPercentage()));
            builder.append(" was paid.");
        } else { // 10%
            builder.append("The salary of the staff " + employee.getSurName() +
                    employee.getGivenName() + " in the amount of $");
            builder.append((employee.getSalary() * Role.STAFF.getPercentage()));
            builder.append(" was paid.");
        }
        System.out.println(builder.toString());
    }
}
