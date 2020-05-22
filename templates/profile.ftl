<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/static/images/tinderIcon.jpg">

    <title>Profile</title>
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
                    <h2>  My Profile</h2>
                    <img src=${user.photoLink} alt="" class="mx-auto rounded-circle img-fluid" width="200" height="200">
                    <h3 class="mb-0 text-truncated">${user.name} &nbsp;${user.job} </h3>
                    <br>
                </div>
                <div class="col-12 col-lg-6">
                    <a href="/users">
                        <button class="btn btn-outline-success btn-block"><span class="fa fa-heart"></span> Find Love
                        </button>
                    </a>

                </div>
                <div class="col-12 col-lg-6">

                        <button  class="btn btn-outline-success btn-block"><span
                                    class="fa fa-heart"></span> ....
                        </button>
                </div>
                <div class="col-12 col-lg-6">
                    <a href="/liked">
                        <button type="submit" class="btn btn-outline-success btn-block"><span
                                    class="fa fa-heart"></span> Liked
                        </button>
                    </a>
                </div>
                <div class="col-12 col-lg-6">
                    <a href="/logout">
                        <button type="submit" class="btn btn-outline-success btn-block"><span
                                    class="fa fa-arrow-up"></span> Logout
                        </button>
                    </a>
                </div>
                <!--/col-->
            </div>

            <!--/row-->
        </div>
        <!--/card-block-->
    </div>
</div>

</body>
</html>