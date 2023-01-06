/**
 * *************************************************************
 * File:        Utilities.java (Class)
 * Author:      Thaveesha Dheerasekera; IIT ID: 2019483; UoW ID: w1761369
 * Contents:    Concurrent Programming Coursework (2022/23)
 * Description: This provides the utility functions and alert strings.
 * Date:        06-Jan-23
 * Version:     1.0
 * *************************************************************
 */

public class Utilities {
    // Alert messages
    final static String PRINTING_REQUEST_RECEIVED = "--- PRINTING REQUEST RECEIVED ---";
    final static String WAITING_FOR_PRINTING_RESOURCES = "--- WAITING FOR PRINTING RESOURCES ---";
    final static String PRINTING_DOC_DONE = "--- PRINTING DOCUMENTS DONE ---";
    final static String ENOUGH_PRINTING_RESOURCES = "--- ENOUGH PRINTING RESOURCES | OUT OF WAIT LOOP ---";
    final static String WAITING_FOR_PAPER_REQUEST = "--- ENOUGH PAPER DETECTED | WAITING FOR A REFILL REQUEST ---";
    final static String WAITING_FOR_TONER_REQUEST = "--- ENOUGH TONER DETECTED | WAITING FOR A REFILL REQUEST ---";
    final static String STUDENT_OUT = "--- STUDENT OUT ---";
    final static String TONER_REPLACE_REQUEST_RECEIVED = "--- TONER REPLACE REQUEST RECEIVED ---";
    final static String TONER_REPLACING = "--- TONER REPLACING ---";
    final static String TONER_REPLACE_DONE = "--- TONER REPLACE DONE ---";
    final static String TONER_REPLACE_REQUEST_PROCESSED = "--- TONER REPLACE REQUEST PROCESSED ---";
    final static String PAPER_REPLACE_REQUEST_RECEIVED = "--- PAPER REPLACE REQUEST RECEIVED ---";
    final static String PAPER_REPLACING = "--- PAPER REPLACING ---";
    final static String PAPER_REPLACE_DONE = "--- PAPER REPLACE DONE ---";
    final static String PAPER_REPLACE_REQUEST_PROCESSED = "--- PAPER REPLACE REQUEST PROCESSED ---";

    static int timeRandomizer() {
        int seconds = (int) (Math.random() * 1000);

        System.out.println("TIME: " + seconds);
        return seconds;
    }
}
