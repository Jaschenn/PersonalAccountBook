
//设置datetimepicker

$("#expensesTime").datetimepicker({

    format: "yyyy-mm-dd hh:ii:ss",
    language:'zh-CN',
    weekSrart:1,
    autoclose: true,
    todayBtn: true,
    pickerPosition: "bottom-left",
    todayHighlight:true
})
//入口
$(document).ready(function () {
    //获取所有的账户，初始化页面
    loadAccount();
    loadExpenses();

    //添加账户按钮
    $("#ButtonsubmitAccount").click(function () {
        var accountName=$("#InputAccountName").val();
        var balance=$("#InputBalance").val();
        $.ajax({
            url:"AccountServlet?AccountMethod=saveAccount",
            type:"post",
            data:{InputAccountName:accountName,InputBalance:balance},
            success:function () {
                loadAccount();
                $("#modal-container-15680").modal('hide');
            },
            error:function () {
                alert("error");
            }
        })
    });
    //保存消费按钮
    $("#expensesSubmit").click(function () {
        var time=$("#expensesTime").val();
        var type=$("#expensesType").val();
        var amount=$("#expensesAmount").val();
        var account=$("#expensesAccount").val();
        var introduction=$("#introduction").val();
        var accountuuid= $(":selected","#expensesAccount").attr("id");
        alert(accountuuid);
        $.ajax({
            url:"ExpensesServlet?ExpensesMethod=saveExpenses",
            data:{expensesTime:time,expensesAccount:account,accountuuid:accountuuid,expensesAmount:amount,expensesType:type,introduction:introduction},
            success:function () {
                loadExpenses();
                loadAccount();

            },
            error:function () {
                alert("保存消费失败");
            }
        })

    })

    $("#submitTransfer").click(function () {
        var fromAccount = $(":selected","#fromAccount").attr("id");
        alert(fromAccount);
        var toAccount = $(":selected","#toAccount").attr("id")
        alert(toAccount);
        var transferNumber = $("#transferNumber").val();
        alert(transferNumber);
        $.ajax({

            url:"TransferServlet?TransferMethod=saveTransfer",
            type:"post",
            data:{fromAccount:fromAccount,toAccount:toAccount,transferNumber:transferNumber},
            success:function () {
                loadAccount();
                loadExpenses();
            },
            error:function () {
                alert("保存转账失败！");
            }



        })

    })

});


//loadExpenses 函数
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

            });
            $("#expensesdataTable").html(html);

        }



    })
};

//loadAccount 函数
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


            });
            //加载右侧账户和转账的option
            $("#accountList").html(html);
            var htmllist="";
            $.each(data, function(index, item) {
                var accountname=data[index].accountname;
                var accountuid=data[index].uuid;
                //此处向select中循环绑定数据
                htmllist=htmllist+"<option value="+accountname+" id="+accountuid+">" + accountname+ "</option>"
            });
            $("#expensesAccount").html(htmllist);
            $("#fromAccount").html(htmllist);
            $("#toAccount").html(htmllist);

        },
    });
};

