import java.util.Scanner;

//Use conditional statements to automate the decision-making process
public class DecisionMaker {

    //Get user's name for future outputs
    public static String getUserName(Scanner entry) {

        String nameEntered;

        System.out.print("Please enter your name: ");
        nameEntered = entry.nextLine();

        return nameEntered;

    }

    //Determine user's decision based on the integer entered
    public static String selectionType(int userEntry, String user){

        String output = "";

        //Display the associated result based on the integer range entered:
        if (userEntry % 2 != 0) {
            if ((userEntry <= 60)) {
                output = user + ", " + userEntry + " is odd";
            }
            else {
                output = user + ", " + userEntry + " is odd and over 60";
            }
        }
        else if (userEntry % 2 == 0) {
            if (userEntry <= 25) {
                output = user + ", " + "that's even and less than 25";
            }
            else if ((userEntry >= 26) && (userEntry <= 60)) {
                output = user + ", " + " that's even";
            }
            else {
                output = user + ", " + userEntry + " is even";
            }
        }
        else {
            output = user + ", " + userEntry + " is not a valid option.";
        }

        return output;

    }

    public static void main(String[] args) {

        int selection = 0;
        char keepGoing = 'y';
        Scanner entry = new Scanner(System.in);

        //Get user name for future outputs
        String user = getUserName(entry);

        //Repeat until user is done (by entering 'n' or anything not starting with 'y' or 'Y')
        while ((keepGoing == 'y') || (keepGoing == 'Y')) {

            //Force user to enter an integer between 1 and 100 (repeat requests until they do so)
            do {
                System.out.print(user + ", enter an integer between 1 and 100: ");

                //Pause and inform the user if the entry was not an integer
                while (!entry.hasNextInt()) {
                    System.out.print(user + ", that's not an integer! Try again: ");
                    entry.next();
                }

                //Initialize their selection and proceed forward if their integer was between 1 and 100
                selection = entry.nextInt();
            } while ((selection < 1) || (selection > 100));

            //Use selectionType to output corresponding decision made a.k.a selection
            System.out.println(selectionType(selection, user));

            //Quit if the user decides (again by entering 'n' or anything not starting with 'y' or 'Y')
            System.out.print(user + ", would you like to continue? (y/n): ");
            keepGoing = entry.next().charAt(0);
        }

        //End program officially
        System.out.println("Bye, " + user + "!");

        entry.close();

    }

}
