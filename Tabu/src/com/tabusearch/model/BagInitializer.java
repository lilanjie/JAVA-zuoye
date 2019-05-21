package com.tabusearch.model;

import java.util.List;

public interface BagInitializer {

    Bag initialize(List<Good> goods, Bag bag);
}

