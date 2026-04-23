public class MedicalOfficer extends Officer {

    private String medicalSpecialty;

    public MedicalOfficer(String name, String rank, String department, int yearsOfExperience, String medicalSpecialty) {
        super(name, rank, department, yearsOfExperience);
        this.medicalSpecialty = medicalSpecialty;
    }
    public String getMedicalSpecialty() {
        return medicalSpecialty;
    }
    public void healCrewMember(String patientName) {
        System.out.println("Dr. " + getName() + " is treating " + patientName + " using their background in " + medicalSpecialty + ".");
    }
}