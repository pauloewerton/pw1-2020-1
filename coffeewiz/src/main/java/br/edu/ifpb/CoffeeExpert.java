package br.edu.ifpb;

import java.util.ArrayList;
import java.util.List;

public class CoffeeExpert {
    public List<String> getBrands(String intensity) {
        List<String> brands = new ArrayList<String>();

        if (intensity.equals("medium")) {
            brands.add("Mogiana Paulista");
            brands.add("Serrado Mineiro");
        } else {
            brands.add("Jakarta Premium");
            brands.add("Caffe Verona");
        }

        return brands;
    }    
}
