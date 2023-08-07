class Teacher {
    private String name;
    private float baseSalary;
    private int experienceYears;
    private boolean isFullTime;

    public Teacher(String name, float baseSalary, int experienceYears, boolean isFullTime) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.experienceYears = experienceYears;
        this.isFullTime = isFullTime;
    }

    public String getName() {
        return name;
    }

    public float calculateSalary() {
        if (isFullTime) {
            return (float) (baseSalary * (1 + 0.1 * experienceYears));
        } else {
            return baseSalary;
        }
    }
}