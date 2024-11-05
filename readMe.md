# HTML编辑器简介

很高兴和大家共同完成高级软件这门课的PJ，首先对目前的demo做一个简单的介绍

## 1. 模块简介，

作为demo，目前进行了简单的HTML预定义以及初始化指令的编写，包含

1. Main: 调用所有工具进行会话工作
2. CommandAnalyzer: 对输入指令进行初步合法性和状态判断，过滤不合法指令以及未初始化的情况
3. CommandCaller: 根据输入生成对应指令名+参数，调用简单工厂生成命令并执行
4. CommandFactory: 根据指令名生成对应指令模型
5. Commands: 抽象命令接口及各指令的实现
6. Models: 对指令实现进行封装
7. Utils: HTML对象的抽象定义、简单操作；HTML缓冲区

## 2. 注意事项
1. 目前的CommandAnalyzer基于简单的布尔判断，因此若没有init而直接read，会出现NullPointerException，在read命令模块编写完成后应该会解决
2. HTML缓冲区基于单例模式，各命令使用getInstance()方法获取HTML实例，保证唯一性。方法getHtmlContent()用于获取内容，缓冲区中HTML对象的id为”empty"代表还未初始化
3. 为了体现设计模式，实现基础指令需要新建对应的Commands类、Models类，并在CommandFactory中进行调用就可接入系统