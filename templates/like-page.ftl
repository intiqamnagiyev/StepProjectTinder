<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <#-- <link rel="icon" href="img/favicon.ico">-->

    <title>Like page</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
          integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Bootstrap core CSS -->
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body style="background-color: #f5f5f5;">

<div class="col-4 offset-4">
    <div class="card">
        <div class="card-body">
            <div class="row">
                <div class="col-12 col-lg-12 col-md-12 text-center">
                    <img src=${user.photoLink} alt="" class="mx-auto rounded-circle img-fluid" width="200" height="200">
                    <h3 class="mb-0 text-truncated">${user.name} </h3>
                    <br>
                </div>
                <div class="col-12 col-lg-6">
                    <form method="post" action="/users?id=${user.id}&action=dislike">
                       <#-- <button class="btn btn-outline-danger btn-block"><span class="fa fa-times"></span>Dislike
                        </button>-->
                        <button type="submit" name="dislike" class="btn btn-outline-danger btn-block">
                            <span class="fa fa-times"></span> Dislike</button>
                    </form>
                </div>
                <div class="col-12 col-lg-6">
                    <form method="post" action="/users?id=${user.id}&action=like">
                       <#-- <button class="btn btn-outline-success btn-block"><span class="fa fa-heart"></span> Like
                        </button>-->
                        <button type="submit" class="btn btn-outline-success btn-block"><span
                                    class="fa fa-heart"></span> Like</button>
                    </form>
                </div>
                <div class="col-12 col-lg-6">
                    <a href="/liked">
                        <button type="submit" class="btn btn-outline-success btn-block"><span
                                    class="fa fa-heart"></span> Liked</button>
                    </a>
                </div>
                <div class="col-12 col-lg-6"> <a href="/logout">
                        <button type="submit" class="btn btn-outline-success btn-block"><span
                                    class="fa fa-arrow-up"></span> Logout</button>
                    </a></div>
                <!--/col-->
            </div>

            <!--/row-->
        </div>
        <!--/card-block-->
    </div>
</div>

</body>
</html>