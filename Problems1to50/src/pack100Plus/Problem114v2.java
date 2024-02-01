package pack100Plus;

public class Problem114v2 {
	private static String result = "";
    
	
    public static void print(int[] partition, int length, int count) {
        // This loop will print the partition array
        for (int i = 0; i < length; i++) {
            //System.out.print(partition[i] + " ");
            result += '\n' + partition[i] + " ";
        }
        //System.out.println();
        result += '\n';
        
        int index;
        // This loop will check if all elements are 1
        for (index = 0; index < length; index++) {
            if (partition[index] == 1) {
                continue;
            } else {
                break;
            }
        }

        // If all elements are 1, it prints the final result
        if (index == length) {
            System.out.println("The number of ways to write a number as a sum of number smaller than itself is: " + (count - 1));
            result += '\n' + " Number of permutations: " + (count - 1);
        }
    }

    // This method generates unique partitions of a given number
    public static void generateUniquePartition(int number) {
        int[] partition = new int[number];
        int index = 0, count = 0;
        partition[index] = number;

        // This loop will continue until we find all partitions
        while (true) {
            count++;
            print(partition, index + 1, count);

            int remainingValue = 0;
            // This loop will handle the remaining value
            while (index >= 0 && partition[index] == 1) {
                remainingValue += partition[index];
                index--;
            }

            if (index < 0) {
                return;
            }

            partition[index]--;
            remainingValue++;

            // This loop will update the partition array
            while (remainingValue > partition[index]) {
                partition[index + 1] = partition[index];
                remainingValue -= partition[index];
                index++;
            }

            partition[index + 1] = remainingValue;
            index++;
        }
    }


    public static void main(String[] args) {

        int number = 7;
        // We call the method to generate unique partitions
        generateUniquePartition(number);
        
    }
}
