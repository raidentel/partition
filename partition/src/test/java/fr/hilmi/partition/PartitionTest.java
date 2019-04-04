package fr.hilmi.partition;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Partition test class using Junit below Mockito. cause Mockito give more interesting functions.
 */
@RunWith(MockitoJUnitRunner.class)
public class PartitionTest {

    /**
     * Partition class injection for the execution.
     */
    @InjectMocks
    private Partition partition;

    /**
     * Nominal test.
     */
    @Test
    public void partition() {

        // Init
        final List<Object> list = Lists.newArrayList(1, 2, 3, 4, 5);
        final int partitionSize = 2;

        // Execution
        final List<List<Object>> result = partition.partition(list, partitionSize);

        // Verification
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(3);
        assertThat(result).isEqualTo(Lists.newArrayList(
                Lists.newArrayList(1, 2),
                Lists.newArrayList(3, 4),
                Lists.newArrayList(5)));

    }


    @Test(expected = IllegalArgumentException.class)
    public void partition_whenListIsNull_mustThrowIllegalArgumentException() {

        // Init
        final List<Object> list = null;
        final int partitionSize = 2;

        // Execution // Verification
        partition.partition(list, partitionSize);

    }

    @Test(expected = IllegalArgumentException.class)
    public void partition_whenPatitionSizeIsZero_mustThrowIllegalArgumentException() {

        // Init
        final List<Object> list = Lists.newArrayList(1, 2, 3, 4);
        final int partitionSize = 0;

        // Execution // Verification
        partition.partition(list, partitionSize);

    }

    @Test(expected = IllegalArgumentException.class)
    public void partition_whenPatitionSizeIsGreaterThanListSize_mustThrowIllegalArgumentException() {

        // Init
        final List<Object> list = Lists.newArrayList(1, 2, 3, 4);
        final int partitionSize = 25;

        // Execution // Verification
        partition.partition(list, partitionSize);

    }

}