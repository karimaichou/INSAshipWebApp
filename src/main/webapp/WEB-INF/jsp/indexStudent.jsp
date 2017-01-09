
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26/11/2016
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Portfolio - Responsive 'Flat Profile' HTML Portfolio Template</title>
<link href="${pageContext.request.contextPath}/resources/styles/css/demo.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/css/bootstrap-responsive.css">
<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,600' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/css/jquery.fancybox.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/font-awesome/css/font-awesome.min.css">

<div class="container topbottom">
    <div class="row-fluid">

        <div class="span5">
            <img src="${pageContext.request.contextPath}/resources/styles/img/avatar.jpg" alt="Profile Avatar" class="avatar">

            <div class="navigation">
                <div>
                    <ul>
                        <li>
                            <img src="${pageContext.request.contextPath}/resources/styles/img/about-icon.png">
                            <a href="#">About Me</a>
                        </li>
                        <li>
                            <img src="${pageContext.request.contextPath}/resources/styles/img/portfolio-icon.png">
                            <a href="#">Profil Management</a>
                        </li>
                        <li>
                            <img src="${pageContext.request.contextPath}/resources/styles/img/followme-icon.png">
                            <a href="#">Notification</a>
                        </li>
                        <li>
                            <img src="${pageContext.request.contextPath}/resources/styles/img/followme-icon.png">
                            <a href="#">Internship Agreement</a>
                        </li>
                        <li>
                            <img src="${pageContext.request.contextPath}/resources/styles/img/portfolio-icon.png">
                            <a href="#">Applications</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="span7 homeabout">
            <div class="person">
                <span class="name">AZZAM Chaimaa</span><!-- first name and last name -->
                <div class="font16">Student at insa Toulouse <span class="greentext"><a href="#">insa.fr</a></span></div>
            </div>
            <div class="desciption home">

                <p>Adress : <span class="rotate greentext">86 AVENUE SAINT EXUPERY</span></p>
                <p>Telephone : <span class="rotate greentext">0788193060</span>
                <p>Email : <span class="rotate greentext">c.azzam@uhp.ac.ma</span></p>
                <p>Date d'inscription: <span class="rotate greentext">08/01/2017</span></p>
                <p>Date de naissance : <span class="rotate greentext">17/12/1994</span></p>
                <p>CV: </p><span class="rotate greentext"><a href="#">CV.pdf</a></span>
                <p>Lettre de motivation: </p><span class="rotate greentext"><a href="#">LM.pdf</a></span>


            </div>
            <div class="row">
                <div class="span6">
                    <div class="bars">
                        <div id="bar-1">
                        </div>
                        <div id="bar-2">
                        </div>
                        <div id="bar-3">
                        </div>
                        <div id="bar-4">
                        </div>

                    </div>
                </div>
                <div class="span6">
                    <div class="user-tip"><img src="${pageContext.request.contextPath}/resources/styles/img/img-tip.png" alt="" /></div>
                    <div id="bars-content">
                        <div  class="content" id="content-1">No description</div>
                    </div>
                </div>
            </div>

        </div>

    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/styles/js/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/styles/js/jqbar.js" type="text/javascript"></script>

<script type="text/javascript">
    $(document).ready(function () {

        $('#bar-1').jqbar({ label: 'HTML5', value: 80, barColor: '#21ba82' });

        $('#bar-2').jqbar({ label: 'CSS', value: 99, barColor: '#21ba82' });

        $('#bar-3').jqbar({ label: 'JavaScript', value: 85, barColor: '#21ba82' });

        $('#bar-4').jqbar({ label: 'WordPress', value: 75, barColor: '#21ba82' });



        $('#bars-content .content').css({'opacity':'0',display:'none'});
        $('#bars-content .content:eq(0)').css('display','block').animate({opacity:1},1000);
        $('.jqbar:first').addClass('active');
        $('.jqbar').hover(function(){ $(this).addClass('hover');},function(){ $(this).removeClass('hover');});
        $('.jqbar').click(function(){
            $('.jqbar').removeClass('active');
            var id = $(this).addClass('active').attr('id').replace('bar','content');
            $('#bars-content .content').css({'opacity':'0',display:'none'});
            $('#' + id).css('display','block').animate({opacity:1},1000);

        });

        $(".rotate").textrotator({
            animation: "spin",
            separator: ",",
            speed: 2000
        });


    });

</script>
<script type="text/javascript" src="/${pageContext.request.contextPath}/resources/styles/js/jquery.simple-text-rotator.min.js"></script>
