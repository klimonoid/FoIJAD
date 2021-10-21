package employee;

import java.util.regex.Pattern;
import employee.Employee.*;

public class Director {
    private EmployeeBuilder builder;

    public Director(EmployeeBuilder builder) {
        super();
        this.builder = builder;
        if (this.builder == null) {
            throw new IllegalArgumentException("Automotive Engineer can't work without Car Builder!");
        }
    }

    public Employee makeEmployee(String givenName, String surName, Integer age,
                              Gender gender, Role role, String dept, String mail,
                              String phone, String address, String city,
                              String state, Integer code) {
         builder.givenName(givenName).surName(surName).age(age).gender(gender)
                .role(role).dept(dept).mail(mail).phone(phone)
                .address(address).city(city).state(state).code(code);
         return builder.build();
    }
}
