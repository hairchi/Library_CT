package com.library.jdbctests;

import com.library.utility.DB_Util;
import org.junit.jupiter.api.Test;

public class US2_Olena_DB_BorrowedBooks {

    String url = "jdbc:mysql://34.230.35.214:3306/library1";
    String username = "library1_client";
    String password = "WVF4NdGXCKHeE6VQ";

    @Test
    public void task1() {
        // create a connection
        DB_Util.createConnection(url, username, password);  // connection string

        // Run Query
        DB_Util.runQuery("select count(*) as borrowedBooks from book_borrow\n" +
                "where is_returned = 0;");

        // get data from DB
        String expectedBorrowedBookCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedBorrowedBookCount = " + expectedBorrowedBookCount);


        // close it
  //      DB_Util.destroy();

    }
}
