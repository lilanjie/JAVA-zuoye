package com.tabusearch.model;

import java.util.List;

public interface BagImprover {

    List<Bag> improve(List<Good> goods, Bag bag);
}
