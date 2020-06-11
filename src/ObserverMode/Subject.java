package ObserverMode;

import java.util.*;

// 模拟up更新视频就会通知订阅者
class VideoUpdate extends Observable {
    private List<User> observers = new ArrayList<>(); // 存储订阅者
    // 添加dingyuezhe
    void addOberver(User user){
        this.observers.add(user);
    }
    // 移除订阅者
    void deleteObserver(User user){
        this.observers.remove(user);
    }
    // 通知订阅者
    void setVideoUpdate (Object id){
        this.observers.forEach(it->it.update(this, "User "+ it.name + " get a message: liangfeng publish NO."+ id +" video"));
    }
}
// 用户类
class User implements Observer {
    String name;
    User(String name){
        this.name = name;
    }
    @Override
    public void update(Observable o, Object message){
        System.out.println(message);
    }
}

class ObserverPatternDemo  {
    public static void main(String[] args) {
        VideoUpdate bilibili = new VideoUpdate();
        bilibili.addOberver(new User("ffzs"));
        bilibili.addOberver(new User("sleepycat"));
        bilibili.setVideoUpdate("100");
        bilibili.setVideoUpdate("10");
    }
}
