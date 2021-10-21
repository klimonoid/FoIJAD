package employee;

import employee.Employee.*;
import java.util.regex.Pattern;

public class ClassicEmployeeBuilder implements EmployeeBuilder {
    protected String givenName;
    protected String surName;
    protected Integer age;
    protected Employee.Gender gender;
    protected Employee.Role role;
    protected String dept;
    protected String mail;
    protected String phone;
    protected String address;
    protected String city;
    protected String state; // область
    protected Integer code; // (код области);

    public ClassicEmployeeBuilder() {
        super();
    }

    public ClassicEmployeeBuilder givenName(String givenName) {
        this.givenName = givenName;
        return this;
    }

    public ClassicEmployeeBuilder surName(String surName) {
        this.surName = surName;
        return this;
    }

    public ClassicEmployeeBuilder age(Integer age) {
        this.age = age;
        return this;
    }

    public ClassicEmployeeBuilder gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public ClassicEmployeeBuilder role(Role role) {
        this.role = role;
        return this;
    }

    public ClassicEmployeeBuilder mail(String mail) {
        this.mail = mail;
        return this;
    }

    public ClassicEmployeeBuilder dept(String dept) {
        this.dept = dept;
        return this;
    }

    public ClassicEmployeeBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public ClassicEmployeeBuilder address(String address) {
        this.address = address;
        return this;
    }

    public ClassicEmployeeBuilder city(String city) {
        this.city = city;
        return this;
    }

    public ClassicEmployeeBuilder state(String state) {
        this.state = state;
        return this;
    }

    public ClassicEmployeeBuilder code(Integer code) {
        this.code = code;
        return this;
    }

    public Employee build() {
        Employee emp = null;
        if (validateEmployee()) {
            emp = new Employee(this);
        } else {
            System.out.println("Sorry! Employee objects can't be build without required details");
        }
        return emp;
    }

    private boolean validateEmployee() {
//        System.out.println(givenName);
//        System.out.println(Pattern.matches("[A-Z][a-z]+", givenName));
//        System.out.println(surName);
//        System.out.println(Pattern.matches("[A-Z][a-z]+", surName));
//        System.out.println(dept);
//        System.out.println(Pattern.matches("[A-Z][a-z]+", dept));
//        System.out.println(mail);
//        System.out.println(Pattern.matches("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$", mail));
//        System.out.println(phone);
//        System.out.println(Pattern.matches("(\\+7|7|8)([0-9]){10}", phone));

        return (Pattern.matches("[A-Z][a-z]+", givenName) && // начинается с большой буквы, а дальше маленькие
                Pattern.matches("[A-Z][a-z]+", surName) &&
                age >=18 && gender != null && role != null &&
                dept != null &&
                Pattern.matches("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$", mail)
                && Pattern.matches("(\\+7|7|8)([0-9]){10}", phone));
                // остальные параметры необязательны
    }
}
