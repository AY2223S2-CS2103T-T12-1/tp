package seedu.patientist.logic.commands;

import seedu.patientist.model.Model;

import static java.util.Objects.requireNonNull;

public class ListWardsCommand extends Command {
    public static final String COMMAND_WORD = "lsward";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Lists all wards";

    public static final String MESSAGE_WARDS_LISTED_OVERVIEW = "%1$d wards listed!";
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        return new CommandResult(
                String.format(MESSAGE_WARDS_LISTED_OVERVIEW, model.getPatientist().getWardList().size()),
                -1, true, false, false);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        return other instanceof ListPatientsCommand; // instanceof handles nulls
    }
}
