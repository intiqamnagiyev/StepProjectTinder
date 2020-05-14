<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <#-- <link rel="icon" href="img/favicon.ico">-->

    <title>People list</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
          integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
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
                                            <img class="img-circle" src=${user.photoLink}>  
                                        </div>

                                    </td>
                                    <td class="align-middle">
                                        ${user.name} &nbsp;${user.surname}

                                    </td>
                                    <td class="align-middle">
                                        ${user.job}
                                    </td>
                                    <td class="align-middle">
                                        Last Login: ${user.lastLogin}<br><small class="text-muted">${user.dayAgo} days
                                            ago</small>
                                    </td>

                                    <td>
                                        <a href="/messages?id=${user.id}">
                                            <button class="btn btn-outline-success btn-block">Send Message</button>
                                        </a>
                                    </td>
                                </tr>
                            </#list>
                            </tbody>


                        </table>
                        <div class="col-12 col-lg-6">
                            <a href="/users">
                                <button class="btn btn-outline-success"><span class="fa fa-heart"></span> Find Love
                                </button>
                            </a>
                            <a href="/logout">
                                <button class="btn btn-outline-success"><span class="fa fa-arrow-up"></span> Log out
                                </button>
                            </a>
                        </div>

                    </div>

                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>