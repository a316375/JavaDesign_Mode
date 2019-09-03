package com.xyx.javadesignmode.ui.b16;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("23 种设计模式（16）：状态模式\n" +
                "概述\n" +
                "定义对象间的一种一对多的依赖关系,当一个对象的状态发生改变时,所有依赖于它的对象都得到通知并被自动更新。\n" +
                "类型：行为类模式。类图：\n" +
                "[code=img]design/state.png\n" +
                "适用性：\n" +
                "1、一个对象的行为取决于它的状态,并且它必须在运行时刻根据状态改变它的行为。\n" +
                "2、一个操作中含有庞大的多分支的条件语句，且这些分支依赖于该对象的状态。这个状态通常用一个或多个枚举常量表示。\n" +
                "通常，有多个操作包含这一相同的条件结构。\n" +
                "State 模式将每一个条件分支放入一个独立的类中。\n" +
                "这使得你可以根据对象自身的情况将对象的状态作为一个对象，这一对象可以不依赖于其他对象而独立变化。\n" +
                "参与者\n" +
                "1、Context\n" +
                "定义客户感兴趣的接口。\n" +
                "维护一个 ConcreteState 子类的实例，这个实例定义当前状态。\n" +
                "2、State\n" +
                "定义一个接口以封装与 Context 的一个特定状态相关的行为。\n" +
                "3、ConcreteStatesubclasses\n" +
                "每一子类实现一个与 Context 的一个状态相关的行为。例子：\n" +
                "\n" +
                "public class Context {\nprivate Weather weather;\n" +
                "public void setWeather(Weather weather) {\nthis.weather = weather;\n" +
                " \n" +
                "}\n" +
                "\n" +
                "public Weather getWeather() {\nreturn this.weather;\n" +
                "}\n" +
                "\n" +
                "public String weatherMessage() {\nreturn weather.getWeather();\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public interface Weather {\n" +
                "\n" +
                "String getWeather();\n" +
                "}\n" +
                "\n" +
                "public class Rain implements Weather {\n" +
                "\n" +
                "public String getWeather() {\nreturn \"下雨\";\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Sunshine implements Weather {\n" +
                "\n" +
                "public String getWeather() {\nreturn \"阳光\";\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Test {\n" +
                "public static void main(String[] args) {\nContext ctx1 = new Context(); \n ctx1.setWeather(new Sunshine()); \n System.out.println(ctx1.weatherMessage());\n" +
                "\n" +
                "System.out.println(\"===============\");\n" +
                "\n" +
                "Context ctx2 = new Context(); \n ctx2.setWeather(new Rain()); \n System.out.println(ctx2.weatherMessage());\n" +
                "}\n" +
                "}\n" +
                " \n" +
                "result：\n" +
                "\n" +
                "阳光\n" +
                "===============\n" +
                "下雨\n" +
                "\n\n\n\n\n\n\n\n\n\n");
    }

    public LiveData<String> getText() {
        return mText;


    }
}