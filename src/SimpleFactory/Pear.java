package SimpleFactory;

public class Pear implements Fruit {
    @Override
    public void whatIm() {
        System.out.println("梨子的英文是：" + this.getClass().getSimpleName());
    }
}
