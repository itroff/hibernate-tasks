## === Task I ===
  Is there a problem in the code which will give incorrect result for some values, and if there is write solution which will give the correct result.

  Implementation [com.nxlog.demo.tasks.Task1.java](src/main/java/com/nxlog/demo/tasks/Task1.java) <br />
  Test [com.nxlog.demo.DemoApplicationTests.java](src/test/java/com/nxlog/demo/DemoApplicationTests.java) method ``` testStatic()```

## === Task II ===
  Write modified code which ensures the processor in Executor is always initialized when process() method is executed.

  Implementation [com.nxlog.demo.tasks.Task2.java](src/main/java/com/nxlog/demo/tasks/Task2.java) <br />
  For execute [com.nxlog.demo.DemoApplicationTests.java](src/test/java/com/nxlog/demo/DemoApplicationTests.java) method ``` testThreads()```

## === Task III ===

  Rewrite this code using Java8 stream and functions API.

  Implementation [com.nxlog.demo.tasks.Task3.java](src/main/java/com/nxlog/demo/tasks/Task3.java) <br />
  Test [com.nxlog.demo.DemoApplicationTests.java](src/test/java/com/nxlog/demo/DemoApplicationTests.java) method ``` testStream()```

## === Task IV ===

Implement the code in getModulesIncludedInCompleteRoutes method using either session or em. Any of Hibernate criteria API, HQL or pure SQL can be used.

  Implementation [com.nxlog.demo.repositories.HibernateRepository.java](src/main/java/com/nxlog/demo/repositories/HibernateRepository.java) <br />
  Test [com.nxlog.demo.DemoApplicationTests.java](src/test/java/com/nxlog/demo/DemoApplicationTests.java) method ``` testHibernate()```

## === Task  V ===

Let's have the above Hibernate model in Task IV and more secificly the Agent entity. We don't need globalConfig each time in Hibernate and as @Lob this can be large data. Modify the model so globalConfig is only fetched when needed, i.e. session.get(agentId, Agent.class) will return Agent without globalConfig data.

 ```replace @Lod with @Basic(fetch = FetchType.LAZY) on globalConfig field```