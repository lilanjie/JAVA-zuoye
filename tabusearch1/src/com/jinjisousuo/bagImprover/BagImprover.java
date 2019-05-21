package com.jinjisousuo.bagImprover;

import com.jinjisousuo.model.Bag;
import com.jinjisousuo.model.Good;

import java.util.List;

public interface BagImprover {

    List<Bag> improve(List<Good> goods, Bag bag);
}
