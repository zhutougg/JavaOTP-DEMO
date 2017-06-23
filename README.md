# java-OTP-DEMO

用JAVA写了一个基于GOOGLE OTP算法的DEMO
请求：localhost:8080//OTPWebDemo/OTPOperate
POST:type=add&username=zhutougg
即添加一个用户,并返回二维码的链接
POST:type=delete&username=zhutougg
即删除用户
POST:type=check&username=zhutougg&code=123456
即验证用户