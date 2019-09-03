package com.xyx.javadesignmode.ui.b7;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("23 种设计模式（7）：中介者模式\n" +
                "定义：用一个中介者对象封装一系列的对象交互，中介者使各对象不需要显示地相互作用， 从而使耦合松散，而且可以独立地改变它们之间的交互。\n" +
                "类型：行为类模式。类图：\n" +
                "[code=img]design/mediate01.jpg\n" +
                "中介者模式的结构：\n" +
                "中介者模式又称为调停者模式，从类图中看，共分为 3 部分：\n" +
                "抽象中介者：定义好同事类对象到中介者对象的接口，用于各个同事类之间的通信。一般包括一个或几个抽象的事件方法，并由子类去实现。\n" +
                "中介者实现类：从抽象中介者继承而来，实现抽象中介者中定义的事件方法。从一个同事类接收消息，然后通过消息影响其他同时类。\n" +
                "同事类：如果一个对象会影响其他的对象，同时也会被其他对象影响，那么这两个对象称为同事类。在类图中，同事类只有一个，这其实是现实的省略，在实际应用中，同事类一般由多个组成，他们之间相互影响，相互依赖。同事类越多，关系越复杂。并且，同事类也可以表现为继承了同一个抽象类的一组实现组成。在中介者模式中，同事类之间必须通过中介者才能进行消息传递。\n" +
                "为什么要使用中介者模式：\n" +
                "一般来说，同事类之间的关系是比较复杂的，多个同事类之间互相关联时，他们之间的关系会呈现为复杂的网状结构，这是一种过度耦合的架构，即不利于类的复用，也不稳定。例如在下图中，有六个同事类对象，假如对象 1 发生变化，那么将会有 4 个对象受到影响。如果\n" +
                "对象 2 发生变化，那么将会有 5 个对象受到影响。也就是说，同事类之间直接关联的设计是不好的。\n" +
                "[code=img]design/mediate02.jpg [code=img]design/mediate03.jpg\n" +
                "如果引入中介者模式，那么同事类之间的关系将变为星型结构，从图中可以看到，任何一个类的变动，只会影响的类本身，以及中介者，这样就减小了系统的耦合。一个好的设计，必定不会把所有的对象关系处理逻辑封装在本类中，而是使用一个专门的类来管理那些不属于自己的行为。\n" +
                "[code=img]design/mediate04.jpg\n" +
                "我们使用一个例子来说明一下什么是同事类：有两个类 A 和 B，类中各有一个数字，并且要保证类 B 中的数字永远是类 A 中数字的 100 倍。也就是说，当修改类 A 的数时，将这个数字\n" +
                " \n" +
                "乘以 100 赋给类 B，而修改类 B 时，要将数除以 100 赋给类 A。类 A 类 B 互相影响，就称为同事类。\n" +
                "代码如下：\n" +
                "\n" +
                "abstract class AbstractColleague { \nprotected int number;\n" +
                "\n" +
                "public int getNumber() {\n return number;\n" +
                "}\n" +
                "\n" +
                "public void setNumber(int number) { \nthis.number = number;\n" +
                "}\n" +
                "\n" +
                "// 抽象方法，修改数字时同时修改关联对象\n" +
                "public abstract void setNumber(int number, AbstractColleague coll);\n" +
                "}\n" +
                "\n" +
                "class ColleagueA extends AbstractColleague {\n" +
                "public void setNumber(int number, AbstractColleague coll) { \nthis.number = number;\n" +
                "coll.setNumber(number * 100);\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "class ColleagueB extends AbstractColleague {\n" +
                "\n" +
                "public void setNumber(int number, AbstractColleague coll) { \nthis.number = number;\n" +
                "coll.setNumber(number / 100);\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Client2 {\n" +
                "public static void main(String[] args) {\n" +
                "\n" +
                "AbstractColleague collA = new ColleagueA(); \nAbstractColleague collB = new ColleagueB();\n" +
                "\n" +
                "System.out.println(\"==========设置 A 影响 B==========\"); collA.setNumber(1288, collB);\n" +
                "System.out.println(\"collA 的 number 值：\" + collA.getNumber());\n" +
                "System.out.println(\"collB 的 number 值：\" + collB.getNumber());\n" +
                " \n" +
                "\n" +
                "System.out.println(\"==========设置 B 影响 A==========\"); \ncollB.setNumber(87635, collA);\n" +
                "System.out.println(\"collB 的 number 值：\" + collB.getNumber());\n" +
                "System.out.println(\"collA 的 number 值：\" + collA.getNumber());\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "上面的代码中，类 A 类 B 通过直接的关联发生关系，假如我们要使用中介者模式，类 A 类 B\n" +
                "之间则不可以直接关联，他们之间必须要通过一个中介者来达到关联的目的。\n" +
                "\n" +
                "abstract class AbstractColleague2 {\n protected int number;\n" +
                "\n" +
                "public int getNumber() { \nreturn number;\n" +
                "}\n" +
                "\n" +
                "public void setNumber(int number) { \nthis.number = number;\n" +
                "}\n" +
                "\n" +
                "// 注意这里的参数不再是同事类，而是一个中介者\n" +
                "public abstract void setNumber(int number, AbstractMediator am);\n" +
                "}\n" +
                "\n" +
                "class ColleagueA2 extends AbstractColleague2 {\n" +
                "\n" +
                "public void setNumber(int number, AbstractMediator am) { \nthis.number = number;\n" +
                "am.AaffectB();\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "class ColleagueB2 extends AbstractColleague2 {\n" +
                "\n" +
                "@Override\n" +
                "public void setNumber(int number, AbstractMediator am) { \nthis.number = number;\n" +
                "am.BaffectA();\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "abstract class AbstractMediator {\n" +
                " \n" +
                "protected AbstractColleague2 A; protected AbstractColleague2 B;\n" +
                "\n" +
                "public AbstractMediator(AbstractColleague2 a, AbstractColleague2 b) {\n A = a;\n" +
                "B = b;\n" +
                "}\n" +
                "\n" +
                "public abstract void AaffectB();\n public abstract void BaffectA();\n" +
                "}\n" +
                "\n" +
                "class Mediator extends AbstractMediator {\n" +
                "\n" +
                "public Mediator(AbstractColleague2 a, AbstractColleague2 b) {\n super(a, b);\n" +
                "}\n" +
                "\n" +
                "// 处理 A 对 B 的影响\n" +
                "public void AaffectB() {\n" +
                "int number = A.getNumber(); B.setNumber(number * 100);\n" +
                "}\n" +
                "\n" +
                "// 处理 B 对 A 的影响\n" +
                "public void BaffectA() {\n" +
                "int number = B.getNumber(); A.setNumber(number / 100);\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Client3 {\n" +
                "public static void main(String[] args) { \nAbstractColleague2 collA = new ColleagueA2(); \nAbstractColleague2 collB = new ColleagueB2();\n" +
                "\n" +
                "AbstractMediator am = new Mediator(collA, collB);\n" +
                "\n" +
                "System.out.println(\"==========通过设置 A 影响B==========\"); collA.setNumber(1000, am);\n" +
                "System.out.println(\"collA 的 number 值为：\" + collA.getNumber());\n" +
                "System.out.println(\"collB 的 number 值为 A 的 10 倍：\" + collB.getNumber());\n" +
                " \n" +
                "\n" +
                "System.out.println(\"==========通过设置 B 影响A==========\"); collB.setNumber(1000, am);\n" +
                "System.out.println(\"collB 的 number 值为：\" + collB.getNumber());\n" +
                "System.out.println(\"collA 的 number 值为 B 的 0.1 倍：\" + collA.getNumber());\n" +
                "\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "虽然代码比较长，但是还是比较容易理解的，其实就是把原来处理对象关系的代码重新封装到一个中介类中，通过这个中介类来处理对象间的关系。\n" +
                "中介者模式的优点：\n" +
                "1、适当地使用中介者模式可以避免同事类之间的过度耦合，使得各同事类之间可以相对独立地使用。\n" +
                "2、使用中介者模式可以将对象间一对多的关联转变为一对一的关联，使对象间的关系易于理解和维护。\n" +
                "3、使用中介者模式可以将对象的行为和协作进行抽象，能够比较灵活的处理对象间的相互作用。\n" +
                "适用场景:\n" +
                "1、在面向对象编程中，一个类必然会与其他的类发生依赖关系，完全独立的类是没有意义的。一个类同时依赖多个类的情况也相当普遍，既然存在这样的情况，说明，一对多的依赖关系有它的合理性，适当的使用中介者模式可以使原本凌乱的对象关系清晰，但是如果滥用，则可能会带来反的效果。一般来说，只有对于那种同事类之间是网状结构的关系，才会考虑使用中介者模式。可以将网状结构变为星状结构，使同事类之间的关系变的清晰一些。\n" +
                "2、中介者模式是一种比较常用的模式，也是一种比较容易被滥用的模式。对于大多数的情况， 同事类之间的关系不会复杂到混乱不堪的网状结构，因此，大多数情况下，将对象间的依赖关系封装的同事类内部就可以的，没有必要非引入中介者模式。滥用中介者模式，只会让事情变的更复杂。\n" +
                "\n\n\n\n\n\n\n\n\n\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}