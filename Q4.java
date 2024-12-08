import java.util.*;

public class Flavours {

    // Function to count occurrences of each flavour
    private static Map<String, Integer> countFlavourOccurrences(List<String> flavours) {
        Map<String, Integer> flavourCountMap = new HashMap<>();
        for (String flavour : flavours) {
            flavourCountMap.put(flavour, flavourCountMap.getOrDefault(flavour, 0) + 1);
        }
        return flavourCountMap;
    }

    // Function to find the first flavour with an odd count
    private static String findFirstOddFlavour(List<String> flavours, Map<String, Integer> flavourCountMap) {
        for (String flavour : flavours) {
            if (flavourCountMap.get(flavour) % 2 != 0) {
                return flavour;
            }
        }
        return "All are even";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of flavours
        int numberOfFlavours = scanner.nextInt();
        scanner.nextLine(); 

        // Input: Flavours list
        List<String> flavours = new ArrayList<>();
        for (int i = 0; i < numberOfFlavours; i++) {
            flavours.add(scanner.nextLine().trim());
        }

        // Step 1: Count occurrences of each flavour
        Map<String, Integer> flavourCountMap = countFlavourOccurrences(flavours);
        String result = findFirstOddFlavour(flavours, flavourCountMap);
        System.out.println(result);

        scanner.close();
    }
}
