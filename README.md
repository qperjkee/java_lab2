# Project Description

This project processes a given text by removing words of a specified length that start with a consonant. It also handles punctuation attached to words and ensures proper exception handling for invalid inputs.

## Running the Project

To run the project, follow these steps:

1. Navigate to the `.\src\` directory:
    ```bash
    cd .\src\
    ```

2. Run the command to build and execute the program:
    ```bash
    .\buildrun.cmd App
    ```

## Description of Actions

After running the program, the following actions will be performed:
- Words that start with a consonant and have a specific length will be removed from the text.
- Punctuation marks directly following these words will also be removed.
- The program outputs the original text and the modified version where the specified words have been filtered.
