import enumDefinition.Category;

import java.time.LocalDate;

public class Transaction {
     private LocalDate dateTime;
     private double amount;
     private String description;
     private String particulars;
     private String comment;
     private Category category;

     private boolean positiv;

     public boolean isPositiv() {
          return positiv;
     }

     public double getAmount() {
          return amount;
     }
}

