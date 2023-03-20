package seedu.patientist.model.person.patient;

import java.util.Set;

import seedu.patientist.model.person.Address;
import seedu.patientist.model.person.Email;
import seedu.patientist.model.person.IdNumber;
import seedu.patientist.model.person.Name;
import seedu.patientist.model.person.Person;
import seedu.patientist.model.person.Phone;
import seedu.patientist.model.tag.Tag;

/**
 * Represents a patient object in Patientist
 * Guarantees: superclass guarantees, and details is non null. If none provided, details is blank.
 * TODO: need to guarantee validity of patient id in the PatientIdNumber class
 */
public class Patient extends Person {
    public static final Tag PATIENT_TAG = new Tag("Patient");
    private PatientStatusDetails details;

    /**
     * Every field must be present and not null.
     */
    public Patient(Email email, Name name, Phone phone, IdNumber id, Address address, Set<Tag> tags) {
        super(name, phone, email, id, address, tags);
        this.details = new PatientStatusDetails();
    }

    /**
     * Every field must be present and not null.
     */
    public Patient(IdNumber id, Name name, Phone phone, Email email,
                   Address address, PatientStatusDetails details, Set<Tag> tags) {
        super(name, phone, email, id, address, tags);
        this.details = details;
    }

    /**
     * Updates the <code>details</code> field with the new <code>PatientStatusDetails</code>.
     */
    public void setPatientStatusDetails(PatientStatusDetails details) {
        this.details = details;
    }

    /**
     * Returns the <code>PatientStatusDetails</code> of this patient
     * @return <code>details</code>, the object representing the details of a patient's treatment
     */
    public PatientStatusDetails getPatientStatusDetails() {
        return this.details;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("; Details: ")
                .append(details.toString())
                .append("; Type: Patient ");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return getIdNumber().hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Patient)) {
            return false;
        }

        Patient otherPat = (Patient) other;
        return getIdNumber().equals(otherPat.getIdNumber()) && this.getName().equals(otherPat.getName());
    }

    /**
     * Compares 2 Person objects. The Patient class makes use of its <code>equals</code> method, which checks
     * equality between 2 <code>Patient</code>'s id numbers.
     * @param otherPatient the other <code>Person</code> object to be compared to.
     */
    @Override
    public boolean isSamePerson(Person otherPatient) {
        if (otherPatient == this) {
            return true;
        }

        if (!(otherPatient instanceof Patient)) {
            return false;
        }

        return super.isSamePerson(otherPatient);
    }

}
