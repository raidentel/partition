package fr.hilmi.partition;

import java.util.ArrayList;
import java.util.List;

/**
 * Partition class implements the method of partitioning
 */
public class Partition {

    /**
     * This Method implement the function of partitioning, takes a object list and partitionSize.
     * @param list
     * @param partitionSize
     * @return List<List<Object>>
     */
    public List<List<Object>> partition(List<Object> list, int partitionSize) {

        // Test if the list is null to avoid the null pointer when calling list.size()
        if(list == null){
            throw new IllegalArgumentException("List is null ");
        }

        // PartitionSize can't be equal to zero cause it's a quotient.
        if(partitionSize == 0){
            throw new IllegalArgumentException("PartitionSize can't be equal to 0 ");
        }

        // Get size of the list.
        final int size = list.size();

        // In that case i choose to throw an exception, other cases could return the same list.
        if (size < partitionSize) {
            throw new IllegalArgumentException("Size < partitionSize ");
        }

        // Get possible number of partitions: by evaluation the division + remaining.
        final int numberOfPartitions = ((int) (size / partitionSize)) + (size % partitionSize);

        // Prepare the resultList that will contains partitions.
        final List<List<Object>> listResultat = new ArrayList<>(numberOfPartitions);

        // iterate with i + partitionSize step and create sub-lists
        for (int i = 0; i < size; i = i + partitionSize) {
            listResultat.add(list.subList(i, Math.min(i + partitionSize, size)));
        }

        // Simple console log.
        System.out.println(listResultat);

        return listResultat;
    }
}
