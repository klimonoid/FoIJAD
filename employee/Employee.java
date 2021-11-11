package employee;

import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class Employee {
    private String givenName;
    private String surName;
    private Integer age;
    private Gender gender;
    private Role role;
    private Integer salary;
    private String dept;
    private String mail;
    private String phone;
    private String address;
    private String city;
    private String state; // область
    private Integer code; // (код области)

    public Employee(EmployeeBuilder employeeBuilder) {
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

    public Integer getSalary() {
        return salary;
    }

    public void setRole(Integer salary) {
        this.salary = salary;
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

    public static class EmployeeBuilder {
        private String givenName;
        private String surName;
        private Integer age;
        private Gender gender;
        private Role role;
        private  Integer salary;
        private String dept;
        private String mail;
        private String phone;
        private String address;
        private String city;
        private String state; // область
        private Integer code; // (код области);

        public EmployeeBuilder() { }

        public EmployeeBuilder givenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public EmployeeBuilder surName(String surName) {
            this.surName = surName;
            return this;
        }

        public EmployeeBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public EmployeeBuilder gender(employee.Gender gender) {
            this.gender = gender;
            return this;
        }

        public EmployeeBuilder role(employee.Role role) {
            this.role = role;
            return this;
        }

        public EmployeeBuilder salary(Integer salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeBuilder mail(String mail) {
            this.mail = mail;
            return this;
        }

        public EmployeeBuilder dept(String dept) {
            this.dept = dept;
            return this;
        }

        public EmployeeBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public EmployeeBuilder address(String address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder city(String city) {
            this.city = city;
            return this;
        }

        public EmployeeBuilder state(String state) {
            this.state = state;
            return this;
        }

        public EmployeeBuilder code(Integer code) {
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
            return (Pattern.matches("[A-Z][a-z]+", givenName) && // начинается с большой буквы, а дальше маленькие
                    Pattern.matches("[A-Z][a-z]+", surName) &&
                    age >=18 && gender != null && role != null &&
                    dept != null &&
                    Pattern.matches("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$", mail)
                    && Pattern.matches("(\\+7|7|8)([0-9]){10}", phone));
            // остальные параметры необязательны
        }
    }

    public static List<Employee> createShortList() {
        List<Employee> shortList = new ArrayList<>();

        shortList.add(new EmployeeBuilder()
                .givenName("Klim")
                .surName("Fedorov")
                .age(45)
                .gender(Gender.MALE)
                .role(Role.MANAGER)
                .salary(3000)
                .dept("Java")
                .mail("klim.fedorov@firma.ru")
                .phone("+71234567890")
                .address("Granatniy st. 11")
                .city("Moscow")
                .state("Moscow")
                .code(123001)
                .build()
        );
        shortList.add(new EmployeeBuilder()
                .givenName("Nil")
                .surName("Polsky")
                .age(30)
                .gender(Gender.MALE)
                .role(Role.STAFF)
                .salary(1000)
                .dept("Java")
                .mail("nil.polsky@firma.ru")
                .phone("+74561237890")
                .address("Oktiabrskaya st. 13")
                .city("Krasnogorsk")
                .state("Moscow area")
                .code(123456)
                .build()
        );
        shortList.add(new EmployeeBuilder()
                .givenName("Daria")
                .surName("Ignasheva")
                .age(35)
                .gender(Gender.FEMALE)
                .role(Role.EXECUTIVE)
                .salary(2000)
                .dept("C++")
                .mail("daria.ignasheva@firma.ru")
                .phone("+77894561230")
                .address("Moskovskaya st. 118")
                .city("Tver")
                .state("Tver area")
                .code(456123)
                .build()
        );
        shortList.add(new EmployeeBuilder()
                .givenName("Daria")
                .surName("Pankratova")
                .age(20)
                .gender(Gender.FEMALE)
                .role(Role.EXECUTIVE)
                .salary(2000)
                .dept("C++")
                .mail("daria.pankratova@firma.ru")
                .phone("+79456123660")
                .address("Ostrovskiy st. 64")
                .city("Kazan")
                .state("Republic of Tatarstan")
                .code(412356)
                .build()
        );
        shortList.add(new EmployeeBuilder()
                .givenName("Vladimir")
                .surName("Shubkin")
                .age(40)
                .gender(Gender.MALE)
                .role(Role.MANAGER)
                .salary(3000)
                .dept("C#")
                .mail("vladimir.shubkin@firma.ru")
                .phone("+79456321660")
                .address("School st. 2")
                .city("Barnaul")
                .state("Altai region")
                .code(432156)
                .build()
        );
        shortList.add(new EmployeeBuilder()
                .givenName("Tatiana")
                .surName("Volik")
                .age(45)
                .gender(Gender.FEMALE)
                .role(Role.MANAGER)
                .salary(3000)
                .dept("Art")
                .mail("tatiana.volik@firma.ru")
                .phone("+79456321660")
                .address("Severnaya St. 3")
                .city("Alushta")
                .state("Republic of Crimea")
                .code(432516)
                .build()
        );
        shortList.add(new EmployeeBuilder()
                .givenName("Svetlana")
                .surName("Anyuhina")
                .age(25)
                .gender(Gender.FEMALE)
                .role(Role.STAFF)
                .salary(1000)
                .dept("Art")
                .mail("svetlana.aniuhina@firma.ru")
                .phone("+79456326088")
                .address("Bolshaya Polianka St. 5")
                .city("Moscow")
                .state("Moscow")
                .code(453216)
                .build()
        );
        return shortList;
    }
}


