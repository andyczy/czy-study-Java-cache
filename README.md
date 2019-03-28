## 学习研究Java缓存


![cache](https://github.com/andyczy/czy-study-Java-cache/blob/master/src/main/cache.png)

整个 Cache缓存框架的核心类主要有这么几个，每一层都是面向接口编程这样可以方便的进行后续扩展。              


| 类名               | 功能                                     |
| ------------------ | ---------------------------------------- |
| Cache              | Cache缓存核心调用类，都是缓存的接口都是通过这个接口对外暴露       |
| ValueHolder        | 缓存value类型接口，所有缓存中Value类型都是实现该接口          |
| DataStore          | 缓存数据存储接口，所有缓存数据类型都实现该接口                  |
| WeakValueHolder    | 弱引用value数据类型，对于在缓存中需要弱引用的类型可以使用该类        |   
| WeakValueDataStore | 弱引用数据类型缓存数据类型                            |
| LRUDataStore       | 缓存数据存储LRU类，基本缓存存储类型缓存所有操作采用LRU算法         |
| LRUEntry           | LRU链表节点，里面定义了链表节点的前后节点的数据结构              |
| BasicValueHolder   | 缓存基础Vaule类，基础范型类，常用的缓存对象都可以使用该类          |
| BasicDataStore     | 缓存数据存储基础类，基本缓存存储类型没有特殊算法，没有特殊要求的缓存都可以使用该类 |
|                    |                                          |               

