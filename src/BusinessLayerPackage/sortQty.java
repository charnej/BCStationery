/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

import java.util.Comparator;

/**
 *
 * @author Tyrone
 */
public class sortQty implements Comparator<Stock> {

    @Override
    public int compare(Stock s1, Stock s2) {
        if (s1.getQuantity() == s2.getQuantity()) {
            return 0;
        } else if (s1.getQuantity() > s2.getQuantity()) {
            return 1;
        } else {
            return -1;
        }
    }

}
