import enumDefinition.Category;

import java.time.LocalDateTime;

public class Transaction {
     private LocalDateTime dateTime;
     private double amount;
     private String description;
     private String particulars;

     public LocalDateTime getDateTime() {
          return dateTime;
     }

     public void setDateTime(LocalDateTime dateTime) {
          this.dateTime = dateTime;
     }

     public void setAmount(double amount) {
          this.amount = amount;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public String getParticulars() {
          return particulars;
     }

     public void setParticulars(String particulars) {
          this.particulars = particulars;
     }

     public String getComment() {
          return comment;
     }

     public void setComment(String comment) {
          this.comment = comment;
     }

     public Category getCategory() {
          return category;
     }

     public void setCategory(Category category) {
          this.category = category;
     }

     private String comment;
     private Category category;

     private boolean positiv;

     public Transaction(double amount, LocalDateTime dateTime) {
          if (Double.compare(amount, 0.0) == -1) positiv = false;
          this.amount = Math.abs(amount);

     }

     public boolean isPositiv() {
          return positiv;
     }

     public double getAmount() {
          return amount;
     }
}

