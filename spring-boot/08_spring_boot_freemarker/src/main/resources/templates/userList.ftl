<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FreeMarker</title>
</head>
<table border="1" align="center" width="50%" cellpadding="0" cellspacing="0px">
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Gender</th>
    </tr>

    <#list list as user>
        <tr>
            <td>${user.userName}</td>
            <td>${user.userAge}</td>
            <td>${user.userGender}</td>
        </tr>
    </#list>
</table>
</html>