package employee;

import utils.Utils;
import utils.Utils.*;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] strings)
    {
        testFunctionalInterfaces();
    }

    private static void testStreams() {
        List<Employee> employeeList = Utils.createShortList();
        Accountant payer = new Accountant();

        // Выплата премии женщинам сотрудникам
        Stream<Employee> stream = employeeList.stream();
        stream.filter(x -> x.getGender() == Employee.Gender.FEMALE).forEach(payer::payPremium);
        // Выплата зарплаты сотрудникам определенного департамента
        stream = employeeList.stream();
        stream.filter(x -> x.getDept().equals("Java")).forEach(payer::paySalary);
        // Выплата премии сотрудникам старше 30, работающим в определенном департаменте
        stream = employeeList.stream();
        stream.filter(x -> x.getAge() > 30).forEach(payer::payPremium);
        // Выплата зарплаты менеджерам
        stream = employeeList.stream();
        stream.filter(x -> x.getRole() == Employee.Role.MANAGER).forEach(payer::paySalary);
        // Выплата премии стаффу
        stream = employeeList.stream();
        stream.filter(x -> x.getRole() == Employee.Role.STAFF).forEach(payer::payPremium);
    }

    private static void testFunctionalInterfaces() {
        List<Employee> employeeList = Utils.createShortList();

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
        BiPredicate<Employee, Employee> sameDept = (emp1, emp2) -> {
            return emp1.getDept().equals(emp2.getDept());
        };


        Employee emp1 = randomEmployee.get();
        System.out.println(emp1);
        greetings.accept(emp1);
        System.out.println(getHouseNumber.apply(emp1));
        Employee emp2 = randomEmployee.get();
        System.out.println(emp2);
        System.out.println(sameDept.test(emp1, emp2));
    }
}
