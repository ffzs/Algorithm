package SimpleFactory;

import org.junit.Test;


public class FruitFactory {

    public Fruit creatFruit(FruitType type){
        switch (type) {
            case Apple:
                return new Apple();
            case Pear:
                return new Pear();
            case Banana:
                return new Banana();
            default:
                return null;
        }
    }


    @Test
    public void test () throws Exception {
        FruitFactory ff = new FruitFactory();
        FruitType[] types = FruitType.values();
        Fruit[] fruits = new Fruit[types.length];
        for (int i = 0; i < types.length; i++) {
            fruits[i] = ff.creatFruit(types[i]);
        }
        for(var f : fruits) f.whatIm();
    }

}
