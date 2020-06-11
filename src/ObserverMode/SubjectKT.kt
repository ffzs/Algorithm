//package ObserverMode
//
//import kotlin.properties.Delegates
//
//interface VideoUpdateListener {
//    fun update(message:String)
//}
//
//
//// 模拟up更新视频就会通知订阅者
//class VideoUpdate {
//    var observers: MutableList<User> = ArrayList() // 存储订阅者
//    var id: Int by Delegates.observable(0) { _, old, new ->
//        observers.forEach{
//            if (old==new) it.update("User ${it.name} get a message: liangfeng update NO.$id video")
//            else it.update("User ${it.name} get a message: liangfeng publish NO.$id video")
//        }
//    }
//}
//
//// 用户类
//class User(var name: String) : VideoUpdateListener {
//    override fun update(message:String) {
//        println(message)
//    }
//
//}
//
//
//fun main(args: Array<String>) {
//    val bilibili = VideoUpdate()
//    bilibili.observers.add(User("ffzs"))
//    bilibili.observers.add(User("sleepycat"))
//    bilibili.id=100
//    bilibili.id=10
//    bilibili.id=10
//}
//
