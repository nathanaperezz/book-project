public class BookstoreBookList {

    private BookstoreBook[] StoreList;
    final int SIZE = 1000;
    BookstoreBook myBookstoreBook[] = null;



    public BookstoreBookList() {
        StoreList = new BookstoreBook[SIZE];
        for (int i = 0; i<SIZE ; i++)
            StoreList[i] = null;
    }
    public void SetStoreBooks(String array[], double price, double sale, int numStoreBooks) {
        StoreList[numStoreBooks].setAuthor(array[0]);
        StoreList[numStoreBooks].setTitle(array[1]);
        StoreList[numStoreBooks].setIsbn(array[2]);
        StoreList[numStoreBooks].setPrice(price);
        StoreList[numStoreBooks].setSale(sale);
    }

    public void printStoreBooks() {
        for ( int i = 0; i<SIZE ; i++)
            if ( StoreList[i] != null) {
                double listPrice = StoreList[i].getPrice() - (StoreList[i].getPrice() / StoreList[i].getSale());
                System.out.println("[" + StoreList[i].getIsbn() + "-" + StoreList[i].getTitle() + " by " + StoreList[i].getAuthor() + ", $" + StoreList[i].getPrice() + " listed for " + listPrice +"]");
            }
    }
}
