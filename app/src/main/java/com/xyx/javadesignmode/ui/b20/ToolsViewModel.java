package com.xyx.javadesignmode.ui.b20;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("23 种设计模式（20）：外观模式\n" +
                "\n" +
                "概述：\n" +
                "为子系统中的一组接口提供一个一致的界面，Facade 模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。\n" +
                "类型：结构型模式。 \n" +

                "1、当你要为一个复杂子系统提供一个简单接口时。子系统往往因为不断演化而变得越来越复杂。大多数模式使用时都会产生更多更小的类。这使得子系统更具可重用性，也更容易对子系统进行定制，但这也给那些不需要定制子系统的用户带来一些使用上的困难。\n" +
                "Facade 可以提供一个简单的缺省视图，这一视图对大多数用户来说已经足够，而那些需要更多的可定制性的用户可以越过 facade 层。\n" +
                "2、客户程序与抽象类的实现部分之间存在着很大的依赖性。引入 facade 将这个子系统与客户以及其他的子系统分离，可以提高子系统的独立性和可移植性。\n" +
                "3、当你需要构建一个层次结构的子系统时，使用 facade 模式定义子系统中每层的入口点。\n" +
                " \n" +
                "如果子系统之间是相互依赖的，你可以让它们仅通过 facade 进行通讯，从而简化了它们之间的依赖关系。\n" +
                "参与者：\n" +
                "1、Facade\n" +
                "知道哪些子系统类负责处理请求。\n" +
                "将客户的请求代理给适当的子系统对象。\n" +
                "2、Subsystemclasses\n" +
                "实现子系统的功能。\n" +
                "处理由 Facade 对象指派的任务。\n" +
                "没有 facade 的任何相关信息；即没有指向 facade 的指针。例子：\n" +
                "public class Facade {\nServiceA sa; ServiceB sb; ServiceC sc; public Facade() {\n" +
                "sa = new ServiceAImpl();\n" +
                "sb = new ServiceBImpl(); sc = new ServiceCImpl();\n" +
                "}\n" +
                "\n" +
                "public void methodA() {\nsa.methodA();\n" +
                "sb.methodB();\n" +
                "}\n" +
                "\n" +
                "public void methodB() {\nsb.methodB();\n" +
                "sc.methodC();\n" +
                "}\n" +
                "\n" +
                "public void methodC() {\nsc.methodC();\n" +
                "sa.methodA();\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class ServiceAImpl implements ServiceA {\n" +
                " \n" +
                "public void methodA() {\n" +
                "System.out.println(\"这是服务 A\");\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class ServiceBImpl implements ServiceB {\n" +
                "\n" +
                "public void methodB() {\n" +
                "System.out.println(\"这是服务 B\");\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class ServiceCImpl implements ServiceC {\n" +
                "\n" +
                "public void methodC() {\n" +
                "System.out.println(\"这是服务 C\");\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Test {\n" +
                "\n" +
                "public static void main(String[] args) {\nServiceA sa = new ServiceAImpl(); ServiceB sb = new ServiceBImpl();\n" +
                "\n" +
                "sa.methodA();\n" +
                "sb.methodB();\n" +
                "\n" +
                "System.out.println(\"========\");\n" +
                "// facade\n" +
                "Facade facade = new Facade(); facade.methodA(); facade.methodB();\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "result：\n" +
                "\n" +
                "这是服务 A\n" +
                "这是服务 B\n" +
                "========\n" +
                "这是服务 A 这是服务 B 这是服务 B\n" +
                " \n" +
                "这是服务 C\n" +
                "\n\n\n\n\n\n\n\n\n\n" +
                "\n" +
                "\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}