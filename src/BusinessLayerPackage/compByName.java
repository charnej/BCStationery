/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

import java.util.Comparator;

/**
 *
 * @author Jozehan
 */
public class compByName implements Comparator<Stock>{
    @Override
    public int compare(Stock o1, Stock o2) {
        return o1.getProductName().compareTo(o1.getProductName());
    }
}
