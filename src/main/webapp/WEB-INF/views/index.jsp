<%@ page contentType="text/html; utf-8" pageEncoding="utf-8" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<html>

<body>

<h2>ajax同源请求</h2>

<form>
    <label for="id">id:</label><input type="text" id="id" name="id" placeholder="请输入id">
</form>

<button id="btn_submit">提交</button>


<script src="${path}/resources/js/jquery-1.12.3.min.js"></script>

<script type="text/javascript">

    $("#btn_submit").click(function() {

        var data = {
            id: $("#id").val()
        };

        $.ajax({
            type: "post",
            url: "${path}/info.htm",
            data: data,
            dataType: "json",
            success: function (resp) {
                console.log(resp);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus + errorThrown);
            }
        })

    });


</script>

</body>
</html>
