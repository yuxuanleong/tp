package seedu.address.model.student;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Student}'s {@code Name} matches any of the keywords given.
 */
public class StuNameContainsKeywordsPredicate implements Predicate<Student> {
    private final List<String> keywords;

    public StuNameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Student student) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(student.getName().fullName, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof StuNameContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((StuNameContainsKeywordsPredicate) other).keywords)); // state check
    }

}
