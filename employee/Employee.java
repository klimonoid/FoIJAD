package employee;

import java.lang.StringBuilder;

public class Employee {
    private String givenName;
    private String surName;
    private Integer age;
    private Gender gender;
    private Role role;
    private String dept;
    private String mail;
    private String phone;
    private String address;
    private String city;
    private String state; // область
    private Integer code; // (код области)

    public Employee(ClassicEmployeeBuilder employeeBuilder) {
        if (employeeBuilder == null) {
            throw new IllegalArgumentException("Please provide employee builder to build employee object.");
        }
        this.givenName = employeeBuilder.givenName;
        this.surName = employeeBuilder.surName;
        this.age = employeeBuilder.age;
        this.gender = employeeBuilder.gender;
        this.role = employeeBuilder.role;
        this.dept = employeeBuilder.dept;
        this.mail = employeeBuilder.mail;
        this.phone = employeeBuilder.phone;
        this.address = employeeBuilder.address;
        this.city = employeeBuilder.city;
        this.state = employeeBuilder.state;
        this.code = employeeBuilder.code;
    }

    public enum Gender {
        MALE, FEMALE
    }

    public enum Role{
        STAFF, MANAGER, EXECUTIVE
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String Mail) {
        this.mail = Mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString () {
        StringBuilder builder = new StringBuilder();
        builder.append("Employee [givenName=").append(givenName).append(", surname=").append(surName)
                .append(", age=").append(age).append(", gender=").append(gender).append(", role=")
                .append(role).append(", dept=").append(dept).append(", mail=").append(mail)
                .append(", phone=").append(phone).append(", address=").append(address).append(", city=")
                .append(city).append(", state=").append(state).append(", code=").append(code);
        return builder.toString();
    }

}
