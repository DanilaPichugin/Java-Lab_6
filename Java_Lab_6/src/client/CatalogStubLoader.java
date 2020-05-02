package client;

import exceptions.CatalogLoadException;
import exceptions.ItemAlreadyExistsException;
import stocklist.*;

import java.util.Date;

public class CatalogStubLoader implements CatalogLoader  {
    @Override
    public void load(ItemCatalog catalog) throws CatalogLoadException {
        try{
        GenericItem item1 = new GenericItem("Sony TV", 23_000, Category.GENERAL);
        FoodItem item2 = new FoodItem("Bread", 12, null, new Date(), (short) 10);
        catalog.addItem(item1);
        catalog.addItem(item2);
    }catch (ItemAlreadyExistsException e){
            e.printStackTrace();
            throw new CatalogLoadException();
        }
    }
}

