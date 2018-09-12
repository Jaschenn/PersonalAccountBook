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

    <link href="webLib/datetimepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>


    <script src="webLib/datetimepicker/bootstrap-datetimepicker.js"></script>

    <script src="webLib/datetimepicker/bootstrap-datetimepicker.zh-CN.js"></script>

    <link href="webLib/datetimepicker/bootstrap-datetimepicker.css">

</head>
<body>

<script>
    //点击保存按钮，添加账户
    $(document).ready(function () {
        //获取所有的账户
        $.ajax({
            url:"AccountServlet?AccountMethod=loadAccount",
            dataType:"json",
            type:"post",
            success:function (data) {
                var jsondata=eval(data);
                var html='';
                $.each(jsondata,function (index) {
                    //循环获取数据
                    var accountname=jsondata[index].accountname;
                    var balance=jsondata[index].balance;
                    var uuid=jsondata[index].uuid;
                    html=html+" <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"collapse\"\n" +
                        "                    data-target=\"#"+uuid+"\">\n" +
                        accountname +
                        "            </button>\n" +
                        "            <div id=\""+uuid+"\" class=\"collapse in\">\n" +
                        balance +
                        "            </div>";
                    $("#accountList").html(html);
                });

            },
        });
        function loadAccount(){
            $.ajax({
                url:"AccountServlet?AccountMethod=loadAccount",
                dataType:"json",
                type:"post",
                success:function (data) {
                    var jsondata=eval(data);
                    var html='';
                    $.each(jsondata,function (index) {
                        //循环获取数据
                        var accountname=jsondata[index].accountname;
                        var balance=jsondata[index].balance;
                        var uuid=jsondata[index].uuid;
                        html=html+" <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"collapse\"\n" +
                            "                    data-target=\"#"+uuid+"\">\n" +
                            accountname +
                            "            </button>\n" +
                            "            <div id=\""+uuid+"\" class=\"collapse in\">\n" +
                            balance +
                            "            </div>";
                        $("#accountList").html(html);
                    });

                },
            });
        };
        function loadExpenses(){
            $.ajax({
                url:"ExpensesServlet?ExpensesMethod=loadExpenses",
                dataType:"json",
                type:"post",
                success:function (data) {
                    var jsondata=eval(data);
                    var html='';
                    $.each(jsondata,function (index) {
                        //循环获取数据
                        var amount=jsondata[index].amount;
                        var time=jsondata[index].time;
                        var type=jsondata[index].type;
                        var account=jsondata[index].account;
                        var introduction=jsondata[index].introduction;
                        html=html+"  <tr>\n" +
                            "                                    <td>"+amount+"</td>\n" +
                            "                                    <td>"+time+"</td>\n" +
                            "                                    <td>"+type+"</td>\n" +
                            "                                    <td>"+account+"</td>\n" +
                            "                                    <td>"+introduction+"</td>\n" +
                            "                                </tr>";
                        $("#expensesdataTable").append(html);
                    });
                }
                
                
                
            })
        };
        $(document).ready(function () {
            loadExpenses();
        })
        $("#ButtonsubmitAccount").click(function () {
            alert("添加账户");
            var accountName=$("#InputAccountName").val();
            var balance=$("#InputBalance").val();
         $.ajax({
             url:"AccountServlet?AccountMethod=saveAccount",
             type:"post",
             data:{InputAccountName:accountName,InputBalance:balance},
             success:function () {
               loadAccount();
               $("#modal-container-15680").hidden;
             },
             error:function () {
                 alert("error");
             }
         })
        });
    });

</script>
<div class="container-fluid">
    <!--导航栏 -->
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
        <!--最左侧的账户部分 -->
        <div class="col-md-2 column" id="accountPanel">
            <h2 id="accuntTitle">
                账户
            </h2>
            <a id="modal-15680" href="#modal-container-15680" role="button" class="btn" data-toggle="modal">添加账户</a>
            <!-- modal层部分-->
            <div class="modal fade" id="modal-container-15680" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">
                               添加账户
                            </h4>
                        </div>
                        <div class="modal-body">
                           <form action="AccountServlet?AccountMethod=saveAccount" id="FormAccount" method="post">
                               <div class="form-group">
                               <label for="InputAccountName"> 账户名称：</label>
                                <input  class="form-control" type="text" id="InputAccountName" name="InputAccountName">
                               <label for="InputBalance">  初始余额：</label>
                                <input  class="form-control" type="number" id="InputBalance" name="InputBalance">
                               </div>
                           </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary" id="ButtonsubmitAccount">保存</button>
                        </div>
                    </div>

                </div>

            </div>

            <div id="accountList">
            <button type="button" class="btn btn-primary" data-toggle="collapse"
                    data-target="#alipay">
               账户
            </button>
            <div id="alipay" class="collapse in">
               账户明细
            </div>
            </div>

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
                       <!--支出表格，循环添加 -->
                        <table class="table table-striped" id="expensesTable">
                            <thead>
                                <tr>
                                    <th>金额</th>
                                    <th>时间</th>
                                    <th>种类</th>
                                    <th>付款账户</th>
                                    <th>说明</th>
                                </tr>
                            </thead>
                            <tbody id="expensesdataTable">

                            </tbody>
                        </table>
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
            <div id="calendar">
                <form action="ExpensesServlet?ExpensesMethod=saveExpenses">
                    <div class="form-group">
                        <label for="expensesTime"> 消费时间：</label>
                        <div class="input-append date form_datetime" data-date="2018-02-21T15:25:00Z">
                        <input class="form-control"  id="expensesTime" name="expensesTime" readonly>
                        <span class="add-on"><i class="icon-th"></i></span>
                        </div>
                            <label for="expensesAccount">  账户：</label>
                        <input  class="form-control" type="text" id="expensesAccount" name="expensesAccount">
                        <label for="expensesAmount">  金额：</label>
                        <input  class="form-control" type="number" id="expensesAmount" name="expensesAmount">
                        <label for="expensesType">  种类：</label>
                        <input  class="form-control" type="text" id="expensesType" name="expensesType">
                        <label for="expensesType">  注释：</label>
                        <input  class="form-control" type="text" id="introduction" name="introduction">
                        <br>
                        <button class="btn-primary" type="button" id="expensesSubmit" name="expensesSubmit">let bills fly</button>
                    </div>
                </form>
            </div>
            <script>
                $("#expensesTime").datetimepicker({

                    format: "yyyy-mm-dd hh:ii:ss",
                    language:'zh-CN',
                    weekSrart:1,
                    autoclose: true,
                    todayBtn: true,
                    pickerPosition: "bottom-left",
                    todayHighlight:true
                })
            </script>
            <script>
                $(document).ready(function () {
                    $("#expensesSubmit").click(function () {
                        var time=$("#expensesTime").val();
                        var type=$("#expensesType").val();
                        var amount=$("#expensesAmount").val();
                        var account=$("#expensesAccount").val();
                        var introduction="说明";

                        $.ajax({
                            url:"ExpensesServlet?ExpensesMethod=saveExpenses",
                            data:{expensesTime:time,expensesAccount:account,expensesAmount:amount,expensesType:type,introduction:introduction},
                            success:function () {
                                alert("保存消费成功");
                            },
                            error:function () {
                                alert("保存消费失败");
                            }
                        })

                    })

                })





            </script>
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

        </div>
    </div>
    </div>
</div>
</body>
</html>
