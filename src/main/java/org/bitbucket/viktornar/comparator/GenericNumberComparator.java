package org.bitbucket.viktornar.comparator;

import org.apache.commons.lang3.NotImplementedException;
import org.bitbucket.viktornar.comparator.type.ComparatorType;
import org.bitbucket.viktornar.generator.NumberGenerator;

public class GenericNumberComparator extends NumberComparator {
    private NumberComparator numberComparator;

    public GenericNumberComparator(ComparatorType comparatorType) {
        if (comparatorType == ComparatorType.LAST_EIGHT_BITS) {
            numberComparator = new LastEightBitsNumberComparator();
        } else {
            throw new NotImplementedException("Comparator is not implemented");
        }
    }

    @Override
    public boolean match(NumberGenerator left, NumberGenerator right) {
        return numberComparator.match(left, right);
    }
}
