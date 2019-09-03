package com.xyx.javadesignmode.ui.b21;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("23 种设计模式（21）：装饰模式\n" +
                "概述：\n" +
                "动态地给一个对象添加一些额外的职责。就增加功能来说，Decorator 模式相比生成子类更为灵活。\n" +
                "类型：结构型模式。"  +
                "适用性：\n" +
                "1、在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。\n" +
                "2、处理那些可以撤消的职责。\n" +
                "3、当不能采用生成子类的方法进行扩充时。\n" +
                "参与者：\n" +
                "1、Component\n" +
                "定义一个对象接口，可以给这些对象动态地添加职责。\n" +
                "2、ConcreteComponent\n" +
                "定义一个对象，可以给这个对象添加一些职责。\n" +
                "3、Decorator\n" +
                "维持一个指向 Component 对象的指针，并定义一个与 Component 接口一致的接口。\n" +
                "4、ConcreteDecorator\n" +
                "向组件添加职责。\n" +
                " \n" +
                "例子：\n" +
                "\n" +
                "public interface Person {\n" +
                "\n" +
                "void eat();\n" +
                "}\n" +
                "\n" +
                "\n" +
                "public class Man implements Person {\n" +
                "\n" +
                "public void eat() {\n" +
                "System.out.println(\"男人在吃\");\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public abstract class Decorator implements Person { protected Person person;\n" +
                "public void setPerson(Person person) { this.person = person;\n" +
                "}\n" +
                "\n" +
                "public void eat() { person.eat();\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class ManDecoratorA extends Decorator {\n" +
                "\n" +
                "public void eat() { super.eat();\n" +
                "reEat();\n" +
                "System.out.println(\"ManDecoratorA 类\");\n" +
                "}\n" +
                "\n" +
                "public void reEat() {\n" +
                "System.out.println(\"再吃一顿饭\");\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class ManDecoratorB extends Decorator { public void eat() {\n" +
                " \n" +
                "super.eat(); System.out.println(\"===============\"); System.out.println(\"ManDecoratorB??\");\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Test {\n" +
                "\n" +
                "public static void main(String[] args) { Man man = new Man();\n" +
                "ManDecoratorA md1 = new ManDecoratorA(); ManDecoratorB md2 = new ManDecoratorB();\n" +
                "\n" +
                "md1.setPerson(man); md2.setPerson(md1); md2.eat();\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "result：\n" +
                "\n" +
                "男人在吃 再吃一顿饭\n" +
                "ManDecoratorA 类\n" +
                "===============\n" +
                "ManDecoratorB 类\n\n\n\n\n\n\n\n\n\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}