package com.xyx.javadesignmode.ui.b5;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("23 种设计模式（5）：原型模式\n" +
                "\n" +
                "定义：用原型实例指定创建对象的种类，并通过拷贝这些原型创建新的对象。类型：创建类模式。\n" +
                "类图：\n" +
                "[code=img]design/protype.jpg\n" +
                "原型模式主要用于对象的复制，它的核心是就是类图中的原型类 Prototype。Prototype 类需要具备以下两个条件：\n" +
                "实现 Cloneable 接口。在 java 语言有一个 Cloneable 接口，它的作用只有一个，就是在运行时通知虚拟机可以安全地在实现了此接口的类上使用 clone 方法。在 java 虚拟机中，只有实现了这个接口的类才可以被拷贝，否则在运行时会抛出 CloneNotSupportedException 异常。重写 Object 类中的 clone 方法。Java 中，所有类的父类都是 Object 类，Object 类中有一个\n" +
                "clone 方法，作用是返回对象的一个拷贝，但是其作用域 protected 类型的，一般的类无法调用，因此，Prototype 类需要将 clone 方法的作用域修改为 public 类型。\n" +
                "原型模式是一种比较简单的模式，也非常容易理解，实现一个接口，重写一个方法即完成了原型模式。在实际应用中，原型模式很少单独出现。经常与其他模式混用，他的原型类\n" +
                "Prototype 也常用抽象类来替代。实现代码：\n" +
                "\n" +
                "class Prototype implements Cloneable {\n public Prototype2 clone() {\n" +
                "Prototype2 prototype = null; try {\n" +
                "prototype = (Prototype2) super.clone();\n" +
                "} catch (CloneNotSupportedException e) {\n e.printStackTrace();\n" +
                "}\n" +
                "return prototype;\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "class ConcretePrototype extends Prototype2 {\n public void show() {\n" +
                " \n" +
                "System.out.println(\"原型模式实现类\");\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Client {\n" +
                "public static void main(String[] args) { \nConcretePrototype cp = new ConcretePrototype();\n for (int i = 0; i < 10; i++) {\n" +
                "ConcretePrototype clonecp = (ConcretePrototype) cp.clone();\n clonecp.show();\n" +
                "}\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "原型模式的优点及适用场景：\n" +
                "使用原型模式创建对象比直接 new 一个对象在性能上要好的多，因为 Object 类的 clone 方法是一个本地方法，它直接操作内存中的二进制流，特别是复制大对象时，性能的差别非常明显。\n" +
                "使用原型模式的另一个好处是简化对象的创建，使得创建对象就像我们在编辑文档时的复制粘贴一样简单。\n" +
                "因为以上优点，所以在需要重复地创建相似对象时可以考虑使用原型模式。比如需要在一个循环体内创建对象，假如对象创建过程比较复杂或者循环次数很多的话，使用原型模式不但可以简化创建过程，而且可以使系统的整体性能提高很多。\n" +
                "原型模式的注意事项：\n" +
                "使用原型模式复制对象不会调用类的构造方法。因为对象的复制是通过调用 Object 类的\n" +
                "clone 方法来完成的，它直接在内存中复制数据，因此不会调用到类的构造方法。不但构造方法中的代码不会执行，甚至连访问权限都对原型模式无效。还记得单例模式吗？单例模式中，只要将构造方法的访问权限设置为 private 型，就可以实现单例。但是 clone 方法直接无视构造方法的权限，所以，单例模式与原型模式是冲突的，在使用时要特别注意。\n" +
                "深拷贝与浅拷贝。Object 类的 clone 方法只会拷贝对象中的基本的数据类型，对于数组、容器对象、引用对象等都不会拷贝，这就是浅拷贝。如果要实现深拷贝，必须将原型模式中的数组、容器对象、引用对象等另行拷贝。例如：\n" +
                "\n" +
                "import java.util.ArrayList;\n" +
                "\n" +
                "public class Prototype implements Cloneable {\n private ArrayList list = new ArrayList();\n" +
                "\n" +
                "public Prototype clone() { \nPrototype prototype = null; try {\n" +
                "prototype = (Prototype) super.clone(); \nprototype.list = (ArrayList) this.list.clone();\n" +
                "} catch (CloneNotSupportedException e) {\n" +
                " \n" +
                "e.printStackTrace();\n" +
                "}\n" +
                "return prototype;\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "由于 ArrayList 不是基本类型，所以成员变量 list，不会被拷贝，需要我们自己实现深拷贝，幸运的是 java 提供的大部分的容器类都实现了 Cloneable 接口。所以实现深拷贝并不是特别困难。\n" +
                "PS：深拷贝与浅拷贝问题中，会发生深拷贝的有java 中的8 种基本类型以及他们的封装类型，另外还有 String 类型。其余的都是浅拷贝。\n" +
                "\n" +
                "创建型模式总结\n" +
                "\n" +
                "创建类模式主要关注对象的创建过程，将对象的创建过程进行封装，使客户端可以直接得到对象，而不用去关心如何创建对象。创建类模式有 5 种，分别是：\n" +
                "单例模式：用于得到内存中的唯一对象。工厂方法模式：用于创建复杂对象。\n" +
                "抽象工厂模式：用于创建一组相关或相互依赖的复杂对象。建造者模式：用于创建模块化的更加复杂的对象。\n" +
                "原型模式：用于得到一个对象的拷贝。\n" +
                "为什么需要创建性模式：\n" +
                "首先，在编程中，对象的创建通常是一件比较复杂的事，因为，为了达到降低耦合的目的， 我们通常采用面向抽象编程的方式，对象间的关系不会硬编码到类中，而是等到调用的时候再进行组装，这样虽然降低了对象间的耦合，提高了对象复用的可能，但在一定程度上将组装类的任务都交给了最终调用的客户端程序，大大增加了客户端程序的复杂度。采用创建类模式的优点之一就是将组装对象的过程封装到一个单独的类中，这样，既不会增加对象间的耦合，又可以最大限度的减小客户端的负担。\n" +
                "其次，使用普通的方式创建对象，一般都是返回一个具体的对象，即所谓的面向实现编程， 这与设计模式原则是相违背的。采用创建类模式则可以实现面向抽象编程。客户端要求的只是一个抽象的类型，具体返回什么样的对象，由创建者来决定。\n" +
                "再次，可以对创建对象的过程进行优化，客户端关注的只是得到对象，对对象的创建过程则不关心，因此，创建者可以对创建的过程进行优化，例如在特定条件下，如果使用单例模式或者是使用原型模式，都可以优化系统的性能。\n" +
                "总结：\n" +
                "所有的创建类模式本质上都是对对象的创建过程进行封装。\n\n\n\n\n\n\n\n\n\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}