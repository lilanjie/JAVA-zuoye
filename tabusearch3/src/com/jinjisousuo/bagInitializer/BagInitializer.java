package com.jinjisousuo.bagInitializer;

import com.jinjisousuo.model.Bag;
import com.jinjisousuo.model.Good;

import java.util.List;

public interface BagInitializer {

    Bag initialize(List<Good> goods, Bag bag);
}
