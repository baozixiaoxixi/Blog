<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="zh-cn" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>文章列表</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/footer.css"/>
    <link rel="stylesheet" href="/css/sidbar.css"/>
    <link rel="stylesheet" href="/css/blog.css"/>
    <script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

    <div class="page-header">
        <h1>CrazyZhang 的博客
            <small>记录一点一滴的成长</small>
        </h1>
    </div>

    <div class="row">

        <div class="col-sm-8">
            <div class="blog-post">
                <c:forEach var="post" items="${posts}">
                    <h3 class="blog-post-title">
                        <a href="${pageContext.request.contextPath}/post/${post.id}">${post.title}</a>
                    </h3>
                    <p class="blog-post-meta"><fmt:formatDate value="${post.created}" pattern="yyyy-MM-dd"/> </p>
                    <p class="blog-post-content">${post.content}</p>
                </c:forEach>
            </div>
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
            <div>
                <form action="${pageContext.request.contextPath}/post/create">
                    <button type="submit" class="btn pull-right btn-primary">添加博客</button>
                </form>
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
