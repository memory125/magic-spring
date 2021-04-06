<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
    <script src="${pageContext.request.contextPath}/statics/jquery.js"></script>
    <script>
      function a() {
        $.post({
          url: "${pageContext.request.contextPath}/a1",
          data: {"name":$("#username").val()},     //  获取控件的内容时，$("#控件名").val()
          success: function (data) {
            console.log(data);
          }
        })
      }

    </script>
  </head>
  <body>

  <div class="container">
      <label>用户名</label>
      <input type="text" id="username" onblur="a()">
  </div>

  </body>
</html>
