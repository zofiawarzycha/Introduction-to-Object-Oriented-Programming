import java.util.UUID;

class Member {

    private UUID id;
    private String fullName;
    private int age;
    private boolean activeStatus;

    public Member(String fullName, int age, boolean activeStatus) {

        if (fullName == null || fullName.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be empty!");

        this.id = UUID.randomUUID();
        this.fullName = fullName;
        this.age = age;
        this.activeStatus = activeStatus;

    }
    public String getFullName() {
        return fullName;
    }
    public int getAge() {
        return age;
    }
    public boolean isActiveStatus() {
        return activeStatus;
    }
    @Override
    public String toString() {
        return "Member: " + fullName + ", age: " + age + ", activeStatus: " + activeStatus;
    }




}
