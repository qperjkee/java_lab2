public class App {
    private static boolean isConsonant(char c) {
        c = Character.toLowerCase(c);
        return "bcdfghjklmnpqrstvwxyz".indexOf(c) != -1;
    }

    public static StringBuffer removeWords(StringBuffer text, int wordLength) {
        StringBuffer result = new StringBuffer();
        StringBuffer word = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (Character.isWhitespace(currentChar) || i == text.length() - 1) {
                if (i == text.length() - 1 && !Character.isWhitespace(currentChar)) {
                    word.append(currentChar);
                }

                if (!(word.length() == wordLength && isConsonant(word.charAt(0)))) {
                    result.append(word).append(" ");
                }

                word.setLength(0);
            } else {
                word.append(currentChar);
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        String inputText = "lorem ipsum dolor sit amet, consectetur adipiscing, sed diam non commod tempor.";
        int wordLength = 4;

        StringBuffer textBuffer = new StringBuffer(inputText);

        StringBuffer processedText = removeWords(textBuffer, wordLength);

        System.out.println("Original text: " + inputText);
        System.out.println("Filtered text: " + processedText.toString().trim());
    }
}
