package seedu.patientist.logic.commands;

import static seedu.patientist.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.patientist.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.patientist.testutil.TypicalPersons.getTypicalPatientist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.patientist.model.Model;
import seedu.patientist.model.ModelManager;
import seedu.patientist.model.UserPrefs;
import seedu.patientist.model.person.Person;
import seedu.patientist.testutil.PersonBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalPatientist(), new UserPrefs());
    }

    @Test
    public void execute_newPerson_success() {
        Person validPerson = new PersonBuilder().build();

        Model expectedModel = new ModelManager(model.getPatientist(), new UserPrefs());
        expectedModel.addPerson(validPerson);

        assertCommandSuccess(new AddCommand(validPerson), model,
                String.format(AddCommand.MESSAGE_SUCCESS, validPerson), expectedModel);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Person personInList = model.getPatientist().getPersonList().get(0);
        assertCommandFailure(new AddCommand(personInList), model, AddCommand.MESSAGE_DUPLICATE_PERSON);
    }

}
