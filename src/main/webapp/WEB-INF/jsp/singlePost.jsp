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
          <c:if test="${post.id>1}">
              <li class="previous"><a href="${pageContext.request.contextPath}/post/${post.id-1}"><span aria-hidden="true">&larr;</span> 上一篇</a></li>
          </c:if>
          <c:if test="${!(post.title eq '没有文章了')}">
            <li class="next"><a href="${pageContext.request.contextPath}/post/${post.id+1}">下一篇 <span aria-hidden="true">&rarr;</span></a></li>
          </c:if>

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
        <h4>归档</h4>
        <ol class="list-unstyled">
          <li><a href="#">2015年03月</a></li>
          <li><a href="#">2015年02月</a></li>
          <li><a href="#">2015年01月</a></li>
          <li><a href="#">2014年12月</a></li>
          <li><a href="#">2014年11月</a></li>
          <li><a href="#">2014年10月</a></li>
          <li><a href="#">2014年09月</a></li>
          <li><a href="#">2014年08月</a></li>
          <li><a href="#">2014年07月</a></li>
        </ol>
      </div>
    </div>

  </div>

</div>

</body>
</html>