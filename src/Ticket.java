public class Ticket {
    private static int row;
    private static int seat;
    private static int price;
    private static Person  person;
//creating the constructor for Ticket class
    public Ticket(int row, int seat, int price, Person person){
        this.row=row;
        this.seat=seat;
        this.price=price;
        this.person=person;

    }

//creating the print method
    public static void print(){

        System.out.println("Person name : "+ Person.getName());
        System.out.println("Person surname : "+ Person.getSurname());
        System.out.println("Row : "+row);
        System.out.println("Email : "+Person.getEmail());
        System.out.println("Price : "+price);




    }

}
