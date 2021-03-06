package employee;

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

        // PEEK + MAP
        // get list of men mails without domains (cause they're all same) and output their phone numbers
        List<String> result1 = listToTrain.stream()
                .filter(employee -> employee.getGender() == Gender.MALE)
                .peek(employee -> System.out.println(
                        "Phone number of " + employee.getPhone() +
                                " " + employee.getAddress()
                ))
                .map(employee -> employee.getMail().substring(0, employee.getMail().indexOf("@")))
                .collect(Collectors.toList());
        result1.forEach(System.out::println);
        listToTrain.forEach(System.out::println);

        // output the salary and the Role of women employees from Moscow and get
        List<String> result3 = listToTrain.stream()
                .filter(employee -> employee.getGender().equals(Gender.MALE) &&
                        employee.getCity().equals("Moscow"))
                .peek(employee -> System.out.println(
                        employee.getGivenName() + " has salary: " +
                                employee.getSalary() + " and works as " + employee.getRole()
                ))
                .map(Employee::getAddress)
                .collect(Collectors.toList());
        result3.forEach(System.out::println);

        // FIND_FIRST and AVERAGE
        // find the first male employee from Moscow whose age in less than average
        double avgAge = listToTrain.stream().mapToDouble(Employee::getAge).average().orElse(0.0);
        System.out.println("The average age of employee is " + avgAge);
        Employee youngMoscowEmployee = listToTrain.stream()
                .filter(employee -> employee.getCity().equals("Moscow") &&
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
        System.out.println(richFemaleEmployee);
        System.out.println("-----------------------------------------------------------------------------------------");

        // SUM
        int needToPay = listToTrain.stream()
                .mapToInt(Employee::getSalary)
                .sum();
        System.out.println("Company need to pay " + needToPay);
        System.out.println("-----------------------------------------------------------------------------------------");

        int payToArtists= listToTrain.stream()
                .filter(employee -> employee.getDept().equals("Art"))
                .mapToInt(Employee::getSalary)
                .sum();
        System.out.println("Company need to pay to artists " + payToArtists);

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

        // ?????????????? ???????????? ???????????????? ??????????????????????
        Stream<Employee> stream = employeeList.stream();
        stream.filter(x -> x.getGender() == Gender.FEMALE).forEach(payer::payPremium);
        // ?????????????? ???????????????? ?????????????????????? ?????????????????????????? ????????????????????????
        stream = employeeList.stream();
        stream.filter(x -> x.getDept().equals("Java")).forEach(payer::paySalary);
        // ?????????????? ???????????? ?????????????????????? ???????????? 30, ???????????????????? ?? ???????????????????????? ????????????????????????
        stream = employeeList.stream();
        stream.filter(x -> x.getAge() > 30).forEach(payer::payPremium);
        // ?????????????? ???????????????? ????????????????????
        stream = employeeList.stream();
        stream.filter(x -> x.getRole() == Role.MANAGER).forEach(payer::paySalary);
        // ?????????????? ???????????? ????????????
        stream = employeeList.stream();
        stream.filter(x -> x.getRole() == Role.STAFF).forEach(payer::payPremium);
    }

    private static void testFunctionalInterfaces() {
        List<Employee> employeeList = Employee.createShortList();

        // ?????????????????????? ?????? ????????????????????
        Consumer<Employee> greetings = employee -> System.out.println("Greetings to " + employee.getSurName() +
                " " + employee.getGivenName());

        // ?????????? ???????? ????????????????????
        Function<Employee, Integer> getHouseNumber = employee -> {
            String[] tmp = employee.getAddress().split(" ");
            return Integer.valueOf(tmp[tmp.length - 1]);
        };

        // ???????????????? ???????????????????? ??????????????????
        Supplier<Employee> randomEmployee = () -> {
            int index = (int) (Math.random() * employeeList.size());
            return employeeList.get(index);
        };

        // ?????????????????? ???????????????????? ???????????????? ?? ?????????? ?????????????
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
