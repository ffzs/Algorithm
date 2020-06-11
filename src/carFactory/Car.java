package carFactory;

interface Car {
    String getEngine();
    static Car product(carType type) {
        switch (type){
            case newEnergyCar: return new newEnergyCar();
            case traditionCar: return new traditionCar();
            default: return null;
        }
    }
}

class traditionCar implements Car{
    String engine = "Oil";
    @Override
    public String getEngine(){
        return this.engine;
    }
}

class newEnergyCar implements Car{
    String engine = "electric";
    @Override
    public String getEngine(){
        return this.engine;
    }
}

enum carType {
    newEnergyCar,
    traditionCar
}


// 创建 品牌接口
interface Brand{}
// 创建抽象类用来获取工厂类
abstract class AbstractFactory {
    abstract Brand product();
    static AbstractFactory getFactory(BrandType type){
        switch (type) {
            case BYD: return new BYDFactory();
            case AUDI: return new AUDIFactory();
            default: return new BMWFactory();
        }
    }
}
//枚举工厂类型
enum BrandType {
    BYD, BMW, AUDI
}
//品牌类
class BYD implements Brand{}
class BMW implements Brand{}
class AUDI implements Brand{}
//创建不同品牌的工厂类
class BYDFactory extends AbstractFactory {
    @Override
    Brand product(){
        return new BYD();
    }
}
class BMWFactory extends AbstractFactory {
    @Override
    Brand product(){
        return new BMW();
    }
}
class AUDIFactory extends AbstractFactory {
    @Override
    Brand product(){
        return new AUDI();
    }
}
// 测试
class FactoryPatternDemo {
    public static void main(String[] args) {
        AbstractFactory bydFactory = AbstractFactory.getFactory(BrandType.BYD);
        AbstractFactory audiFactory = AbstractFactory.getFactory(BrandType.AUDI);
        AbstractFactory bmwFactory = AbstractFactory.getFactory(BrandType.BMW);
        System.out.println(bydFactory.product());
        System.out.println(audiFactory.product());
        System.out.println(bmwFactory.product());
    }
}
