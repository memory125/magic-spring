<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人员信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <%--引入jQuery--%>
    <script src="${pageContext.request.contextPath}/statics/jquery-3.6.0.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.post("${pageContext.request.contextPath}/a2", function (data) {
                    //console.log(data);
                    var html = "";
                    for (let i = 0; i < data.length; i++) {
                        html += "<tr>" +
                            "<td>" + data[i].id + "</td>" +
                            "<td>" + data[i].name + "</td>" +
                            "<td>" + data[i].age + "</td>" +
                            "<td>" + data[i].gender + "</td>" +
                            "</tr>"
                    }
                    $("#contend").html(html)
                })
            })
        })
    </script>
</head>
<body>
<div class="row clearfix">
    <div class="col-md-12 column">
        <input type="button" class="btn btn-primary" value="加载数据" id="btn">
        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
            </tr>
            </thead>
            <tbody id="contend"></tbody>
        </table>
    </div>
</div>
</body>
</html>