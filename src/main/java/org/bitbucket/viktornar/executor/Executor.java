package org.bitbucket.viktornar.executor;

import org.bitbucket.viktornar.comparator.NumberComparator;
import org.bitbucket.viktornar.generator.NumberGenerator;

import static org.bitbucket.viktornar.Constants.DEFAULT_COMPARE_CYCLE_COUNT;

public class Executor {
    private NumberGenerator leftNumberGenerator;
    private NumberGenerator rightNumberGenerator;
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
        int count = 0;
        for (int i = 0; i < cycleCount; i++) {
            leftNumberGenerator = leftNumberGenerator.nextGenerator();
            rightNumberGenerator = rightNumberGenerator.nextGenerator();

            if (
                    numberComparator.match(
                            leftNumberGenerator,
                            rightNumberGenerator
                    )
            ) {
                count += 1;
            }
        }
        return count;
    }

    public int compare() {
        return compare(DEFAULT_COMPARE_CYCLE_COUNT);
    }
}
