package employee;

import javax.management.monitor.MonitorSettingException;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] strings)
    {
        testFunctionalInterfaces();
    }

    private static void testStreams2() {
        System.out.println("-----------------------------------------------------------------------------------------");
        List<Employee> listToTrain = Employee.createShortList();
        listToTrain.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");

        // MAP
        // get list of men mails without domains (cause they're all same)
        List<String> result1 = listToTrain.stream()
                .filter(employee -> employee.getGender() == Gender.MALE)
                .map(employee -> employee.getMail().substring(0, employee.getMail().indexOf("@")))
                .collect(Collectors.toList());
        result1.forEach(System.out::println);
        listToTrain.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");

        // pay 10% bonus to employees that are over 40 years old
        List<Double> result2 = listToTrain.stream()
                .filter(employee -> employee.getAge() > 40)
                .map(employee -> employee.getSalary() * 0.1)
                .collect(Collectors.toList());
        result2.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");

        //PEEK
        // output the salary and the Role of women employees from Moscow
        List<Employee> result3 = listToTrain.stream()
                .filter(employee -> employee.getGender().equals(Gender.MALE) &&
                        employee.getCity() == "Moscow")
                .peek(employee -> System.out.println(
                        employee.getGivenName() + " has salary: " +
                                employee.getSalary() + " and works as " + employee.getRole()
                ))
                .collect(Collectors.toList());
        result3.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");

        // output address of Executive's
        List<Employee> result4 = listToTrain.stream()
                .filter(employee -> employee.getRole() == Role.EXECUTIVE)
                .peek(employee -> System.out.println(
                        employee.getGivenName() + " " + employee.getSurName() +
                                " is living in " + employee.getState() + " " + employee.getCity() +
                                " " + employee.getAddress()
                ))
                .collect(Collectors.toList());
        result3.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");

        // FIND_FIRST and AVERAGE
        // find the first male employee from Moscow whose age in less than average
        double avgAge = listToTrain.stream().mapToDouble(Employee::getAge).average().orElse(0.0);
        System.out.println("The average age of employee is " + avgAge);
        Employee youngMoscowEmployee = listToTrain.stream()
                .filter(employee -> employee.getCity() == "Moscow" &&
                        employee.getAge() < avgAge)
                .findFirst().orElse(null);
        System.out.println(youngMoscowEmployee);
        System.out.println("-----------------------------------------------------------------------------------------");

        // find the first female whose salary is higher than average male salary
        double avgMaleSalary = listToTrain.stream()
                .filter(employee -> employee.getGender() == Gender.MALE)
                .mapToDouble(Employee::getSalary).average().orElse(0.0);
        System.out.println("The average salary of male employee's is " + avgMaleSalary);
        Employee richFemaleEmployee = listToTrain.stream()
                .filter(employee -> employee.getGender() == Gender.FEMALE &&
                        employee.getSalary() > avgMaleSalary)
                .findFirst().orElse(null);
        System.out.println(youngMoscowEmployee);
        System.out.println("-----------------------------------------------------------------------------------------");

        // SUM
        Integer needToPay = listToTrain.stream()
                .mapToInt(Employee::getSalary)
                .sum();
        System.out.println("Company need to pay " + needToPay);
        System.out.println("-----------------------------------------------------------------------------------------");

        // MIN and MAX
        // Minimum postal code
        Employee minPostCodeEmployee = listToTrain.stream()
                .min(Comparator.comparing(Employee::getCode)).orElse(null);

        System.out.println("MIN: " + minPostCodeEmployee);
        Employee maxPostCodeEmployee = listToTrain.stream()
                .max(Comparator.comparing(Employee::getCode)).orElse(null);

        System.out.println("MAX:" + maxPostCodeEmployee);
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    private static void testStreams1() {
        List<Employee> employeeList = Employee.createShortList();
        Accountant payer = new Accountant();

        // Выплата премии женщинам сотрудникам
        Stream<Employee> stream = employeeList.stream();
        stream.filter(x -> x.getGender() == Gender.FEMALE).forEach(payer::payPremium);
        // Выплата зарплаты сотрудникам определенного департамента
        stream = employeeList.stream();
        stream.filter(x -> x.getDept().equals("Java")).forEach(payer::paySalary);
        // Выплата премии сотрудникам старше 30, работающим в определенном департаменте
        stream = employeeList.stream();
        stream.filter(x -> x.getAge() > 30).forEach(payer::payPremium);
        // Выплата зарплаты менеджерам
        stream = employeeList.stream();
        stream.filter(x -> x.getRole() == Role.MANAGER).forEach(payer::paySalary);
        // Выплата премии стаффу
        stream = employeeList.stream();
        stream.filter(x -> x.getRole() == Role.STAFF).forEach(payer::payPremium);
    }

    private static void testFunctionalInterfaces() {
        List<Employee> employeeList = Employee.createShortList();

        // Приветствие для сотрудника
        Consumer<Employee> greetings = employee -> System.out.println("Greetings to " + employee.getSurName() +
                " " + employee.getGivenName());

        // Номер дома сотрудника
        Function<Employee, Integer> getHouseNumber = employee -> {
            String[] tmp = employee.getAddress().split(" ");
            return Integer.valueOf(tmp[tmp.length - 1]);
        };

        // Получить случайного работника
        Supplier<Employee> randomEmployee = () -> {
            Integer index = (int) (Math.random() * employeeList.size());
            return employeeList.get(index);
        };

        // Указанные сотрудники работают в одном отделе?
        BiPredicate<Employee, Employee> sameDept = (emp1, emp2) -> emp1.getDept().equals(emp2.getDept());


        Employee emp1 = randomEmployee.get();
        System.out.println(emp1);
        greetings.accept(emp1);
        System.out.println(getHouseNumber.apply(emp1));
        Employee emp2 = randomEmployee.get();
        System.out.println(emp2);
        System.out.println(sameDept.test(emp1, emp2));
    }
}
