package employee;

public interface EmployeeBuilder {

    public ClassicEmployeeBuilder givenName(String givenName);

    public ClassicEmployeeBuilder surName(String surName);

    public ClassicEmployeeBuilder age(Integer age);

    public ClassicEmployeeBuilder gender(Employee.Gender gender);

    public ClassicEmployeeBuilder role(Employee.Role role);

    public ClassicEmployeeBuilder mail(String mail);

    public ClassicEmployeeBuilder dept(String dept);

    public ClassicEmployeeBuilder phone(String phone);

    public ClassicEmployeeBuilder address(String address);

    public ClassicEmployeeBuilder city(String city);

    public ClassicEmployeeBuilder state(String state);

    public ClassicEmployeeBuilder code(Integer code);

    public Employee build();
}
