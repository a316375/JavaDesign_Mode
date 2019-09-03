package com.xyx.javadesignmode.ui.b19;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("23 种设计模式（19）：组合模式\n" +
                "概述：\n" +
                "将对象组合成树形结构以表示“部分-整体”的层次结构。“Composite 使得用户对单个对象和组合对象的使用具有一致性。”\n" +
                "类型：结构型模式。类图：\n" +
                "[code=img]design/composite.png\n" +
                "适用性：\n" +
                "1、你想表示对象的部分-整体层次结构。\n" +
                "2、你希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。\n" +
                "参与者：\n" +
                "1、Component\n" +
                "为组合中的对象声明接口。\n" +
                "在适当的情况下，实现所有类共有接口的缺省行为。\n" +
                " \n" +
                "声明一个接口用于访问和管理 Component 的子组件。\n" +
                "(可选)在递归结构中定义一个接口，用于访问一个父部件，并在合适的情况下实现它。\n" +
                "2、Leaf\n" +
                "在组合中表示叶节点对象，叶节点没有子节点。在组合中定义节点对象的行为。\n" +
                "3、Composite\n" +
                "定义有子部件的那些部件的行为。存储子部件。\n" +
                "在 Component 接口中实现与子部件有关的操作。\n" +
                "4、Client\n" +
                "通过 Component 接口操纵组合部件的对象。例子：\n" +
                "\n" +
                "public abstract class Employer {\nprivate String name;\n" +
                "public void setName(String name) {\nthis.name = name;\n" +
                "}\n" +
                "\n" +
                "public String getName() {\nreturn this.name;\n" +
                "}\n" +
                "\n" +
                "public abstract void add(Employer employer); public abstract void delete(Employer employer); public List employers;\n" +
                "public void printInfo() {\nSystem.out.println(name);\n" +
                "}\n" +
                "\n" +
                "public List getEmployers() {\nreturn this.employers;\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Programmer extends Employer {\n" +
                "\n" +
                "public Programmer(String name) {\nsetName(name);\n" +
                " \n" +
                "employers = null;// 程序员, 表示没有下属了\n" +
                "}\n" +
                "\n" +
                "public void add(Employer employer) {\n" +
                "\n" +
                "}\n" +
                "\n" +
                "public void delete(Employer employer) {\n" +
                "\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class ProjectAssistant extends Employer {\n" +
                "\n" +
                "public ProjectAssistant(String name) {\nsetName(name);\n" +
                "employers = null;// 项目助理, 表示没有下属了\n" +
                "}\n" +
                "\n" +
                "public void add(Employer employer) {\n" +
                "\n" +
                "}\n" +
                "\n" +
                "public void delete(Employer employer) {\n" +
                "\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class ProjectManager extends Employer {\n" +
                "\n" +
                "public ProjectManager(String name) {\nsetName(name);\n" +
                "employers = new ArrayList();\n" +
                "}\n" +
                "\n" +
                "public void add(Employer employer) {\nemployers.add(employer);\n" +
                "}\n" +
                "\n" +
                "public void delete(Employer employer) {\nemployers.remove(employer);\n" +
                "}\n" +
                "}\n" +
                " \n" +
                "public class Test {\n" +
                "\n" +
                "public static void main(String[] args) {\n Employer pm = new ProjectManager(\"项目经理\");\n" +
                "Employer pa = new ProjectAssistant(\"项目助理\"); Employer programmer1 = new Programmer(\"程序员一\"); Employer programmer2 = new Programmer(\"程序员二\");\n" +
                "\n" +
                "pm.add(pa);// 为项目经理添加项目助理\n" +
                "pm.add(programmer2);// 为项目经理添加程序员\n" +
                "\n" +
                "List<Employer> ems = pm.getEmployers(); for (Employer em : ems) {\n" +
                "System.out.println(em.getName());\n" +
                "}\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "result：\n" +
                "\n" +
                "项目助理程序员二\n\n\n\n\n\n\n\n\n\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}