package com.xyx.javadesignmode.ui.b1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShareViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ShareViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("23 种设计模式（1）：单例模式\n" +
                "\n" +
                "定义：确保一个类只有一个实例，而且自行实例化并向整个系统提供这个实例。类型：创建类模式\n" +
                "类 图 ： [code=img]design/singleton.gif 类图知识点：\n" +
                "1，类图分为三部分，依次是类名、属性、方法。\n" +
                "2，以<<开头和以>>结尾的为注释信息。\n" +
                "3，修饰符+代表 public，-代表 private，代表 protected，什么都没有代表包可见。\n" +
                "4，带下划线的属性或方法代表是静态的。\n" +
                "5，对类图中对象的关系不熟悉的朋友可以参考文章：设计模式中类的关系。单例模式应该是 23 种设计模式中最简单的一种模式了。它有以下几个要素：\n" +
                "1，私有的构造方法。\n" +
                "2，指向自己实例的私有静态引用。\n" +
                "3，以自己实例为返回值的静态的公有的方法。\n" +
                "单例模式根据实例化对象时机的不同分为两种：一种是饿汉式单例，一种是懒汉式单例。饿汉式单例在单例类被加载时候，就实例化一个对象交给自己的引用；而懒汉式在调用取得实例方法的时候才会实例化对象。\n" +
                "代码如下：饿汉式单例\n" +
                "\n" +
                "public class Singleton {\n" +
                "private static Singleton singleton = new Singleton();\n private Singleton() {\n" +
                " \n" +
                "}\n" +
                "\n" +
                "public static Singleton getInstance() {\n return singleton;\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "懒汉式单例\n" +
                "\n" +
                "public class Singleton2 {\n" +
                "private static Singleton2 singleton;\n" +
                "\n" +
                "private Singleton2() {\n" +
                "}\n" +
                "\n" +
                "public static synchronized Singleton2 getInstance() {\n if (singleton == null) {\n" +
                "singleton = new Singleton2();\n" +
                "}\n" +
                "return singleton;\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "\n" +
                "单例模式的优点：\n" +
                "1，在内存中只有一个对象，节省内存空间。\n" +
                "2，避免频繁的创建销毁对象，可以提高性能。\n" +
                "3，避免对共享资源的多重占用。\n" +
                "4，可以全局访问。\n" +
                "适用场景：由于单例模式的以上优点，所以是编程中用的比较多的一种设计模式。我总结了一下我所知道的适合使用单例模式的场景：\n" +
                "1，需要频繁实例化然后销毁的对象。\n" +
                "2，创建对象时耗时过多或者耗资源过多，但又经常用到的对象。\n" +
                "3，有状态的工具类对象。\n" +
                "4，频繁访问数据库或文件的对象。\n" +
                "5，以及其他我没用过的所有要求只有一个对象的场景。\n" +
                "单例模式注意事项：\n" +
                "1，只能使用单例类提供的方法得到单例对象，不要使用反射，否则将会实例化一个新对象。\n" +
                "2，不要做断开单例类对象与类中静态引用的危险操作。\n" +
                "3，多线程使用单例使用共享资源时，注意线程安全问题。\n" +
                "关于 java 中单例模式的一些争议：\n" +
                "单例模式的对象长时间不用会被 jvm 垃圾收集器收集吗\n" +
                "看到不少资料中说：如果一个单例对象在内存中长久不用，会被 jvm 认为是一个垃圾，在执行垃圾收集的时候会被清理掉。对此这个说法，笔者持怀疑态度，笔者本人的观点是：在\n" +
                " \n" +
                "hotspot 虚拟机 1.6 版本中，除非人为地断开单例中静态引用到单例对象的联接，否则 jvm\n" +
                "垃圾收集器是不会回收单例对象的。\n" +
                "对于这个争议，笔者单独写了一篇文章进行讨论，如果您有不同的观点或者有过这方面的经历请进入文章单例模式讨论篇：单例模式与垃圾收集参与讨论。\n" +
                "在一个 jvm 中会出现多个单例吗？\n" +
                "在分布式系统、多个类加载器、以及序列化的的情况下，会产生多个单例，这一点是无庸置疑的。那么在同一个 jvm 中，会不会产生单例呢？使用单例提供的 getInstance()方法只能得到同一个单例，除非是使用反射方式，将会得到新的单例。代码如下\n" +
                "\n" +
                "Class c = Class.forName(Singleton.class.getName());\n Constructor ct = c.getDeclaredConstructor(); \nct.setAccessible(true);\n" +
                "Singleton singleton = (Singleton) ct.newInstance();\n" +
                "\n" +
                "这样，每次运行都会产生新的单例对象。所以运用单例模式时，一定注意不要使用反射产生新的单例对象。\n" +
                "懒汉式单例线程安全吗？\n" +
                "主要是网上的一些说法，懒汉式的单例模式是线程不安全的，即使是在实例化对象的方法上加 synchronized 关键字，也依然是危险的，但是笔者经过编码测试，发现加 synchronized 关键字修饰后，虽然对性能有部分影响，但是却是线程安全的，并不会产生实例化多个对象的情况。\n" +
                "单例模式只有饿汉式和懒汉式两种吗？\n" +
                "饿汉式单例和懒汉式单例只是两种比较主流和常用的单例模式方法，从理论上讲，任何可以实现一个类只有一个实例的设计模式，都可以称为单例模式。\n" +
                "单例类可以被继承吗？\n" +
                "饿汉式单例和懒汉式单例由于构造方法是 private 的，所以他们都是不可继承的，但是其他很多单例模式是可以继承的，例如登记式单例。\n" +
                "饿汉式单例好还是懒汉式单例好？\n" +
                "在 java 中，饿汉式单例要优于懒汉式单例。C++中则一般使用懒汉式单例。\n\n\n\n\n\n\n\n\n\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}