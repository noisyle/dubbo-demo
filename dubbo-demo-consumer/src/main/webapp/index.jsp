<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Dubbo Demo</title>
</head>
<body>
<form action="/">
<lable for="name"><input name="name" autofocus="autofocus" /></lable><button>Send</button><br /><br />
<span>Request: ${param.name}</span><br />
<span>Response: ${msg}</span>
</form>
</body>
</html>