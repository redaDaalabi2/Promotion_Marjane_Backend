<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Global/Sidebar.jsp" />
<!--Container-->
<div style="width: 80%; margin-left: auto;" class="px-2">
    <!--Title-->
    <h1 class="flex items-center font-sans font-bold break-normal text-indigo-500 px-2 py-8 text-xl md:text-2xl">
        Les centre disponible
    </h1>
    <!--Card-->
    <div id='recipients' class="p-8 mt-6 lg:mt-0 rounded shadow bg-white">
        <table id="example" class="stripe hover" style="width:100%; padding-top: 1em;  padding-bottom: 1em;">
            <thead>
            <tr>
                <th data-priority="1">Id</th>
                <th data-priority="2">Nom</th>
                <th data-priority="3">Ville</th>
                <th data-priority="4">Created at</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${centres}" var="centre">
                    <tr>
                        <td class="text-center">
                            ${centre.idCentre}
                        </td>
                        <td class="text-center">
                            ${centre.nomCentre}
                        </td>
                        <td class="text-center">
                            ${centre.villeCentre}
                        </td>
                        <td class="text-center">
                            ${centre.createdAt}
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <!--/Card-->
</div>
<!--/container-->
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!--Datatables -->
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>
<script>
    $(document).ready(function() {

        var table = $('#example').DataTable({
            responsive: true
        })
            .columns.adjust()
            .responsive.recalc();
    });
</script>
