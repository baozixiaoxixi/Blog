<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="zh-cn" xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>${post.title}</title>
  <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="/css/footer.css"/>
  <link rel="stylesheet" href="/css/sidbar.css"/>
  <link rel="stylesheet" href="/css/blog.css"/>
  <link rel="stylesheet" href="/css/highlight.css"/>
  <script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
  <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <script type="text/javascript">
    $.getJSON("${pageContext.request.contextPath}/post/nextPage/${post.id}", function(json){
      if(json!=null){
        var next = $("#next");
        next.append("<a href=\"${pageContext.request.contextPath}/post/"+json+"\">下一篇 <span aria-hidden=\"true\">&rarr;</span></a>");
      }
    });

    $.getJSON("${pageContext.request.contextPath}/post/previousPage/${post.id}", function(json){
      if(json!=null){
        var next = $("#previous");
        next.append("<a href=\"${pageContext.request.contextPath}/post/"+json+"\"><span aria-hidden=\"true\">&larr;</span> 上一篇</a>");
      }
    });
  </script>
  <script type="text/javascript">
    $.ajax({
      url:"${pageContext.request.contextPath}/post/orderByDate",
      type:"get",
      success: function(msg){
        var ol = $("#ol");
        eval("var json = " + msg);// 转换为json对象

        for(var i=0;i<json.length;i++){
          var date = json[i].year+"-"+json[i].month;
          ol.append("<li><a href=\"${pageContext.request.contextPath}/post/date/1/"+date+"\">"+date+"</a></li>");
        }

        // ol.append(data[0].year);

      },
      error: function(){
        alert("更新信息状态失败！");
      }
    });
  </script>
</head>
<body>
<div class="container">

  <div class="row">

    <div class="col-sm-8">
      <div class="page-header">
        <h2>${post.title}</h2>
        <p class="blog-post-meta"><fmt:formatDate value="${post.created}" pattern="yyyy-MM-dd"/>  分组：<a href="#">Web开发</a></p>
      </div>

      <div class="post-content">${post.content}
      </div>

      <nav>
        <ul class="pager">
            <li class="previous" id="previous"></li>
            <li class="next" id="next"></li>

        </ul>
      </nav>
     
     <!-- 显示评论 -->
      <div class="col-sm-10">
        <div class="blog-post"><!-- 注意这块，显示了循环 -->
          <p class="blog-post-meta">2015年2月3日</p>
          <p class="blog-post-content">Amet risus. Dolor ultrices justo, praesent eos nisl lacus, consectetuer vitae lorem cras magna dolor, mauris libero turpis aliquam sed, at sapien tellus penatibus accumsan nec. Parturient amet felis morbi. Quis ac penatibus elementum lacus, vestibulum sem tellus arcu.</p>
        </div>
      </div>

      <!-- 添加评论 -->
       <form method="post">
        <div class="form-group">
          <textarea name="content" id="new-comment" class="form-control"></textarea>

          <div class="alert alert-danger" style="display: none;"></div>
        </div>

        <div class="form-group">
          <input type="submit" class="btn btn-primary" value="发布"/>
        </div>
      </form>

    </div>


    <div class="col-sm-3 col-sm-offset-1">
      <div class="sidebar-module sidebar-module-inset">
        <div class="avatar">
          <img class="img-circle img-rounded img-thumbnail avatar" src="${pageContext.request.contextPath}/img/catty.jpeg"/>
          <div>
            <h4>CrazyZhang</h4>
            <a>183485002@qq.com</a>
          </div>
        </div>
        <p>Ornare sapien rhoncus, nec mi hendrerit. Ante aliquam dui arcu, diam sodales erat felis dolor sed in, nec placerat non.</p>
      </div>
      <div class="sidebar-module">
        <div class="avatar">
          <form action="${pageContext.request.contextPath}/post/page/1">
            <button type="submit" class="btn pull-right btn-primary">返回博客列表</button>
          </form>
          <form action="${pageContext.request.contextPath}/post/edit/${post.id}">
            <button type="submit" class="btn pull-right btn-primary">编译本文</button>
          </form>
        </div>
      </div>
      <div class="sidebar-module">
        <h4>归档</h4>
        <ol class="list-unstyled" id="ol">

        </ol>
      </div>
    </div>

  </div>

</div>

</body>
</html>