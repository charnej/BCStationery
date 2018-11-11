package BusinessLayerPackage;

import java.util.Comparator;

/**
 *
 * @author Jozehan
 */
public class compByQuantity implements Comparator<Stock> {

    @Override
    public int compare(Stock o1, Stock o2) {
        if (o1.getQuantity() > o2.getQuantity()) {
            return 1;
        } else if (o1.getQuantity() == o2.getQuantity()) {
            return 0;
        } else {
            return -1;
        }
    }

}
