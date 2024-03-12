import java.io.File;
import java.io.FileNotFoundException;//importing classes
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//final
public class Theatre {
    //creating 3 arrays
    static int[] row1 = new int[12];
    static int[] row2 = new int[16];
    static int[] row3 = new int[20];
    //importing the scanner
    static Scanner scanner = new Scanner(System.in);

    //creating the Ticket arraylist
    static ArrayList<Ticket> ticketlist = new ArrayList<>();
    //creating variables to showticket method
    static int row1count = 0;
    static int row2count = 0;
    static int row3count = 0;
    static int price;

    public static void main(String[] args) {
        System.out.print("Welcome to the New Theatre");
        //printning the main menue

        String option = "-1";
        do {
            System.out.println("\n-------------------------------------------------");
            System.out.println("********** option menu ********** ");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("0) Quit");
            System.out.println("-------------------------------------------------\n");
            System.out.print(" select an option : ");
            option = scanner.next();

            switch (option) {
                case "0":
                    System.out.println("Goodbye!");
                    break;
                case "1":
                    buyTicket();
                    break;
                case "2":
                    printSeatingArea();
                    break;
                case "3":
                    cancel_ticket();
                    break;
                case "4":
                    show_available();
                    break;
                case "5":
                    save();
                    break;
                case "6":
                    load();
                    break;
                case "7":
                    System.out.println("you choose Print ticket information and total price");
                    show_ticketinfo();
                    break;
                case "8":
                    System.out.println("Sort tickets by price");
                    break;
                default:
                    System.out.println("Invalid option.please re enter : ");
                    break;
            }
        } while (!option.equals("0"));
    }

