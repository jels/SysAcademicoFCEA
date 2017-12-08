<%-- 
    Document   : ejemplo
    Created on : 07-dic-2017, 16:25:50
    Author     : ROBERTO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="../../bootstrap/css/dataTables.bootstrap.css" rel="stylesheet">

        <script src="../../bootstrap/js/jquery.js"></script>
        <script src="../../bootstrap/js/bootstrap.min.js"></script>

    </head>
    <body>
        <div class="panel-heading">Lista de Egresados </div>
        <table id="egresados" class="display">
            <thead>
                <tr>                                    
                    <th>Cod Univ</th>
                    <th>Nombre</th>                                    
                    <th>Paterno</th>
                    <th>Materno</th>
                    <th>Email</th>
                    <th>Mat Apro</th>
                    <th>Mat Repro</th>

                    <th>Materias Pasando</th>
                    <th>Plan</th>                                                                                                
                    <th>Egre</th> 
                    <th>Ingreso Anterior</th> 
                    <th>G I Anterior</th> 
                    <th>Ingreso</th> 
                    <th>Egreso</th> 
                    <th>G Ingreso</th> 
                    <th>G Egreso</th> 

                </tr>
            </thead>
            <tbody>

                <tr>

                    <td>650004612
                    </td>                                                  
                    <td>José Manuel
                    </td>
                    <td>MENECES
                    </td>
                    <td>ARISPE
                    </td>   
                    <td>meneces_ad17@hotmail.com
                    </td>
                    <td>
                        <a href="#" class="edit-record" data-id="S1329938325496#10101-2012-1#1">
                            0
                        </a></td>
                    <td>                             
                        <a href="#" class="edit-record" data-id="S1329938325496#10101-2012-1#2">0
                        </a>
                    </td>
                    <td>0</td>
                    <td>62
                    </td>                                                       
                    <td>NO
                    </td>
                    <td></td>
                    <td> iNGREI </td>
                    <td>22/02/2012
                    </td>
                    <td>null
                    </td>
                    <td>null
                    </td>
                    <td>null
                    </td>

                </tr>

                <tr>

                    <td>650004674
                    </td>                                                  
                    <td>Luis Walter
                    </td>
                    <td>GUMUCIO
                    </td>
                    <td>FLORES
                    </td>   
                    <td>brarkfail@gmail.com
                    </td>
                    <td>
                        <a href="#" class="edit-record" data-id="S1234774972594-I#10101-2012-1#1">
                            62
                        </a></td>
                    <td>                             
                        <a href="#" class="edit-record" data-id="S1234774972594-I#10101-2012-1#2">8
                        </a>
                    </td>
                    <td>0</td>
                    <td>62
                    </td>                                                       
                    <td>SI
                    </td>
                    <td>14/02/2009
                    </td>
                    <td> iNGREI </td>
                    <td>20/07/2009
                    </td>
                    <td>04/07/2016
                    </td>
                    <td>2009-1
                    </td>
                    <td>2016-1
                    </td>

                </tr>

                <tr>

                    <td>650004663
                    </td>                                                  
                    <td>Juan Carlos
                    </td>
                    <td>QUISPE
                    </td>
                    <td>CALLISAYA
                    </td>   
                    <td>jhoncharlies_666@hotmail.com
                    </td>
                    <td>
                        <a href="#" class="edit-record" data-id="S1279636940045-I#10101-2012-1#1">
                            28
                        </a></td>
                    <td>                             
                        <a href="#" class="edit-record" data-id="S1279636940045-I#10101-2012-1#2">27
                        </a>
                    </td>
                    <td>0</td>
                    <td>62
                    </td>                                                       
                    <td>NO
                    </td>
                    <td>20/07/2009
                    </td>
                    <td> iNGREI </td>
                    <td>20/07/2009
                    </td>
                    <td>30/06/2014
                    </td>
                    <td>2010-2
                    </td>
                    <td>2014-1
                    </td>

                </tr>

                <tr>

                    <td>650004621
                    </td>                                                  
                    <td>Leny
                    </td>
                    <td>BARRIOS
                    </td>
                    <td>CESPEDES
                    </td>   
                    <td>inel_18@hotmail.com
                    </td>
                    <td>
                        <a href="#" class="edit-record" data-id="S1298564312324-I#10101-2012-1#1">
                            62
                        </a></td>
                    <td>                             
                        <a href="#" class="edit-record" data-id="S1298564312324-I#10101-2012-1#2">13
                        </a>
                    </td>
                    <td>0</td>
                    <td>62
                    </td>                                                       
                    <td>SI
                    </td>
                    <td>20/07/2009
                    </td>
                    <td> iNGREI </td>
                    <td>20/07/2009
                    </td>
                    <td>19/12/2016
                    </td>
                    <td>2011-1
                    </td>
                    <td>2016-2
                    </td>

                </tr>

                <tr>

                    <td>650004635
                    </td>                                                  
                    <td>Belia Paola
                    </td>
                    <td>OJEDA
                    </td>
                    <td>ALIAGA
                    </td>   
                    <td>p.o.a.25@hotmail.com
                    </td>
                    <td>
                        <a href="#" class="edit-record" data-id="S1298645616753-I#10101-2012-1#1">
                            62
                        </a></td>
                    <td>                             
                        <a href="#" class="edit-record" data-id="S1298645616753-I#10101-2012-1#2">12
                        </a>
                    </td>
                    <td>0</td>
                    <td>62
                    </td>                                                       
                    <td>SI
                    </td>
                    <td>20/07/2009
                    </td>
                    <td> iNGREI </td>
                    <td>20/07/2009
                    </td>
                    <td>19/12/2016
                    </td>
                    <td>2011-1
                    </td>
                    <td>2016-2
                    </td>

                </tr>

                <tr>

                    <td>650004627
                    </td>                                                  
                    <td>Rolando Freddy
                    </td>
                    <td>FLORES
                    </td>
                    <td>MAMANI
                    </td>   
                    <td>freddy2042@hotmail.com
                    </td>
                    <td>
                        <a href="#" class="edit-record" data-id="S1299675672334-I#10101-2012-1#1">
                            5
                        </a></td>
                    <td>                             
                        <a href="#" class="edit-record" data-id="S1299675672334-I#10101-2012-1#2">11
                        </a>
                    </td>
                    <td>0</td>
                    <td>62
                    </td>                                                       
                    <td>NO
                    </td>
                    <td></td>
                    <td> iNGREI </td>
                    <td>20/07/2009
                    </td>
                    <td>11/12/2012
                    </td>
                    <td>2012-1
                    </td>
                    <td>2012-2
                    </td>

                </tr>
            </tbody>
        </table>

        <div class="modal fade" id="listadoreprobados" tabindex="-1" role="dialog" aria-labelledby="largeModal" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">Lista de Materias </h4>
                    </div>
                    <div class="modal-body"></div>

                </div>
            </div>
        </div>

        <script type="text/javascript" charset="utf-8">
            $(document).on('click', '.edit-record', function (e) {
                e.preventDefault();

                $('#listadoreprobados').modal('show');
                $(".modal-body").html('');
                $(".modal-body").addClass('loader');

                $.post('ejmeplo_modal.jsp',
                        {id: $(this).attr('data-id')},
                        function (html) {
                            $(".modal-body").removeClass('loader');
                            $(".modal-body").html(html);
                        }
                );
            });
        </script>
    </body>
</html>
