package com.GA;
import java.util.HashMap;
import java.util.Map;

public class GeneticAlgorithmTest  extends GeneticAlgorithm {
    public static final int NUM = 1 << 4;

    public GeneticAlgorithmTest() {
        super(4);
    }

    @Override
    public double changeX(Chromosome chro) {
        // TODO Auto-generated method stub
        return ( chro.getNum() );//?
    }

    @Override
    public double caculateY(double x) {
        // TODO Auto-generated method stub
        Map<Double,Double>map=new HashMap<>();
        map.put(0d,28d);
        map.put(1d,26d);
        map.put(2d,24d);
        map.put(3d,18d);
        map.put(4d,22d);
        map.put(5d,6d);
        map.put(6d,14d);
        map.put(7d,0d);
        map.put(8d,20d);
        map.put(9d,12d);
        map.put(10d,10d);
        map.put(11d,2d);
        map.put(12d,8d);
        map.put(13d,4d);
        map.put(14d,6d);
        map.put(15d,30d);

        return (map.get(x));
    }

    public static void main(String[] args) {
        GeneticAlgorithmTest test = new GeneticAlgorithmTest();
        test.caculte();
    }

}
