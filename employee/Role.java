package employee;

public enum Role{
    MANAGER (0.3),
    EXECUTIVE (0.2),
    STAFF(0.1);

    private final Double percentage;

    Role(Double percentage) {
        this.percentage = percentage;
    }

    public Double getPercentage(){ return percentage;}

}