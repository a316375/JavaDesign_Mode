package com.xyx.javadesignmode.ui.b4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("23 种设计模式（4）：建造者模式\n" +
                " \n" +
                "\n" +
                "定义：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。类型：创建类模式。\n" +
                "类 图 ： [code=img]design/builder.jpg 四个要素：\n" +
                "1，产品类：一般是一个较为复杂的对象，也就是说创建对象的过程比较复杂，一般会有比较多的代码量。在本类图中，产品类是一个具体的类，而非抽象类。实际编程中，产品类可以是由一个抽象类与它的不同实现组成，也可以是由多个抽象类与他们的实现组成。\n" +
                "2，抽象建造者：引入抽象建造者的目的，是为了将建造的具体过程交与它的子类来实现。这样更容易扩展。一般至少会有两个抽象方法，一个用来建造产品，一个是用来返回产品。\n" +
                "3，建造者：实现抽象类的所有未实现的方法，具体来说一般是两项任务：组建产品；返回组建好的产品。\n" +
                "4，导演类：负责调用适当的建造者来组建产品，导演类一般不与产品类发生依赖关系，与导演类直接交互的是建造者类。一般来说，导演类被用来封装程序中易变的部分。\n" +
                "代码实现\n" +
                "\n" +
                "class Product3  { \nprivate String name; private String type;\n" +
                "\n" +
                "public void showProduct() {\n" +
                "System.out.println(\"名称：\" + name);\n" +
                "System.out.println(\"型号：\" + type);\n" +
                "}\n" +
                "\n" +
                "public void setName(String name) { \nthis.name = name;\n" +
                "}\n" +
                "\n" +
                "public void setType(String type) { \nthis.type = type;\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "abstract class Builder {\n" +
                "public abstract void setPart(String arg1, String arg2);\n" +
                "\n" +
                "public abstract Product3 getProduct();\n" +
                "}\n" +
                "\n" +
                "class ConcreteBuilder extends Builder {\n private Product3 product = new Product3();\n" +
                " \n" +
                "public Product3 getProduct() { \nreturn product;\n" +
                "}\n" +
                "\n" +
                "public void setPart(String arg1, String arg2) {\n product.setName(arg1); product.setType(arg2);\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Director {\n" +
                "private Builder builder = new ConcreteBuilder();\n" +
                "\n" +
                "public Product3 getAProduct() {\n" +
                "builder.setPart(\"宝马汽车\", \"X7\");\n return builder.getProduct();\n" +
                "}\n" +
                "\n" +
                "public Product3 getBProduct() {\n" +
                "builder.setPart(\"奥迪汽车\", \"Q5\"); \nreturn builder.getProduct();\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Client3 {\n" +
                "public static void main(String[] args) { \nDirector director = new Director();\n Product3 product1 = director.getAProduct();\n product1.showProduct();\n" +
                "\n" +
                "Product3 Product3 = director.getBProduct();\n Product3.showProduct();\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "建造者模式的优点：\n" +
                "首先，建造者模式的封装性很好。使用建造者模式可以有效的封装变化，在使用建造者模式的场景中，一般产品类和建造者类是比较稳定的，因此，将主要的业务逻辑封装在导演类中对整体而言可以取得比较好的稳定性。\n" +
                "其次，建造者模式很容易进行扩展。如果有新的需求，通过实现一个新的建造者类就可以完成，基本上不用修改之前已经测试通过的代码，因此也就不会对原有功能引入风险。\n" +
                "建造者模式与工厂模式的区别：\n" +
                "我们可以看到，建造者模式与工厂模式是极为相似的，总体上，建造者模式仅仅只比工厂模式多了一个“导演类”的角色。在建造者模式的类图中，假如把这个导演类看做是最终调用\n" +
                " \n" +
                "的客户端，那么图中剩余的部分就可以看作是一个简单的工厂模式了。\n" +
                "与工厂模式相比，建造者模式一般用来创建更为复杂的对象，因为对象的创建过程更为复杂， 因此将对象的创建过程独立出来组成一个新的类——导演类。也就是说，工厂模式是将对象的全部创建过程封装在工厂类中，由工厂类向客户端提供最终的产品；而建造者模式中，建造者类一般只提供产品类中各个组件的建造，而将具体建造过程交付给导演类。由导演类负责将各个组件按照特定的规则组建为产品，然后将组建好的产品交付给客户端。\n" +
                "总结：\n" +
                "建造者模式与工厂模式类似，他们都是建造者模式，适用的场景也很相似。一般来说，如果产品的建造很复杂，那么请用工厂模式；如果产品的建造更复杂，那么请用建造者模式。\n\n\n\n\n\n\n\n\n\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}