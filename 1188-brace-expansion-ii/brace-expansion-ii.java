class Solution {
    public List<String> braceExpansionII(String expression) {
        int[] index = new int[]{0};
        List<String> rawResult = parseExpression(expression, index);
        
        // Use a TreeSet to automatically remove duplicates and sort alphabetically
        Set<String> uniqueSortedWords = new TreeSet<>(rawResult);
        return new ArrayList<>(uniqueSortedWords);
    }

    private List<String> parseExpression(String expr, int[] index) {
        // Start with a base list containing an empty string for cartesian product multiplication
        List<String> currentWords = new ArrayList<>();
        currentWords.add("");

        while (index[0] < expr.length() && expr.charAt(index[0]) != '}' && expr.charAt(index[0]) != ',') {
            if (expr.charAt(index[0]) == '{') {
                index[0]++; // Skip '{'
                List<String> innerOptions = new ArrayList<>();

                // Accumulate all comma-separated possibilities inside the current brace group
                while (true) {
                    innerOptions.addAll(parseExpression(expr, index));
                    if (index[0] < expr.length() && expr.charAt(index[0]) == ',') {
                        index[0]++; // Skip ',' and continue parsing the next group option
                    } else if (index[0] < expr.length() && expr.charAt(index[0]) == '}') {
                        index[0]++; // Skip '}' and stop processing options
                        break;
                    }
                }

                // Concatenate current running words with the new options parsed inside the braces
                List<String> nextCombinations = new ArrayList<>();
                for (String word : currentWords) {
                    for (String option : innerOptions) {
                        nextCombinations.add(word + option);
                    }
                }
                currentWords = nextCombinations;

            } else {
                // Parse a literal lowercase character
                char c = expr.charAt(index[0]);
                index[0]++;
                
                List<String> nextCombinations = new ArrayList<>();
                for (String word : currentWords) {
                    nextCombinations.add(word + c);
                }
                currentWords = nextCombinations;
            }
        }

        return currentWords;
    }
}