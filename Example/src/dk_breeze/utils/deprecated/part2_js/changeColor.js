//设计表格外边框的自动变色

var i=0;
var Color = ["#00f","#9f0","#603","#c6c","#ff3"];
function change(){
    if(i>Color.length -1)   i=0;
    table1.style.borderColor = Color[i];    //改变表格边框颜色，table1为ID
    i = i+1;
    setTimeout("change()",500)      //每隔500毫秒调用一次
}



