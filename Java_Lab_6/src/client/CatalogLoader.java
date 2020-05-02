package client;

import exceptions.CatalogLoadException;
import stocklist.*;

public interface CatalogLoader {
    public void load(ItemCatalog catalog) throws CatalogLoadException;
}