    //creating buyTicket method
    private static void buyTicket() {
        int row;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter row number (1-3): ");
            do {
                row = scanner.nextInt();
                if (row < 1 || row > 3) {
                    System.out.println("This row number does not exist. Please select 1-3 :");
                }
            } while (row < 1 || row > 3);
            System.out.print("Enter seat number: ");
            int numSeats;
            int seat;
            int[] selectedRow;
            do {
                seat = scanner.nextInt();
                switch (row) {
                    case 1:
                        selectedRow = row1;
                        numSeats = 12;
                        break;
                    case 2:
                        selectedRow = row2;
                        numSeats = 16;
                        break;
                    case 3:
                        selectedRow = row3;
                        numSeats = 20;
                        break;
                    default:
                        System.out.println("Invalid row number");
                        return;
                }

                if (seat < 1 || seat > numSeats) {
                    System.out.println("Invalid seat number.select again :");
                }
            } while (seat < 1 || seat > numSeats);

            if (selectedRow[seat - 1] == 1) {
                System.out.println("Seat already taken.please select another one.");
                return;
            } else {

                selectedRow[seat - 1] = 1;
                System.out.println("\nTicket bought successful in row " + row + ", seat " + seat);
                System.out.print("Enter your name here : ");
                String name = scanner.next();
                System.out.print("Enter your surname here : ");
                String surname = scanner.next();
                System.out.print("Enter your email here : ");
                String email = scanner.next();
                Person person = new Person(name, surname, email);



                if (row == 1) {
                    price = 10;
                    row1count = row1count + 10;
                }
                if (row == 2) {
                    price = 20;
                    row2count = row2count + 20;
                }
                if (row == 3) {
                    price = 30;
                    row3count = row3count + 30;
                }
                Ticket object2 = new Ticket(row, seat, price, person);
                ticketlist.add(object2);
            }
        } catch (Exception e) {
            System.out.println("input error...");
        }
    }

    //printing seating area method
    private static void printSeatingArea() {
        System.out.println("     ***********");
        System.out.println("     *  STAGE  *");
        System.out.println("     ***********");

        System.out.print("    ");

        for (int a = 0; a < row1.length; a++) {

            if (a == 6)
                System.out.print(" ");

            if (row1[a] == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
        }

        System.out.print("    \n");

        System.out.print("  ");

        for (int a = 0; a < row2.length; a++) {

            if (a == 8)
                System.out.print(" ");

            if (row2[a] == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
        }

        System.out.print("  \n");

        System.out.print("");

        for (int a = 0; a < row3.length; a++) {

            if (a == 10)
                System.out.print(" ");

            if (row3[a] == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
        }

        System.out.print("\n");
    }

    //cancel ticket method
    public static void cancel_ticket() {
        int row;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter row number (1-3): ");
            do {
                row = scanner.nextInt();
                if (row < 1 || row > 3) {
                    System.out.println("This row number does not exist. Please select 1-3 :");
                }
            } while (row < 1 || row > 3);
            System.out.print("Enter seat number: ");
            int numSeats;
            int seat;
            int[] selectedRow;
            do {
                seat = scanner.nextInt();
                switch (row) {
                    case 1:
                        selectedRow = row1;
                        numSeats = 12;
                        break;
                    case 2:
                        selectedRow = row2;
                        numSeats = 16;
                        break;
                    case 3:
                        selectedRow = row3;
                        numSeats = 20;
                        break;
                    default:
                        System.out.println("Invalid row number");
                        return;
                }

                if (seat < 1 || seat > numSeats) {
                    System.out.println("Invalid seat number.select again :");
                }
            } while (seat < 1 || seat > numSeats);

            if (selectedRow[seat - 1] == 0) {
                System.out.println("Seat is not sold.please select again.");
                return;
            }

            selectedRow[seat - 1] = 0;
            System.out.println("Ticket cancel successful in row " + row + ", seat " + seat);
        } catch (Exception e) {
            System.out.println("input error...");
        }

    }
    //show available

    public static void show_available() {
        //printing row1 tickets
        System.out.print("\n seats available Row 1 :");
        for (int i = 0; i < row1.length; i++) {
            if (row1[i] == 0) {
                System.out.print(" " + (i + 1));
                System.out.print(",");
            }
        }
        //printing row2 tickets
        System.out.print("\n seats available Row 2 :");
        for (int i = 0; i < row2.length; i++) {
            if (row2[i] == 0) {
                System.out.print(" " + (i + 1));
                System.out.print(",");
            }
        }
        //printing row3 tickets
        System.out.print("\n seats available Row 3 :");
        for (int i = 0; i < row3.length; i++) {
            if (row3[i] == 0) {
                System.out.print(" " + (i + 1));
                System.out.print(",");
            }
        }
    }

    //creating save ticket method
    public static void save() {
        try {
            FileWriter writer = new FileWriter("text.txt");
            writer.write("row 1 : ");
            for (int l = 0; l < row1.length; l++) {
                writer.write(row1[l] + " ");
            }
            System.out.println("row 1 details saved.");
            writer.write("\n");
            writer.write("row 2 : ");
            for (int l = 0; l < row2.length; l++) {
                writer.write(row2[l] + " ");
            }
            System.out.println("row 2 details saved.");
            writer.write("\n");
            writer.write("row 3 : ");
            for (int l = 0; l < row3.length; l++) {
                writer.write(row3[l] + " ");
            }
            System.out.println("row 3 details saved.");
            writer.write("\n");
            writer.close();
        } catch (Exception e) {
            System.out.println(" error " + e.getCause());
            //The getCause() method is from Throwable class and we can use this method which returns
            // the cause of the exception or returns null if the cause of the exception is not known.
            // //The getCause() method doesn't accept any arguments and doesn't throw an exception.
        }
    }

    //creating load file method
    public static void load() {
        try {
            File file = new File("text.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] split = data.split("\\s+");

                for (int i = 3; i < split.length; i++) {
                    switch (split[1]) {
                        case "1":
                            row1[i - 3] = Integer.parseInt(split[i]);
                            break;
                        case "2":
                            row2[i - 3] = Integer.parseInt(split[i]);
                            break;
                        case "3":
                            row3[i - 3] = Integer.parseInt(split[i]);
                            break;
                        default:
                            break;
                    }
                }

            }
            myReader.close();
            System.out.println("load successfully");
            System.out.println("row 1 : " + Arrays.toString(row1));
            System.out.println("row 2 : " + Arrays.toString(row2));
            System.out.println("row 2 : " + Arrays.toString(row3));
        } catch (FileNotFoundException e) {
            System.out.println("error found." + e.getCause());
            e.printStackTrace();

        }
    }


    //creating show tickets method to print details of the ticket
    public static void show_ticketinfo() {

        Ticket.print();
        System.out.println("\n");
        System.out.println("Row1 sold ticket price : " + row1count);
        System.out.println("Row1 sold ticket price : " + row2count);
        System.out.println("Row1 sold ticket price : " + row3count);
        int total=row1count + row2count + row3count;
        System.out.println("full total of sold ticket price : " +total);


    }

}