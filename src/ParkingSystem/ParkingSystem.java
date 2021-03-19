package ParkingSystem;

/**
 * @author: ffzs
 * @Date: 2021/3/19 上午7:50
 */
public class ParkingSystem {

    private int[] room;

    public ParkingSystem(int big, int medium, int small) {
        room = new int[3];
        room[0] = big;
        room[1] = medium;
        room[2] = small;
    }

    public boolean addCar(int carType) {
        if (room[carType-1] > 0) {
            room[carType - 1] --;
            return true;
        }
        return false;
    }

}
