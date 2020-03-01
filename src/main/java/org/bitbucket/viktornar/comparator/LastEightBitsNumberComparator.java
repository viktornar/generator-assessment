package org.bitbucket.viktornar.comparator;

import org.apache.commons.lang3.StringUtils;
import org.bitbucket.viktornar.generator.NumberGenerator;

public class LastEightBitsNumberComparator extends NumberComparator {
    @Override
    public int compare(NumberGenerator left, NumberGenerator right) {
        var leftPart = StringUtils.right(left.toBinaryString(), 8);
        var rightPart = StringUtils.right(right.toBinaryString(), 8);
        return leftPart.compareTo(rightPart);
    }

    @Override
    public boolean match(NumberGenerator left, NumberGenerator right) {
        return compare(left, right) == 0;
    }
}
