package cn.wgh.designpattern.strategy;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Test;
/**
 * Created by wgh on 2020/12/5.
 */
public class TestMain {

    @Test
    public void test1() throws Exception {
        int[] ints = {6,1,3,8,4,6,9,3,2,4};
        IntSorter intSorter = new IntSorter();
        intSorter.sort(ints);
        for (int i : ints) {
            System.out.print(i+" ");
        }
    }




    @Test
    public void test2() throws  Exception{
        Cat[] cats = new Cat[]{new Cat(1, 5), new Cat(3, 2), new Cat(5, 3)};
        Dog[] dogs = new Dog[]{new Dog(2, 5, 4), new Dog(3, 2,3), new Dog(5, 3,5)};

        Sorter<Cat> catSorter = new Sorter<>();
        Sorter<Dog> dogSorter = new Sorter<>();

        System.out.println("-------------------------------------");
        catSorter.sort(cats,new CatWeightComparator(),-1);
        for (Cat c : cats) {
            System.out.println(c.toString());
        }
        System.out.println("-------------------------------------");
        catSorter.sort(cats,new CatHeightComparator(),1);
        for (Cat c : cats) {
            System.out.println(c.toString());
        }

        System.out.println("-------------------------------------");
        dogSorter.sort(dogs,new DogComparator(),1);
        for (Dog d : dogs) {
            System.out.println(d.toString());
        }
    }
}
