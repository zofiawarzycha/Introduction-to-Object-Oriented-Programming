public class Medic extends CrewMember {

    private String medicalSpecialty;

    public Medic(String name, int age, String specialization, double missionHours, String medicalSpecialty) {
        super(name, age, Role.MEDIC, specialization, missionHours);
        this.medicalSpecialty = medicalSpecialty;
    }

    public String getMedicalSpecialty() { return medicalSpecialty; }

    public void treatPatient(String patientName) {
        System.out.println(getName() + " is treating " + patientName
                + " using their expertise in " + medicalSpecialty + ".");
    }
}
