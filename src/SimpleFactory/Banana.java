package SimpleFactory;

public class Banana implements Fruit{

    public Banana() {
    }

    @Override
    public void whatIm() throws Exception {
        this.getClass().getDeclaredConstructor().newInstance();
        System.out.println("香蕉的英文是：" + this.getClass().getSimpleName());
    }
}
