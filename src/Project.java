/***********************************************************************************************************************
 /* Project.java     Author: Hall, Sherica
 /* Date: April 6, 2024
 /***********************************************************************************************************************/

import java.util.Scanner;

    public class Project {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);   //Scanner object created to read user input

            // Prompts the user to put in a number
            System.out.print("Enter a number (Decimal or Binary) between 0 and 15: ");
            String userInput = scan.nextLine();  //Scans what is put in by user

            // Check if the input is a decimal or binary number
            if (isDecimal(userInput)) {
                // Convert decimal to binary
                int decimalNum = manualParseInt(userInput); //There is no function called manualParseInt and so one was created
                String binaryNum = customDecimalToBinary(decimalNum);  //There is no function called customDecimalToBinary and so one was created
                System.out.println("The user input a Decimal number " + decimalNum +
                        ", after conversion, the corresponding Binary number is " + binaryNum);

            } else if (isBinary(userInput)) {
                // Convert binary to decimal
                int decimalNum = customBinaryToDecimal(userInput);
                System.out.println("The user input a Binary number " + userInput +
                        ", after conversion, the corresponding Decimal number is " + decimalNum);

            } else {
                System.out.println("Invalid input! Please enter a valid Decimal or Binary number between 0 and 15.");
            }

            scan.close(); // Stops scanner object after value is converted
        }

        // Creating parseInt to convert string to integer
        public static int manualParseInt(String input) {
            int done = 0;  //Initialization
            for (int s = 0; s < input.length(); s++) {  //Loop
                char c = input.charAt(s);
                if (c >= '0' && c <= '9') {
                    done = done * 10 + (c - '0');  //Shifting digit left and adding numeric value of the current digit
                } else {
                    throw new NumberFormatException("Invalid input: " + input);
                }
            }
            return done;
        }

        // Converting decimal to binary instructions
        public static String customDecimalToBinary(int decimal) {
            StringBuilder binaryNum = new StringBuilder();  //StringBuilder is allowing for the number to be modified
            if (decimal == 0) {
                binaryNum.append(0);   //Adding 0 to the end of the StringBuilder
            } else {
                while (decimal > 0) {
                    binaryNum.insert(0, decimal % 2); //Inserts remainder of the division at the beginning of the binary StringBuilder object
                    decimal /= 2;
                }
            }
            return binaryNum.toString();
        }

        // Converting binary to decimal instructions
        public static int customBinaryToDecimal(String binaryNum) {
            int decimal = 0; //Initialization
            for (int s = 0; s < binaryNum.length(); s++) {  //Loop
                char c = binaryNum.charAt(s);
                if (c == '0' || c == '1') {
                    decimal = decimal * 2 + (c - '0'); //Shifting digits left and adding numeric value of the current binary digit
                } else {
                    throw new NumberFormatException("Invalid binary input: " + binaryNum);
                }
            }
            return decimal;
        }

        // Check if string is a valid decimal number between 0 and 15
        public static boolean isDecimal(String input) {
            try {
                int decimal = manualParseInt(input);
                return decimal >= 0 && decimal <= 15;  //Allows for numbers 0 - 15 only
            } catch (NumberFormatException e) {
                return false;
            }
        }

        // Check if string is a valid binary number between 0 and 15
        public static boolean isBinary(String input) {
            return input.matches("[01]+") && input.length() <= 4;  //Allows for binary numbers 2^0 - 2^3
        }
    }


