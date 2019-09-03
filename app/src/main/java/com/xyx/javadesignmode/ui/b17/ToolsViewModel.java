package com.xyx.javadesignmode.ui.b17;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("23 种设计模式（17）：桥接模式\n" +
                "概述：\n" +
                "将抽象部分与它的实现部分分离，使它们都可以独立地变化。类型：结构型模式。\n" +
                "适用性：\n" +
                "1、你不希望在抽象和它的实现部分之间有一个固定的绑定关系。\n" +
                " \n" +
                "例如这种情况可能是因为，在程序运行时刻实现部分应可以被选择或者切换。\n" +
                "2、类的抽象以及它的实现都应该可以通过生成子类的方法加以扩充。\n" +
                "这时 Bridge 模式使你可以对不同的抽象接口和实现部分进行组合，并分别对它们进行扩充。\n" +
                "3、对一个抽象的实现部分的修改应对客户不产生影响，即客户的代码不必重新编译。\n" +
                "4、正如在意图一节的第一个类图中所示的那样，有许多类要生成。这样一种类层次结构说明你必须将一个对象分解成两个部分。\n" +
                "5、想在多个对象间共享实现（可能使用引用计数），但同时要求客户并不知道这一点。参与者：\n" +
                "1、Abstraction\n" +
                "定义抽象类的接口。\n" +
                "维护一个指向 Implementor 类型对象的指针。\n" +
                "2、RefinedAbstraction\n" +
                "扩充由 Abstraction 定义的接口。\n" +
                "3、Implementor\n" +
                "定义实现类的接口，该接口不一定要与 Abstraction 的接口完全一致。事实上这两个接口可以完全不同。\n" +
                "一般来讲，Implementor 接口仅提供基本操作，而 Abstraction 则定义了基于这些基本操作的较高层次的操作。\n" +
                "4、ConcreteImplementor\n" +
                "实现 Implementor 接口并定义它的具体实现。例子：\n" +
                "\n" +
                "public abstract class Person {  \nprivate Clothing clothing; private String type;\n" +
                "public Clothing getClothing() {  \nreturn clothing;\n" +
                "}\n" +
                "\n" +
                "public void setClothing() {\n" +
                "this.clothing = ClothingFactory.getClothing();\n" +
                "}\n" +
                "\n" +
                "public void setType(String type) {  \nthis.type = type;\n" +
                "}\n" +
                "\n" +
                "public String getType() {  \nreturn this.type;\n" +
                "}\n" +
                " \n" +
                "public abstract void dress();\n" +
                "}\n" +
                "\n" +
                "public class Man extends Person {\n" +
                "\n" +
                "public Man() {\n" +
                "setType(\"男人\");\n" +
                "}\n" +
                "\n" +
                "public void dress() {\n" +
                "Clothing clothing = getClothing(); \n clothing.personDressCloth(this);\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Lady extends Person {\n" +
                "\n" +
                "public Lady() {\n" +
                "setType(\"女人\");\n" +
                "}\n" +
                "\n" +
                "public void dress() {\n" +
                "Clothing clothing = getClothing();  \nclothing.personDressCloth(this);\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public abstract class Clothing {\n" +
                "\n" +
                "public abstract void personDressCloth(Person person);\n" +
                "}\n" +
                "\n" +
                "public class Jacket extends Clothing {\n" +
                "\n" +
                "public void personDressCloth(Person person) { \n System.out.println(person.getType() + \"穿马甲\");\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Trouser extends Clothing {\n" +
                "\n" +
                "public void personDressCloth(Person person) {  \nSystem.out.println(person.getType() + \"穿裤子\");\n" +
                "}\n" +
                " \n" +
                "}\n" +
                "\n" +
                "public class Test {\n" +
                "\n" +
                "public static void main(String[] args) {  \nPerson man = new Man();\n" +
                "Person lady = new Lady(); \n Clothing jacket = new Jacket(); \n Clothing trouser = new Trouser();\n" +
                "jacket.personDressCloth(man);  \ntrouser.personDressCloth(man);\n" +
                "\n" +
                "jacket.personDressCloth(lady); \n trouser.personDressCloth(lady);\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "result：\n" +
                "\n" +
                "男人穿马甲男人穿裤子女人穿马甲女人穿裤子\n\n\n\n\n\n\n\n\n\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}