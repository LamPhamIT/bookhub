<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="/api-products"></c:url>
<!DOCTYPE html>
<html>
<head>
    <title>Chinh sua bai viet</title>
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />"/>
    <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />"/>
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />" class="ace-main-stylesheet"
          id="main-ace-style"/>
    <script src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type='text/javascript' src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="<c:url value='/template/paging/jquery.twbsPagination.js'/>"></script>
</head>
<body class="no-skin">
<!-- header -->
<div id="navbar" class="navbar navbar-default          ace-save-state">
    <div class="navbar-container ace-save-state" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    Trang quản trị
                </small>
            </a>
        </div>
        <div class="navbar-buttons navbar-header pull-right collapse navbar-collapse" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue dropdown-modal">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        Xin chao ${USERMODEL.userName}
                    </a>
                <li class="light-blue dropdown-modal">
                    <a href='<c:url value="/dang-nhap?action=logout"/>'>
                        <i class="ace-icon fa fa-power-off"></i>
                        Thoát
                    </a>
                </li>
                </li>
            </ul>
        </div>
    </div>
</div>

<!-- header -->

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>
    <!-- header -->
    <div id="sidebar" class="sidebar                  responsive                    ace-save-state">
        <script type="text/javascript">
            try {
                ace.settings.loadState('sidebar')
            } catch (e) {
            }
        </script>
        <div class="sidebar-shortcuts">
            <div class="sidebar-shortcuts-large">
                <button class="btn btn-success">
                    <i class="ace-icon fa fa-signal"></i>
                </button>

                <button class="btn btn-info">
                    <i class="ace-icon fa fa-pencil"></i>
                </button>

                <button class="btn btn-warning">
                    <i class="ace-icon fa fa-users"></i>
                </button>

                <button class="btn btn-danger">
                    <i class="ace-icon fa fa-cogs"></i>
                </button>
            </div>
            <div class="sidebar-shortcuts-mini">
                <span class="btn btn-success"></span>

                <span class="btn btn-info"></span>

                <span class="btn btn-warning"></span>

                <span class="btn btn-danger"></span>
            </div>
        </div>
        <ul class="nav nav-list">
            <li>
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"></span>
                    Quản lý sản phấm
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <b class="arrow"></b>
                <ul class="submenu">
                    <li>
                        <a href='#'>
                            <i class="menu-icon fa fa-caret-right"></i>
                            DS sản phẩm
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>
        </ul>
        <div class="sidebar-toggle sidebar-collapse">
            <i class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left"
               data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>
    </div>
    <!-- header -->
    <div class="main-content">
        <form action="<c:url value='/admin-products'/>" method="GET" id="formSubmit">
            <div class="main-content-inner">
                <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="ace-icon fa fa-home home-icon"></i>
                            <a href="#">Trang chủ</a>
                        </li>
                    </ul><!-- /.breadcrumb -->
                </div>

                <div class="page-content">
                    <div class="row">
                        <div class="col-xs-12">
                            <form id="submitForm">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Ten</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-group" id="name" name="name"
                                               value="${MODEL.name}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Mo ta</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-group" id="descrip" name="descrip"
                                               value="${MODEL.descrip}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Chi tiet</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-group" id="details" name="details"
                                               value="${MODEL.details}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Gia</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-group" id="price" name="price"
                                               value="${MODEL.price}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Sale</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-group" id="discount" name="discount"
                                               value="${MODEL.discount}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Hieu</label>
                                    <div class="col-sm-9">
                                        <select class="form-group" name="brand" id="brand">
                                            <c:if test="${empty MODEL.brand}">
                                                <option>Chon hang</option>
                                                <c:forEach var="i" items="${Brands}">
                                                    <option value="${i.name}">${i.name}</option>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${not empty MODEL.brand}">
                                                <c:forEach var="i" items="${Brands}">
                                                    <c:if test="${i.name == MODEL.brand}">
                                                        <option value="${i.name}" selected="selected">${i.name}</option>
                                                    </c:if>
                                                    <c:if test="${i.name != MODEL.brand}">
                                                        <option value="${i.name}">${i.name}</option>
                                                    </c:if>
                                                </c:forEach>

                                            </c:if>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Ghi chu</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-group" id="note" name="note" value=""/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <c:if test="${not empty MODEL.id}">
                                            <input type="button" class="btn btn-white btn-warning btn-bold"
                                                   value="Cap nhat" id="btnAddOrUpdate"/>
                                        </c:if>
                                        <c:if test="${empty MODEL.id}">
                                            <input type="button" class="btn btn-white btn-warning btn-bold"
                                                   value="Them moi" id="btnAddOrUpdate"/>
                                        </c:if>
                                    </div>
                                </div>
                                <input type="hidden" id="id" name="id" value="${MODEL.id}">
                            </form>

                        </div>
                    </div>
                </div>
            </div>
            <!-- /.main-content -->
        </form>
    </div>
    <!-- footer -->


    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse display">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div>
<script>
    $('#btnAddOrUpdate').click(function (e) {
        e.preventDefault();
        let data = {};
        let formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data['' + v.name + ''] = v.value;
        });
        let id = $('#id').val();
        if (id == '') {
            addProduct(data);
        } else {

            updateProduct(data);
        }

        function addProduct(data) {
            $.ajax({
                url: '${APIurl}',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                sucess: function (result) {
                    alert("Sucess");
                },
                error: function (error) {
                    alert("Fail")
                }
            });
        }

        function updateProduct(data) {
            $.ajax({
                    url: '${APIurl}',
                    type: 'PUT',
                    contentType: 'application/json',
                    data: JSON.stringify(data),
                    dataType: 'json',
                    sucess: function (result) {
                        alert("Sucess");
                    },
                    error: function (error) {
                        alert("Fail");
                    }
                }
            );
        }
    });
</script>

<script src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>
<!-- page specific plugin scripts -->
<script src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
</body>
</html>