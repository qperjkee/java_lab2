public class App {
    private static boolean isConsonant(char c) {
        c = Character.toLowerCase(c);
        return "bcdfghjklmnpqrstvwxyz".indexOf(c) != -1;
    }

    public static StringBuffer removeWords(StringBuffer text, int wordLength) {
        StringBuffer result = new StringBuffer();
        StringBuffer word = new StringBuffer();
        char punctuation = '\0';
    
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
    
            if (".,!?".indexOf(currentChar) != -1) {
                punctuation = currentChar;
            }
    
            if (Character.isWhitespace(currentChar) || i == text.length() - 1) {
                if (i == text.length() - 1 && !Character.isWhitespace(currentChar) && ".,!?".indexOf(currentChar) == -1) {
                    word.append(currentChar);
                }
    
                if (!(word.length() == wordLength && isConsonant(word.charAt(0)))) {
                    result.append(word);
                    if (punctuation != '\0') {
                        result.append(punctuation);
                    }
                    result.append(" ");
                }
    
                word.setLength(0);
                punctuation = '\0';
            } else if (".,!?".indexOf(currentChar) == -1) { 
                word.append(currentChar);
            }
        }
    
        return result;
    }
    
    
    public static void main(String[] args) {
        String inputText = "lorem ipsum dolor sit bmet consectetur adipiscing, sed diam, non commod tempor. Ut enim ad minim veniam, quis nostr? dolor in cupa, qui - officia";
        int wordLength = 4;

        StringBuffer textBuffer = new StringBuffer(inputText);

        StringBuffer processedText = removeWords(textBuffer, wordLength);

        System.out.println("Original text: " + inputText);
        System.out.println("Filtered text: " + processedText.toString().trim());
    }
}
