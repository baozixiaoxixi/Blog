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
            <nav>
                <ul class="pagination">
                    <c:if test="${isHasPreviousPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/post/date/${currentPage-1}/${date}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach var="i" begin="1" end="${totalPages}">
                        <li><a href="${pageContext.request.contextPath}/post/date/${i}/${date}">${i}</a></li>
                    </c:forEach>
                    <c:if test="${isHasNextPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/post/date/${currentPage+1}/${date}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>
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
            <div class="sidebar-module sidebar-module-inset">
                <div class="avatar">
                    <form action="${pageContext.request.contextPath}/post/create">
                        <button type="submit" class="btn pull-right btn-primary">添加博客</button>
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
