package ru.itmo.stocklist;

import java.util.Date;
import java.util.Objects;

public class FoodItem extends GenericItem {
    private Date dateOfIncome;
    private short expires;

    FoodItem(int ID, String name, float price, Category category, Date dateOfIncome, short expires){
        super(ID,name,price,category);
        this.setDateOfIncome(dateOfIncome);
        this.setExpires(expires);
    }

    public FoodItem(String name, float price, FoodItem analog, Date date, short expires){
        this.setName(name);
        this.setPrice(price);
        this.setAnalog(analog);
        this.setDateOfIncome(dateOfIncome);
        this.setExpires(expires);
    }

    FoodItem(String name, float price, short expires){
        this(name, price, null, null, expires);
    }

    FoodItem(String name){
        this(name, 0f, null, null, (short) 2);
    }

    @Override
    void printAll(){
        System.out.printf("ID: %-10d Name: %-10s Category: %-10s price:%-10.2f Expires: %-10d Date Of Income:%s \n", getID(),
                getName(), getCategory(), getPrice(), expires, dateOfIncome);
    }

    @Override
    public String toString() {
        return this.getName() + "|" + getID() + "|" + getCategory() + "|" + getPrice() + "|" + expires + "|" + dateOfIncome;
    }

    public boolean equals(FoodItem item){
        if (this == item){
            return true;
        }
        if (item == null || getClass() != item.getClass()){
            return false;
        }
        if(this.getID() == item.getID() && this.getName() == item.getName() && this.getPrice() == item.getPrice() && this.getCategory() == item.getCategory()
                && this.dateOfIncome == item.dateOfIncome && this.expires == item.expires){
            return true;
        }
        return false;
    }

    @Override
    public int hashcode(){
        return Objects.hash(this.getID(), this.getName(), this.getPrice(), this.getCategory(), dateOfIncome, expires);
    }

    @Override
    public FoodItem clone() throws CloneNotSupportedException{
        return (FoodItem) super.clone();
    }

    protected Date getDateOfIncome() {
        return this.dateOfIncome;
    }

    protected void setDateOfIncome(Date dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }

    protected short getExpires() {
        return this.expires;
    }

    protected void setExpires(short expires) {
        this.expires = expires;
    }
}


