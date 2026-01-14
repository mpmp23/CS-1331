import java.util.*;
import java.io.File;

public class Histogram {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String fileName = input.next();
        System.out.println("Please provide a number of bins.");
        int binNumber = input.nextInt();

        // Now to parse the file and add it to an array list.
        Scanner fileScanner = new Scanner(new File(fileName));
        ArrayList<Integer> unsortedGrades = new ArrayList<>();
        while(fileScanner.hasNext()){
        try {
            int numberToAdd = fileScanner.nextInt();
            unsortedGrades.add(numberToAdd);
        } catch(InputMismatchException e) {
            fileScanner.next();
        }
    }
    System.out.println(unsortedGrades);


    int[] bins = new int[binNumber];
    int remainder = 101 % binNumber;
    int binWidth = 101 / binNumber;
    int firstWidth = remainder + binWidth;

    for(int i = 0; i < unsortedGrades.size(); i++){
        if(unsortedGrades.get(i) < (firstWidth - 1)){
            bins[0]++;
        }
        for(int n = 1; n < binNumber; n++){
            if((firstWidth + (n - 1) * binWidth) <= (unsortedGrades.get(i)) && (unsortedGrades.get(i)) <= (firstWidth + (n * binWidth - 1))) {
                bins[n]++;
            }
        }
    }
    System.out.println(Arrays.toString(bins));

    System.out.printf("0 - %d | %s\n", firstWidth - 1, "[]".repeat(bins[0]));
    for(int n = 1; n < binNumber; n++){
        System.out.printf("%d - %d | %s\n", firstWidth + (n - 1) * binWidth, firstWidth + (n * binWidth - 1), "[]".repeat(bins[n]));
    }
    

    }
}