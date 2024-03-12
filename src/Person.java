public class Person {
    //creating variables
    private static String name;
    private static String surname;
    private static String email;
    //creating the constructor for Person class
      public Person(String name,String surname,String email){
        this.name=name;
        this.surname=surname;
        this.email=email;

    }
//creating getters

    public static String getName(){
          return name;
    }
    public static String getSurname(){
          return surname;
    }
    public static String getEmail(){
        return email;
    }




}
