package com.xyx.javadesignmode.ui.b22;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("23 种设计模式（22）：享元模式\n" +
                "概述：\n" +
                "运用共享技术有效地支持大量细粒度的对象。类型：结构型模式。\n" +
                "类图：\n" +
                "[code=img]design/flyweight.png\n" +
                "适用性：\n" +
                "当都具备下列情况时，使用 Flyweight 模式：\n" +
                "1、一个应用程序使用了大量的对象。\n" +
                "2、完全由于使用大量的对象，造成很大的存储开销。\n" +
                "3、对象的大多数状态都可变为外部状态。\n" +
                "4、如果删除对象的外部状态，那么可以用相对较少的共享对象取代很多组对象。\n" +
                "5、应用程序不依赖于对象标识。由于 Flyweight 对象可以被共享，对于概念上明显有别的对象，标识测试将返回真值。\n" +
                "参与者：\n" +
                "1、Flyweight\n" +
                "描述一个接口，通过这个接口 flyweight 可以接受并作用于外部状态。\n" +
                "2、ConcreteFlyweight\n" +
                "实现 Flyweight 接口，并为内部状态（如果有的话）增加存储空间。\n" +
                "ConcreteFlyweight 对象必须是可共享的。它所存储的状态必须是内部的；即，它必须独立于 ConcreteFlyweight 对象的场景。\n" +
                "3、UnsharedConcreteFlyweight\n" +
                "并非所有的 Flyweight 子类都需要被共享。Flyweight 接口使共享成为可能，但它并不强制共享。\n" +
                "在 Flyweight 对象结 构的某些层次， UnsharedConcreteFlyweight 对象通常将 \n" +
                "ConcreteFlyweight 对象作为子节点。\n" +
                "4、FlyweightFactory\n" +
                "创建并管理 flyweight 对象。\n" +
                "确保合理地共享 flyweight。当用户请求一个 flyweight 时，FlyweightFactory 对象提供一个已创建的实例或者创建一个（如果不存在的话）。\n" +
                "例子：\n" +
                "\n" +
                "public interface Flyweight {\n" +
                "\n" +
                "void action(int arg);\n" +
                "}\n" +
                "\n" +
                "public class FlyweightImpl implements Flyweight {\npublic void action(int arg) {\n" +
                " \n" +
                "System.out.println(\"参数值: \" + arg);\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class FlyweightFactory {\n" +
                "private static Map flyweights = new HashMap(); public FlyweightFactory(String arg) {\n" +
                "flyweights.put(arg, new FlyweightImpl());\n" +
                "}\n" +
                "\n" +
                "public static Flyweight getFlyweight(String key) {\nif (flyweights.get(key) == null) {\n" +
                "flyweights.put(key, new FlyweightImpl());\n" +
                "}\n" +
                "return (Flyweight) flyweights.get(key);\n" +
                "}\n" +
                "\n" +
                "public static int getSize() {\nreturn flyweights.size();\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Test {\n" +
                "\n" +
                "public static void main(String[] args) {\n" +
                "Flyweight fly1 = FlyweightFactory.getFlyweight(\"a\"); fly1.action(1);\n" +
                "\n" +
                "Flyweight fly2 = FlyweightFactory.getFlyweight(\"a\"); System.out.println(fly1 == fly2);\n" +
                "\n" +
                "Flyweight fly3 = FlyweightFactory.getFlyweight(\"b\"); fly3.action(2);\n" +
                "\n" +
                "Flyweight fly4 = FlyweightFactory.getFlyweight(\"c\"); fly4.action(3);\n" +
                "\n" +
                "Flyweight fly5 = FlyweightFactory.getFlyweight(\"d\"); fly4.action(4);\n" +
                "\n" +
                "System.out.println(FlyweightFactory.getSize());\n" +
                "}\n" +
                " \n" +
                "}\n" +
                "\n" +
                "result：\n" +
                "\n" +
                "参数值: 1 true\n" +
                "参数值: 2\n" +
                "参数值: 3\n" +
                "参数值: 4\n" +
                "4\n\n\n\n\n\n\n\n\n\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}