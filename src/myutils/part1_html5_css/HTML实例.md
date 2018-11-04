### 网页换肤

#### 概述

编写不同风格的CSS样式，根据用户选择的主题风格，来调用JS方法，选择不同的CSS文件。注意需要保存cookie。（以后可以使用JSP）

#### 

orange.css

```css
```

grey.css

```css
```

JS文件：jsFile.js
```javascript
function writeCookie(csspath){
    //有效期为30天
    var today=new Date();
    var expires = new Data();
    expires.setTime(today.getTime() + 1000*60*24*30);
    //????
    var str="cssPath="+csspath+";expires="+expires.toGMTString()+";";
    document.cookie=str;
}

function readCookie(cookieName){
    var search=cookieName+"=";
    if(document.cookie.length>0){
        var offset;
        offset=document.cookie.indexOf(search);
        if(offset!==-1){
            offset+=search.length;
            var end = document.cookie;
            return unescape(document.cookie.substring(offset,end));
        }
    }
}

//onclick事件调用方法
function change(type){
    document.getElementById("myCss".href=type+".css");
}
```

页面中超链接的关键代码：
```html
<a href="#" onclick="change('orange')">橘色经典</a>
<a href="#" onclick="change('grey')">灰色畅想</a>
```

