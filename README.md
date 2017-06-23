# java-OTP-DEMO

用JAVA写了一个基于GOOGLE OTP算法的DEMO

请求：

```
localhost:8080//OTPWebDemo/OTPOperate
POST提交:type=add&username=zhutougg
添加一个用户,并返回二维码的链接
```



```
localhost:8080//OTPWebDemo/OTPOperate
POST提交:type=delete&username=zhutougg
删除用户
```

```
localhost:8080//OTPWebDemo/OTPOperate
POST提交:type=check&username=zhutougg&code=123456
验证用户
```

