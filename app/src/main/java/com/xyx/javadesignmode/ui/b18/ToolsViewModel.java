package com.xyx.javadesignmode.ui.b18;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("23 种设计模式（18）：适配器模式\n" +
                "概述：\n" +
                "将一个类的接口转换成客户希望的另外一个接口。Adapter 模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。\n" +
                "类型：结构型模式。\n" +

                "适用性：\n" +
                "1、你想使用一个已经存在的类，而它的接口不符合你的需求。\n" +
                "2、你想创建一个可以复用的类，该类可以与其他不相关的类或不可预见的类（即那些接口可能不一定兼容的类）协同工作。\n" +
                "3、（仅适用于对象 Adapter）你想使用一些已经存在的子类，但是不可能对每一个都进行子类化以匹配它们的接口。对象适配器可以适配它的父类接口。\n" +
                "参与者\n" +
                "1、Target\n" +
                "定义 Client 使用的与特定领域相关的接口。\n" +
                "2、Client\n" +
                "与符合 Target 接口的对象协同。\n" +
                "3、Adaptee\n" +
                "定义一个已经存在的接口，这个接口需要适配。\n" +
                "4、Adapter\n" +
                "对 Adaptee 的接口与 Target 接口进行适配。例子：\n" +
                "\n" +
                "public interface Target {\n \n void adapteeMethod();\n" +
                "void adapterMethod();\n" +
                "}\n" +
                "\n" +
                "public class Adaptee {\n" +
                "\n" +
                "public void adapteeMethod() {\n  System.out.println(\"Adaptee method!\");\n" +
                "}\n" +
                " \n" +
                "}\n" +
                "\n" +
                "\n" +
                "public class Adapter implements Target {\n private Adaptee adaptee;\n" +
                "public Adapter(Adaptee adaptee) {\n this.adaptee = adaptee;\n" +
                "}\n" +
                "\n" +
                "public void adapteeMethod() {\n adaptee.adapteeMethod();\n" +
                "}\n" +
                "\n" +
                "public void adapterMethod() {\n System.out.println(\"Adapter method!\");\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Test {\n\n" +
                "\n" +
                "public static void main(String[] args) {\n  Target target = new Adapter(new Adaptee()); target.adapteeMethod();\n" +
                "\n" +
                "target.adapterMethod();\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "result：\n" +
                "\n" +
                "Adaptee method! Adapter method!\n" +
                "\n" +
                "\n\n\n\n\n\n\n\n\n\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}