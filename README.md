# Java_PetStore

# PetStore Demo 宠物商店项目

本章介绍 JavaSE 技术实现的 PetStore 宠物商店项目，所涉及的知识点：Java 面向对象、Lambda 
表达式、JavaSwing 技术、JDBC技术和数据库相关等知识，其中还会用到方方面面的 
Java 基础知识。

## 1 系统分析与设计

本节对 PetStore 宠物商店项目进行分析和设计，其中设计过程包括原型设计、数据库设计、架构设计和系统设计。

### 1.1 项目概述

PetStore 是 Sun（现在 Oracle）公司为了演示自己的 JavaEE 技术，而编写的一个基于 Web 宠物店项目，如图29-1所示为项目启动页面，项目介绍网站是 `http://www`
`.oracle.com/technetwork/java/index-136650.html`。PetStore 是典型的电子商务项目，是现在很多电商平台的雏形。技术方面主要是 JavaEE 技术，用户界面采用 JavaWeb 介绍实现。但本书介绍JavaSE 技术，不介绍 JavaWeb，所以本章的 PetStore 项目用户界面采用 JavaSwing 技术实现。

![1-1](img/Screen Shot 2018-08-04 at 16.19.54.png)

### 1.2 需求分析

PetStore 宠物商店项目主要功能如下：

- 用户登录
- 查询商品
- 添加商品到购物车
- 查看购物车
- 下订单
- 查看订单

采用用例分析方法描述用例图，如图1-2所示：

![1-2]()

### 1.3 原型设计

原型设计草图对于开发人员、设计人员、测试人员、UI 设计人员以及用户都是非常重要的。PetStore 宠物商店项目原型设计图如图1-3所示。

![1-3]()

### 1.4 数据库设计

Java 官方提供的 PetStore 宠物商店项目数据库设计比较复杂，根据如图1-2的用例图重新设计数据库，数据库设计模型如图1-4所示。

![1-4](img/1-4.png)

数据库设计模型中各个表说明如下：

#### 01 用户表

#### 02 商品表

#### 03 订单表

#### 04 订单明细表

### 1.5 架构设计

无论是庞大企业级系统，还是手机上的应用，都应该有效地组织程序代码。这就需要设计。而架构设计就是系统的「骨架」，它是源自于前人经验的总结和提炼，形式一种模式推而广之。但是遗憾的是本书的定位是初学者，并不是介绍架构设计方面的书。为了开发 PetStore 宠物商店项目需要，这里笔者给出最简单的架构设计结果。

世界著名软件设计大师 Martin Fowler 在他《企业应用架构模式》（英文名 
Patterns of Enterprise Application Architecture）一书中提到，为了有效地组织代码，一个系统应该分为三个基本层，如图1-5所示。「层」（Layer
）是相似功能的类和接口的集合，「层」之间是松耦合的，「层」的内部是高内聚的。

![1-5]()

- 表示层：用户与系统交互的组件集合。用户通过这一层向系统提交请求或发出指令，系统通过这一层接收用户请求或指令，待指令消化吸收后再调用下一层，接着将调用结果展现到这一层。**表示层应该是轻薄的，不应该具有业务逻辑**。
- 服务层。系统的核心业务处理层。负责接收表示层的指令和数据，待指令和数据消化吸收后，再进行组织业务逻辑的处理，并将结果返回给表示层。
- 数据持久层。数据持久层用于访问持久化数据，持久化数据可以是保存在数据库、文件、其他系统或者网络数据。根据不同的数据来源，数据持久层会采用不同的技术，例如：如果数据保存到数据库中，则使用 JDBC 技术；如果数据保存 JSON 文件在，则需要 I/O 流和 JSON 解码技术实现。

MartinFowler 分层架构设计看起来像一个多层「蛋糕」，蛋糕师们在制作多层「蛋糕」的时候先做下层再做上层，最后做顶层。没有下层就没有上层，这叫作「上层依赖于下层」。为了降低松耦度，层之间还需要定义接口，通过接口隔离实现细节，上层调用者用只关心接口，不关心下一层的实现细节。

MartinFowler 分层架构是基本形式，在具体实现项目设计时，可能有所增加，也可能有所减少。本章实现的 PetStore 宠物商店项目，由于简化了需求，逻辑比较简单，可以不需要服务层，表示层可以直接访问数据持久层，如图1-6所示，表示层采用 Swing 技术实现，数据持久层采用 JDBC 技术实现。

![1-6]()

