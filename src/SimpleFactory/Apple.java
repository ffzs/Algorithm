package SimpleFactory;

public class Apple implements Fruit {
    @Override
    public void whatIm() {
        System.out.println("苹果的英文是：" + this.getClass().getSimpleName());
    }
}
