# SpringBoot-MVC-Restful-H2-Database

將 8/5 的課堂作業（點餐）[SpringBoot-MVC-Restful -> spring-restful-practice-Order]改寫成 H2 Database + Spring Data JPA

#### H2-Database：http://localhost:8080/h2-console
* spring.datasource.url=jdbc:h2:mem:training
* spring.datasource.driverClassName=org.h2.Driver
* spring.datasource.username=sa
* spring.datasource.password=sa

#### spring-restful-practice-Order:

* 取得所有訂單 http://localhost:8080/order  
* 根據Sep取得單筆訂單 http://localhost:8080/order/:seq  
* 新增訂單 http://localhost:8080/order  
* 修改訂單 http://localhost:8080/order/:seq  
* 刪除訂單 http://localhost:8080/order/:seq
