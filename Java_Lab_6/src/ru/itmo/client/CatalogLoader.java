package ru.itmo.client;

import ru.itmo.exceptions.CatalogLoadException;
import ru.itmo.stocklist.*;

public interface CatalogLoader {
    public void load(ItemCatalog catalog) throws CatalogLoadException;
}
