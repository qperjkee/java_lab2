public class App {
    private static boolean isConsonant(char c) {
        c = Character.toLowerCase(c);
        return "bcdfghjklmnpqrstvwxyz".indexOf(c) != -1;
    }
    
    public static StringBuffer removeWords(StringBuffer text, int wordLength) {
        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null.");
        }
        if (wordLength <= 0) {
            throw new IllegalArgumentException("Word length must be greater than 0.");
        }
    
        StringBuffer result = new StringBuffer();
        StringBuffer word = new StringBuffer();
        char punctuation = '\0';
        boolean wordAdded = false;
        
        try {
            for (int i = 0; i < text.length(); i++) {
                char currentChar = text.charAt(i);
    
                if (".,!?".indexOf(currentChar) != -1) {
                    punctuation = currentChar;
                    continue;
                }
    
                if (Character.isWhitespace(currentChar) || i == text.length() - 1) {
                    if (i == text.length() - 1 && !Character.isWhitespace(currentChar)) {
                        word.append(currentChar);
                    }
    
                    if (word.length() > 0) {
                        if (!(word.length() == wordLength && isConsonant(word.charAt(0)))) {
                            if (wordAdded) {
                                result.append(" ");
                            }
                            result.append(word);
                            wordAdded = true;
                        }
    
                        if (punctuation != '\0') {
                            result.append(punctuation);
                            punctuation = '\0';
                        }
                    }
    
                    word.setLength(0);
                } else {
                    word.append(currentChar);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Index out of bounds error occurred while processing the text: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    
        return result;
    }
    
    public static void main(String[] args) {
        try {
            String inputText = "lorem ipsum dolor sit bmet consectetur adipiscing, sed diam, non commod tempor. Ut enim ad minim veniam, quis nostr? dolor in cupa, qui - officia";
            int wordLength = 4;
    
            if (inputText == null || inputText.trim().isEmpty()) {
                throw new IllegalArgumentException("Input text cannot be null or empty.");
            }

            if (wordLength <= 0) {
                throw new IllegalArgumentException("Word length must be greater than 0.");
            }
    
            StringBuffer textBuffer = new StringBuffer(inputText);
            StringBuffer processedText = removeWords(textBuffer, wordLength);
    
            System.out.println("Original text: " + inputText);
            System.out.println("Filtered text: " + processedText.toString().trim());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred in main method: " + e.getMessage());
        }
    }
}
