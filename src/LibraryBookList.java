public class LibraryBookList {

    final int SIZE =1000;
    private LibraryBook [] LibraryList ;
    LibraryBook myLibraryBook = null;


    public LibraryBookList() {
        LibraryList = new LibraryBook[SIZE];
        for (int i = 0; i<SIZE ; i++)
            LibraryList[i] = null;
    }


    public void SetLibraryBooks(String array[], int numLibraryBooks) {

        LibraryList[numLibraryBooks].setAuthor(array[0]);
        LibraryList[numLibraryBooks].setTitle(array[1]);
        LibraryList[numLibraryBooks].setIsbn(array[2]);
    }

    public void printLibraryBooks() {
        for ( int i = 0; i<SIZE ; i++)
            if ( LibraryList[i] != null)
                System.out.println("[" + LibraryList[i].getIsbn() + "-" + LibraryList[i].getTitle() + " by " + LibraryList[i].getAuthor() + "]");
    }
}
