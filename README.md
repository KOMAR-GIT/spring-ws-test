# spring-ws-test

##Тестирование в SOAPUI
Для тестирования в SOAPUI:
+ откройте приложение
+ создайте новый SOAP проект
+ Добавьте **Project Name**
+ В графе **Initial WSDL** пропишите:
```
http://localhost:8080/ws/calculation.wsdl
```
+ нажмите **Ок**

Для проверки работоспособности сервиса осталось раскрыть **get** 
запрос и добавить заместо знака вопроса (?) свое целочисленное значение в строке: 
```
<calc:number>?</calc:number>
```
Выполните запрос и получите ответ

##Тестирование в POSTMAN
Для тестирование в POSTMAN:
+ Откройте приложение
+ Создайте новый **request**
+ Выберите тип запроса **POST**
+ В графе URL пропишите: 
```
http://localhost:8080/ws
```
+ Перейдите во вкладку **Body**
+ Выберите тип **raw** и вид **XML**
+ Добавьте к телу запроса следующие строчки:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
                  xmlns:calc="http://www.example.org/calc">
   <soapenv:Header/>
   <soapenv:Body>
      <calc:getRequest>
         <calc:number>?</calc:number>
      </calc:getRequest>
   </soapenv:Body>
</soapenv:Envelope>
```
+ Замените знак вопроса (?) на на своё целочисленное значение
+ Отправьте запрос и получите ответ

##Пример
При запросе:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
                  xmlns:calc="http://www.example.org/calc">
   <soapenv:Header/>
   <soapenv:Body>
      <calc:getRequest>
         <calc:number>9</calc:number>
      </calc:getRequest>
   </soapenv:Body>
</soapenv:Envelope>
```
Вы получите ответ:
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:getResponse xmlns:ns2="http://www.example.org/calc">
         <ns2:square>81.0</ns2:square>
      </ns2:getResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```