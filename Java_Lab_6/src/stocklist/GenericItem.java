package stocklist;

import java.util.Objects;

public class GenericItem implements Cloneable{
    private int ID;
    static int currentID = 1;
    private String name;
    private float price;
    private Category category = Category.GENERAL;
    private GenericItem analog;

    protected GenericItem(int ID, String name, float price, Category category){
        this.setID(ID);
        this.setName(name);
        this.setPrice(price);
        this.setCategory(category);
    }
    public GenericItem(String name, float price, Category category){
        //this(stocklist.GenericItem.currentID, name, price, category);
        //ID = stocklist.GenericItem.currentID++;
        //this.name = name;
        //this.price = price;
        this.category = category;
    }
    /*
        stocklist.GenericItem(String name, float price, stocklist.GenericItem analog){
        this(name, price, stocklist.Category.GENERAL);
        в этом конструкторе не присваем ID, так как это перегруженный конструктор, который берет за основу поля из
        родительского конструктора, в котором по умолчанию ID увеличивается на 1
        ID = stocklist.GenericItem.currentID++;
        this.analog = analog;
        }
        */

    public GenericItem(){
        this("Unnamed", 0f, Category.GENERAL);
        //в этом конструкторе не присваем ID, так как это перегруженный конструктор, который берет за основу поля из
        //родительского конструктора, в котором по умолчанию ID увеличивается на 1
        //ID = stocklist.GenericItem.currentID++;
    }

    void printAll() {
        System.out.printf("ID: %-10d Name: %-10s stocklist.Category: %-10s price: %-10.2f\n", ID, name, category, price);
    }

    public String toString(){
        return this.name + "|" + ID + "|" + price + "|" + category;
    }


    public boolean equals(GenericItem item){
        if (this == item){
            return true;
        }
        if (item == null || getClass() != item.getClass()){
            return false;
        }
        if(this.ID == item.ID && this.name == item.name && this.price == item.price && this.category == item.category){
            return true;
        }
        return false;
    }

    public int hashcode(){
        return Objects.hash(ID, name, price, category);
    }


    @Override
    public GenericItem clone() throws CloneNotSupportedException {
        if (this.analog != null) {
            return (GenericItem) this.analog.clone();
        }
        return (GenericItem) super.clone();
    }

    protected int getID() {
        return this.ID;
    }

    protected void setID(int ID) {
        this.ID = ID;
    }

    protected String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected float getPrice() {
        return this.price;
    }

    protected void setPrice(float price) {
        this.price = price;
    }

    protected Category getCategory() {
        return this.category;
    }

    protected void setCategory(Category category) {
        this.category = category;
    }

    protected GenericItem getAnalog() {
        return this.analog;
    }

    protected void setAnalog(GenericItem analog) {
        this.analog = analog;
    }
}



