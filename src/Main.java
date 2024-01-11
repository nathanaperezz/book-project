//Nathan Perez
//3330 Assignment #2
//Stores library books and bookstore books in arrays of objects 

import java.util.Scanner;

//----------------------------------------------------------------------------------------

class BookstoreBook {

    private String author;
    private String title;
    private String isbn;
    private Double price;
    private Double sale;

    // getters and setters
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Double getSale() {
        return sale;
    }
    public void setSale(Double sale) {
        this.sale = sale;
    }


}


public class Main {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        BookstoreBookList myStoreList = new BookstoreBookList();
        LibraryBookList myLibraryList = new LibraryBookList();


        //these will be variables incremented so that we know where we are in the arrays
        int numStoreBooks = 0;
        int numLibraryBooks = 0;


        System.out.println("Welcome to the book program!");

        //ask user to create new books object
        //if not their books will be printed
        System.out.println("Would you like to create a book object? (yes/no): ");

        //while they still want to create books or there is an error this loop will run
        while(true) {

            String input = scan.next();
            if (input.equals("yes")) {

                //ask for book information here
                System.out.println("Please enter the author, title, and the isbn of the book separated by /: ");

                //set author title and isbn vals
                String test1 = scan.nextLine(); //used to get rid of new line character
                String bookInfo = scan.nextLine();
                String[] bookInfoStr = bookInfo.split("/", 3);
                //the array bookInfoStr now holds the strings author, title and isbn
                //we can use this to add them to memory, but first we need to know whether to store as a library or bookstore book

                System.out.println("Is it a Bookstore book or a Library book (enter BB for bookstore book or LB for library book): ");

                //loops in case of user error
                while(true) {

                    String b = scan.next();

                    //if it is a bookstore book we will need to get the price and sale before storing
                    if(b.equals("BB")){

                        //ask for price
                        System.out.println("Please enter the list price");
                        double price = scan.nextDouble();

                        //set sale to 0%
                        //if item is not on sale it will take 0% off the price
                        double sale = 0;

                        //ask user if it is on sale and store response in the ifSale string
                        System.out.println("Is it on sale? (yes/no): ");
                        String ifSale = scan.next();

                        //loop in case of user error
                        while(true) {
                            if (ifSale.equals("yes")) {
                                System.out.println("Deduction percentage: ");
                                sale = scan.nextDouble();
                                break;
                            }

                            else if(ifSale.equals("no")) break;

                            else System.out.println("error please enter (yes/no): ");

                        }

                        myStoreList.SetStoreBooks(bookInfoStr, price, sale, numStoreBooks);
                        //increment store books so that the next one will be in a new spot in the array
                        numStoreBooks++;
                    }
                    else if(b.equals("LB")) {
                        //put the info from the user into the SetLibraryBooks function
                        myLibraryList.SetLibraryBooks(bookInfoStr, numLibraryBooks);
                        //incrementing the number of library books allows us to make sure that two books dont get put in the same spot
                        //they each get there own space in the array
                        numLibraryBooks++;
                    }
                    else System.out.println("error: please enter keywords BB/LB");
                }
            }

            else if (input.equals("no")) {
                System.out.println("Here are all your books!");


                //print all the books
                //print Library
                System.out.println("Library Books (" + numLibraryBooks + ")");
                myLibraryList.printLibraryBooks();

                //spacing
                System.out.println("----------------------");

                //print bookstore
                System.out.println("Bookstore Books (" + numStoreBooks + ")");
                myStoreList.printStoreBooks();

                // more spacing
                System.out.println("----------------------");


                break;
            }

            else System.out.println("error: please enter keywords yes/no");


        } //close while loop to create books/print books

        System.out.println("Goodbye!");

    } //close main

} //close tester 
