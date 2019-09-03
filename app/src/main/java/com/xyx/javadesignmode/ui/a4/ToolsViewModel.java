package com.xyx.javadesignmode.ui.a4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("设计模式六大原则（4）：\n" +
                "定义：客户端不应该依赖它不需要的接口；一个类对另一个类的依赖应该建立在最小的接口上。\n" +
                "问题由来：类 A 通过接口 I 依赖类 B，类 C 通过接口 I 依赖类 D，如果接口 I 对于类 A 和类 B\n" +
                "来说不是最小接口，则类 B 和类D 必须去实现他们不需要的方法。\n" +
                "解决方案：将臃肿的接口 I 拆分为独立的几个接口，类 A 和类 C 分别与他们需要的接口建立依赖关系。也就是采用。\n" +
                "举例来说明：\n" +
                "[code=img]design/interface01.jpg\n" +
                "（图 1\t未遵循的设计）\n" +
                "这个图的意思是：类 A 依赖接口 I 中的方法 1、方法 2、方法 3，类 B 是对类 A 依赖的实现。类 C 依赖接口 I 中的方法 1、方法 4、方法 5，类 D 是对类 C 依赖的实现。对于类 B 和类 D 来说，虽然他们都存在着用不到的方法（也就是图中红色字体标记的方法），但由于实现了接口\n" +
                "I，所以也必须要实现这些用不到的方法。对类图不熟悉的可以参照程序代码来理解，代码如下：\n" +
                "\n" +
                "interface I {\n" +
                "public void method1(); \npublic void method2(); \npublic void method3(); \npublic void method4();\n public void method5();\n" +
                "}\n" +
                "\n" +
                "class A {\n" +
                "public void depend1(I i) { \ni.method1();\n" +
                "}\n" +
                "public void depend2(I i) { \ni.method2();\n" +
                "}\n" +
                "public void depend3(I i) { \ni.method3();\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "class B implements I { \npublic void method1() {\n" +
                "System.out.println(\"类 B 实现接口I 的方法 1\");\n" +
                "}\n" +
                " \n" +
                "\n" +
                "public void method2() {\n" +
                "System.out.println(\"类 B 实现接口I 的方法 2\");\n" +
                "}\n" +
                "\n" +
                "public void method3() {\n" +
                "System.out.println(\"类 B 实现接口I 的方法 3\");\n" +
                "} // 对于类 B 来说，method4 和 method5 不是必需的，但是由于接口 A 中有这两个方法，\n" +
                "\n" +
                "// 所以在实现过程中即使这两个方法的方法体为空，也要将这两个没有作用的方法进行实现。\n" +
                "public void method4() {\n" +
                "}\n" +
                "\n" +
                "public void method5() {\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "class C {\n" +
                "public void depend1(I i) { \ni.method1();\n" +
                "}\n" +
                "\n" +
                "public void depend2(I i) {\n i.method4();\n" +
                "}\n" +
                "\n" +
                "public void depend3(I i) {\n i.method5();\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "class D implements I { \npublic void method1() {\n" +
                "System.out.println(\"类 D 实现接口I 的方法 1\");\n" +
                "}\n" +
                "\n" +
                "// 对于类 D 来说，method2 和 method3 不是必需的，但是由于接口 A 中有这两个方法，\n" +
                "// 所以在实现过程中即使这两个方法的方法体为空，也要将这两个没有作用的方法进行实现。\n" +
                "public void method2() {\n" +
                "}\n" +
                "\n" +
                "public void method3() {\n" +
                " \n" +
                "}\n" +
                "\n" +
                "public void method4() {\n" +
                "System.out.println(\"类 D 实现接口I 的方法 4\");\n" +
                "}\n" +
                "\n" +
                "public void method5() {\n" +
                "System.out.println(\"类 D 实现接口I 的方法 5\");\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Client {\n" +
                "public static void main(String[] args) { \nA a = new A();\n" +
                "a.depend1(new B());\n" +
                "a.depend2(new B());\n" +
                "a.depend3(new B());\n" +
                "\n" +
                "C c = new C(); c.depend1(new D());\n" +
                "c.depend2(new D());\n" +
                "c.depend3(new D());\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "可以看到，如果接口过于臃肿，只要接口中出现的方法，不管对依赖于它的类有没有用处， 实现类中都必须去实现这些方法，这显然不是好的设计。如果将这个设计修改为符合，就必须对接口 I 进行拆分。在这里我们将原有的接口 I 拆分为三个接口，拆分后的设计如图 2 所示：\n" +
                "[code=img]design/interface02.jpg\n" +
                "（图 2 遵循的设计）\n" +
                "照例贴出程序的代码，供不熟悉类图的朋友参考：\n" +
                "\n" +
                "interface I1 {\n" +
                "public void method1();\n" +
                "}\n" +
                "\n" +
                "interface I2 {\n" +
                "public void method2();\n" +
                "\n" +
                "public void method3();\n" +
                "}\n" +
                "\n" +
                "interface I3 {\n" +
                " \n" +
                "public void method4();\n" +
                "\n" +
                "public void method5();\n" +
                "}\n" +
                "\n" +
                "class A {\n" +
                "public void depend1(I1 i) {\n i.method1();\n" +
                "}\n" +
                "\n" +
                "public void depend2(I2 i) { \ni.method2();\n" +
                "}\n" +
                "\n" +
                "public void depend3(I2 i) { \ni.method3();\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "class B implements I1, I2 { \npublic void method1() {\n" +
                "System.out.println(\"类 B 实现接口 I1 的方法 1\");\n" +
                "}\n" +
                "\n" +
                "public void method2() {\n" +
                "System.out.println(\"类 B 实现接口 I2 的方法 2\");\n" +
                "}\n" +
                "\n" +
                "public void method3() {\n" +
                "System.out.println(\"类 B 实现接口 I2 的方法 3\");\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "class C {\n" +
                "public void depend1(I1 i) { \ni.method1();\n" +
                "}\n" +
                "\n" +
                "public void depend2(I3 i) { \ni.method4();\n" +
                "}\n" +
                "\n" +
                "public void depend3(I3 i) { \ni.method5();\n" +
                " \n" +
                "}\n" +
                "}\n" +
                "\n" +
                "class D implements I1, I3 {\n public void method1() {\n" +
                "System.out.println(\"类 D 实现接口 I1 的方法 1\");\n" +
                "}\n" +
                "\n" +
                "public void method4() {\n" +
                "System.out.println(\"类 D 实现接口 I3 的方法 4\");\n" +
                "}\n" +
                "\n" +
                "public void method5() {\n" +
                "System.out.println(\"类 D 实现接口 I3 的方法 5\");\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "的含义是：建立单一接口，不要建立庞大臃肿的接口，尽量细化接口，接口中的方法尽量少。也就是说，我们要为各个类建立专用的接口，而不要试图去建立一个很庞大的接口供所有依赖它的类去调用。本文例子中，将一个庞大的接口变更为 3 个专用的接口所采用的就是。在程序设计中，依赖几个专用的接口要比依赖一个综合的接口更灵活。接口是设计时对外部设定的“契约”，通过分散定义多个接口，可以预防外来变更的扩散，提高系统的灵活性和可维护性。\n" +
                "说到这里，很多人会觉的跟之前的单一职责原则很相似，其实不然。其一，单一职责原则原注重的是职责；而注重对接口依赖的隔离。其二，单一职责原则主要是约束类，其次才是接口和方法，它针对的是程序中的实现和细节；而主要约束接口接口，主要针对抽象，针对程序整体框架的构建。\n" +
                "采用对接口进行约束时，要注意以下几点：\n" +
                "1、接口尽量小，但是要有限度。对接口进行细化可以提高程序设计灵活性是不挣的事实，但是如果过小，则会造成接口数量过多，使设计复杂化。所以一定要适度。\n" +
                "2、为依赖接口的类定制服务，只暴露给调用的类它需要的方法，它不需要的方法则隐藏起来。只有专注地为一个模块提供定制服务，才能建立最小的依赖关系。\n" +
                "3、提高内聚，减少对外交互。使接口用最少的方法去完成最多的事情。\n" +
                "4、运用，一定要适度，接口设计的过大或过小都不好。设计接口的时候，只有多花些时间去思考和筹划，才能准确地实践这一原则。\n" +
                "\n\n\n\n\n\n\n\n\n\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}