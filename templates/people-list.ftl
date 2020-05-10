<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
   <#-- <link rel="icon" href="img/favicon.ico">-->

    <title>People list</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Bootstrap core CSS -->
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-8 offset-2">
            <div class="panel panel-default user_panel">
                <div class="panel-heading">
                    <h3 class="panel-title">User List</h3>
                </div>
                <div class="panel-body">
                    <div class="table-container">
                        <table class="table-users table" border="0">

                            <tbody>
                            <#list userlist as user>
                                <tr>
                                    <td width="10">
                                        <div class="avatar-img">
                                            <img class="img-circle" src="https://lh3.googleusercontent.com/proxy/l1nVZcWECkzk3w0oii9I4TENPO-uevhqzX3oHDiEdO5p3kIMbgqCRlgMWmbuSj2LuuzOWe0nvwarMWNduvoUrHLlBn7TqmFZIi8vE_P0Ti8eYApajlbgJLenVgKeAWXOwjDcInGvLOzQ_amON9o7a9m8sXw" />  
                                        </div>

                                    </td>
                                    <td class="align-middle">
                                        ${user.name} &nbsp;${user.surname}
                                    </td>
                                    <td class="align-middle">
                                        ${user.job}
                                    </td>
                                    <td  class="align-middle">
                                        Last Login:  ${user.lastLogin}<br><small class="text-muted">${user.dayAgo} days ago</small>
                                    </td>
                                </tr>
                                </#list>
                            </tbody>

                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>