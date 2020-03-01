package org.bitbucket.viktornar.executor;

import org.bitbucket.viktornar.comparator.NumberComparator;
import org.bitbucket.viktornar.generator.NumberGenerator;

public class Executor {
    private final NumberGenerator leftNumberGenerator;
    private final NumberGenerator rightNumberGenerator;
    private final NumberComparator numberComparator;

    public Executor(
            NumberGenerator aNumberGenerator,
            NumberGenerator bNumberGenerator,
            NumberComparator numberComparator
    ) {
        this.leftNumberGenerator = aNumberGenerator;
        this.rightNumberGenerator = bNumberGenerator;
        this.numberComparator = numberComparator;
    }

    public int compare(long cycleCount) {
        return 0;
    }

    public int compare() {
        return 0;
    }
}
