<%--
  Created by IntelliJ IDEA.
  User: jasc
  Date: 2018/9/7
  Time: 下午4:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- 可选的Bootstrap主题文件（一般不使用） -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Brand</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="#">Link</a>
                        </li>
                        <li>
                            <a href="#">Link</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#">Action</a>
                                </li>
                                <li>
                                    <a href="#">Another action</a>
                                </li>
                                <li>
                                    <a href="#">Something else here</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="#">Separated link</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="#">One more separated link</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" />
                        </div> <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#">Link</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#">Action</a>
                                </li>
                                <li>
                                    <a href="#">Another action</a>
                                </li>
                                <li>
                                    <a href="#">Something else here</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="#">Separated link</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>

            </nav>
            <div class="container">
                <h1>
                    JasmineChen的实验室
                </h1>
            </div>

        </div>
    </div>
    <div class="container-fluid">
    <div class="row">
        <div class="col-md-2 column">
            <h2>
                账户
            </h2>
            <button type="button" class="btn btn-primary" data-toggle="collapse"
                    data-target="#alipay">
               支付宝
            </button>
            <div id="alipay" class="collapse in">
                Nihil anim keffiyeh helvetica, craft beer labore wes anderson
                cred nesciunt sapiente ea proident. Ad vegan excepteur butcher
                vice lomo.
            </div>
            <button class="btn btn-primary">增加</button>

        </div>
        <!-- 中间的核心部分-->
        <div class="col-md-6 column">
            <div class="tabbable" id="tabs-832567" align="center">
                <ul class="nav nav-tabs">
                    <li>
                        <a href="#panel-384292" data-toggle="tab">收入</a>
                    </li>
                    <li class="active">
                        <a href="#panel-701707" data-toggle="tab">支出</a>
                    </li>
                    <li class="nav-tabs">
                        <a href="#panel-77077" data-toggle="tab">转账</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="panel-384292">
                        <p>
                          现在没有收入呀
                        </p>
                    </div>
                    <div class="tab-pane" id="panel-701707">
                        <form role="form">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Email address</label><input type="email" class="form-control" id="exampleInputEmail1" />
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Password</label><input type="password" class="form-control" id="exampleInputPassword1" />
                            </div>
                            <div class="form-group">
                                <label for="exampleInputFile">File input</label><input type="file" id="exampleInputFile" />
                                <p class="help-block">
                                    Example block-level help text here.
                                </p>
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox" />Check me out</label>
                            </div> <button type="submit" class="btn btn-default">Submit</button>
                        </form>
                    </div>
                    <div class="tab-pane" id="panel-77077">
                        <p>
                            支持转账
                        </p>
                    </div>
                </div>
            </div>

            <div class="alert alert-success alert-dismissable">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4>
                    注意!
                </h4> <strong>Warning!</strong> Best check yo self, you're not looking too good. <a href="#" class="alert-link">alert link</a>
            </div>
        </div>
        <!--    右侧的预测部分  -->
        <div class="col-md-4 column">
            <ul class="nav nav-pills">
                <li class="active">
                    <a href="#"> <span class="badge pull-right">42</span> Home</a>
                </li>
                <li>
                    <a href="#"> <span class="badge pull-right">16</span> More</a>
                </li>
            </ul>
            <div class="progress">
                <div class="progress-bar progress-success">
                </div>
            </div>
            <div class="progress">
                <div class="progress-bar progress-success">
                </div>
            </div>
            <a id="modal-15680" href="#modal-container-15680" role="button" class="btn" data-toggle="modal">触发遮罩窗体</a>

            <div class="modal fade" id="modal-container-15680" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">
                                标题
                            </h4>
                        </div>
                        <div class="modal-body">
                            内容...
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">保存</button>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
    </div>
</div>
</body>
</html>
