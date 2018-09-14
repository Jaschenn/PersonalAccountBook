
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
    loadIncome();

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

    });
    //保存转账按钮
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

    });
    //双击账户按钮
    // $("#accountList").delegate(".accountChange","dblclick",function () {
    //     //此处获取不了值
    //     var accountUid=$(this).id;
    //     $("#addAccountModal").modal("show");
    //     var IncomeSource=$("#IncomeSource").val();
    //     var IncomeAmount=$("#IncomeAmount").val();
    //     alert(accountUid);
    //     alert(IncomeSource);
    //     alert(IncomeAmount);
    //     $.ajax({
    //         url:"IncomeServlet?IncomeMethod=saveIncome",
    //         type:"post",
    //         data:{accountUid:accountUid,IncomeSource:IncomeSource,IncomeAmount:IncomeAmount},
    //         success:function () {
    //             loadAccount();
    //             loadExpenses();
    //         },
    //         error:function () {
    //             alert("保存收入失败！");
    //         }
    //
    //
    //     })
    //
    // })
    $("#accountList").on("dblclick","button",function () {
        var id=$(this).attr("name");
        $("#addAccountModal").modal("show");
        $("#ButtonsubmitUpdateAccount").click(function () {
            var IncomeSource=$("#IncomeSource").val();
            var IncomeAmount=$("#IncomeAmount").val();

            $.ajax({
                url:"IncomeServlet?IncomeMethod=saveIncome",
                type:"post",
                data:{accountUid:id,IncomeSource:IncomeSource,IncomeAmount:IncomeAmount},
                success:function () {
                    $("#addAccountModal").modal("hide");
                    loadAccount();
                    loadExpenses();
                    loadIncome();
                },
                error:function () {
                    alert("保存收入失败！");
                }


            })
        })


    })
    $("#accountList").delegate(".linkmodal","click",function () {
        $("div.accountList a").click(function () {
            alert($(this).attr("id"));
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
                html=html+" <button name=\""+uuid+"\" type=\"button\" class=\"accountChange btn btn-primary\" data-toggle=\"collapse\"\n" +
                    "                    data-target=\"#"+uuid+"\" >\n" +
                    accountname +
                    "            </button>\n" +
                    "            <div id=\""+uuid+"\" class=\"collapse in\">\n   <a  class=\"linkmodal\"data-toggle=\"modal\" data-target=\"#addAccountModal\">" +
                    balance +
                    "     </a>       </div>";


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

//loadExpenses 函数
function loadIncome(){
    $.ajax({
        url:"IncomeServlet?IncomeMethod=loadIncome",
        dataType:"json",
        type:"post",
        success:function (data) {
            var jsondata=eval(data);
            var html='';
            $.each(jsondata,function (index) {
                //循环获取数据
                var accountName=jsondata[index].accountName;
                var time=jsondata[index].time;
                var amount=jsondata[index].amount;
                var source=jsondata[index].source;
                html=html+"  <tr>\n" +
                    "                                    <td>"+accountName+"</td>\n" +
                    "                                    <td>"+time+"</td>\n" +
                    "                                    <td>"+amount+"</td>\n" +
                    "                                    <td>"+source+"</td>\n" +
                    "                                </tr>";

            });
            $("#incomedataTable").html(html);

        }



    })
};

