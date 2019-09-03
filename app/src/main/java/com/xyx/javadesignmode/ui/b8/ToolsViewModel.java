package com.xyx.javadesignmode.ui.b8;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("23 种设计模式（8）：观察者模式\n" +
                "定义：定义对象间一种一对多的依赖关系，使得当每一个对象改变状态，则所有依赖于它的对象都会得到通知并自动更新。\n" +
                "类型：行为类模式。类图：\n" +
                "[code=img]design/observer.jpg\n" +
                "在软件系统中经常会有这样的需求：如果一个对象的状态发生改变，某些与它相关的对象也要随之做出相应的变化。比如，我们要设计一个右键菜单的功能，只要在软件的有效区域内点击鼠标右键，就会弹出一个菜单；再比如，我们要设计一个自动部署的功能，就像 eclipse 开发时，只要修改了文件，eclipse 就会自动将修改的文件部署到服务器中。这两个功能有一个相似的地方，那就是一个对象要时刻监听着另一个对象，只要它的状态一发生改变，自己随之要做出相应的行动。其实，能够实现这一点的方案很多，但是，无疑使用观察者模式是一个主流的选择。\n" +
                "观察者模式的结构：\n" +
                "在最基础的观察者模式中，包括以下四个角色：\n" +
                " \n" +
                "被观察者：从类图中可以看到，类中有一个用来存放观察者对象的 Vector 容器（之所以使用\n" +
                "Vector 而不使用 List，是因为多线程操作时，Vector 在是安全的，而 List 则是不安全的），这个 Vector 容器是被观察者类的核心，另外还有三个方法：attach 方法是向这个容器中添加观察者对象；detach 方法是从容器中移除观察者对象；notify 方法是依次调用观察者对象的对应方法。这个角色可以是接口，也可以是抽象类或者具体的类，因为很多情况下会与其他的模式混用，所以使用抽象类的情况比较多。\n" +
                "观察者：观察者角色一般是一个接口，它只有一个 update 方法，在被观察者状态发生变化时， 这个方法就会被触发调用。\n" +
                "具体的被观察者：使用这个角色是为了便于扩展，可以在此角色中定义具体的业务逻辑。 具体的观察者：观察者接口的具体实现，在这个角色中，将定义被观察者对象状态发生变化时所要处理的逻辑。\n" +
                "观察者模式代码实现： import java.util.Vector;\n" +
                "abstract class Subject {\n" +
                "private Vector<Observer> obs = new Vector<Observer>();\n" +
                "\n" +
                "public void addObserver(Observer obs) { \nthis.obs.add(obs);\n" +
                "}\n" +
                "\n" +
                "public void delObserver(Observer obs) {\n this.obs.remove(obs);\n" +
                "}\n" +
                "\n" +
                "protected void notifyObserver() { \nfor (Observer o : obs) {\n" +
                "o.update();\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public abstract void doSomething();\n" +
                "}\n" +
                "\n" +
                "class ConcreteSubject extends Subject { \npublic void doSomething() {\n" +
                "System.out.println(\"被观察者事件反生\"); \nthis.notifyObserver();\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "interface Observer { public void update();\n" +
                " \n" +
                "}\n" +
                "\n" +
                "class ConcreteObserver1 implements Observer { \npublic void update() {\n" +
                "System.out.println(\"观察者 1 收到信息，并进行处理。\");\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "class ConcreteObserver2 implements Observer { \npublic void update() {\n" +
                "System.out.println(\"观察者 2 收到信息，并进行处理。\");\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Client4 {\n" +
                "public static void main(String[] args) {\n Subject sub = new ConcreteSubject();\n" +
                "sub.addObserver(new ConcreteObserver1()); // 添加观察者\n 1 sub.addObserver(new ConcreteObserver2()); // 添加观察者 \n2 sub.doSomething();\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "运行结果：\n" +
                "\n" +
                "被观察者事件反生。\n" +
                "观察者 1 收到信息，并进行处理。\n" +
                "观察者 2 收到信息，并进行处理。\n" +
                "\n" +
                "通过运行结果可以看到，我们只调用了 Subject 的方法，但同时两个观察者的相关方法都被同时调用了。仔细看一下代码，其实很简单，无非就是在 Subject 类中关联一下 Observer 类，并且在 doSomething 方法中遍历一下 Observer 的 update 方法就行了。\n" +
                "观察者模式的优点:\n" +
                "观察者与被观察者之间是属于轻度的关联关系，并且是抽象耦合的，这样，对于两者来说都比较容易进行扩展。\n" +
                "观察者模式是一种常用的触发机制，它形成一条触发链，依次对各个观察者的方法进行处理。但同时，这也算是观察者模式一个缺点，由于是链式触发，当观察者比较多的时候，性能问题是比较令人担忧的。并且，在链式结构中，比较容易出现循环引用的错误，造成系统假死。\n" +
                "总结：\n" +
                "java 语言中，有一个接口 Observer，以及它的实现类 Observable，对观察者角色常进行了实现。我们可以在 jdk 的 api 文档具体查看这两个类的使用方法。\n" +
                "做过 VC++、javascript、DOM 或者 AWT 开发的朋友都对它们的事件处理感到神奇，了解了观察者模式，就对事件处理机制的原理有了一定的了解了。如果要设计一个事件触发处理机制的功能，使用观察者模式是一个不错的选择，AWT 中的事件处理DEM（委派事件模型 Delegation\n" +
                " \n" +
                "Event Model）就是使用观察者模式实现的。\n" +
                "\n\n\n\n\n\n\n\n\n\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}