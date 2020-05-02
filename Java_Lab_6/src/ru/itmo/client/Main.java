package ru.itmo.client;

import ru.itmo.exceptions.CatalogLoadException;
import ru.itmo.exceptions.ItemAlreadyExistsException;
import ru.itmo.stocklist.*;

import java.util.Date;
public class Main {
    public static void main(String[] args) {
        System.out.println('\n');
        var catalog = new ItemCatalog();

        try {
            catalog.addItem(new GenericItem());//, new GenericItem(), new GenericItem(), new GenericItem(), new GenericItem(), new GenericItem(),
                    //new GenericItem(), new GenericItem(), new GenericItem(), new GenericItem());
        }catch (ItemAlreadyExistsException e){
            e.printStackTrace();
        }
        catalog.printItems();

        long begin = new Date().getTime();
        for (int i = 0; i < 100_000; i++) {
            catalog.findItemByID(10);
        }
        long end = new Date().getTime();
        System.out.println("In HashMap: " + (end - begin));

        begin = new Date().getTime();
        for (int i = 0; i < 100_000; i++) {
            catalog.findItemByIDAL(10);
        }
        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin));

        System.out.println('\n');

        try{
        CatalogLoader loader = new CatalogStubLoader();
        loader.load(catalog);
        catalog.printItems();}
        catch (CatalogLoadException e){
            e.printStackTrace();
        }

        try{
            CatalogFileLoader fileLoader = new CatalogFileLoader("items.lst");
            fileLoader.load(catalog);
            catalog.printItems();
        } catch (CatalogLoadException e){
            e.printStackTrace();
        }
    }

}
