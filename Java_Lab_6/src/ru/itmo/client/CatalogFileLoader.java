package ru.itmo.client;

import ru.itmo.exceptions.CatalogLoadException;
import ru.itmo.exceptions.ItemAlreadyExistsException;
import ru.itmo.stocklist.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Date;
import java.io.FileNotFoundException;

public class CatalogFileLoader implements CatalogLoader {
    private String fileName;

    public CatalogFileLoader(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void load(ItemCatalog catalog) throws CatalogLoadException {

        File file = new File(fileName);
        String line;
        try {
            Scanner scanner = new Scanner(new FileInputStream(file));
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.length() == 0)
                    break;
                String[] itemFields = line.split(";");
                String name = itemFields[0];
                float price = Float.parseFloat(itemFields[1]);
                short expires = Short.parseShort(itemFields[2]);
                FoodItem item = new FoodItem(name, price, null, new Date(), expires);
                catalog.addItem(item);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CatalogLoadException();
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
            throw new CatalogLoadException();
        }
    }

}
