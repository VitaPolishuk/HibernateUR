<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Роли</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/3.2.0/lodash.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="/pages/rolesJ.js"></script>
    <script>
        _.templateSettings = {
            evaluate: /{{([\s\S]+?)}}/g,
            interpolate: /{{=([\s\S]+?)}}/g,
            escape: /{{-([\s\S]+?)}}/g
        };
    </script>
    <link rel="stylesheet" href="/pages/styleRole.css" type="text/css"/>
</head>
<body onload="templateSelect(listRol,0)">
<script>
    listRol = ${listR};
</script>
<form name="roles" action="Roles.java" method="post">
    <h3><a href="http://localhost:8080/">На главную</a></h3>
    <div class="main">
        <div class="selectRole">
            <div class="sel" id="cont"></div>
            <p>
            <div><input name="name_roles" type="text" id="name_roles"></div>
        </div>
        <div class="actions">
            <div><input type="button" name="Add" value="Добавить роль" onclick="addRole()"></div>
            <div><input type="button" name="Change" value="Изменить роль" onclick="changeRole()"></div>
            <div><input type="button" name="Delete" value="Удалить роль" onclick="deleteRole()"></div>

        </div>
    </div>
</form>
<script type="text/template" id="templateSelect">
    <select name="id_r" id="id_r" onchange="selectRole()">
        <option value="roles" selected>Выберите роль</option>
        {{ for (var j = 0; j < listRole.length; j++) { }}
        {{ if (index!=0 & listRole[j].id_roles==index){ }}
        <option value="{{=listRole[j].id_roles}}" selected>{{=listRole[j].name_roles}}</option>
        {{ }else {}}
        <option value="{{=listRole[j].id_roles}}">{{=listRole[j].name_roles}}</option>
        {{ } }}
        {{ } }}
    </select>
</script>
</body>
</html>
