<%@ page import="Entity.Categorie" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Container-->
<div style="width: 80%; margin-left: auto;" class="px-2">
    <!--Title-->
    <h1 class="flex items-center font-sans font-bold break-normal text-indigo-500 px-2 py-8 text-xl md:text-2xl">
        All promotions
    </h1>
    <!--Card-->
    <div id='recipients' class="p-8 mt-6 lg:mt-0 rounded shadow bg-white">
        <table id="example" class="stripe hover" style="width:100%; padding-top: 1em;  padding-bottom: 1em;">
            <thead>
            <tr>
                <th data-priority="1">Id</th>
                <th data-priority="2">produit</th>
                <th data-priority="3">Categorie</th>
                <th data-priority="4">Taux</th>
                <th data-priority="5">Point de fidelite</th>
                <th data-priority="6">Status</th>
                <th data-priority="7">Date de debut</th>
                <th data-priority="8">Date de fin</th>
                <th data-priority="9">Created at</th>
                <th data-priority="10">Updated at</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${promotions}" var="promotion">
                <tr>
                    <td class="text-center">
                        ${promotion.id}
                    </td>
                    <td class="text-center">
                        ${promotion.produitByProduitId.nomProduit}
                    </td>
                    <td class="text-center">
                        ${promotion.produitByProduitId.categorieByCategorieId.nomCategorie}
                    </td>
                    <td class="text-center">
                        ${promotion.taux}
                    </td>
                    <td class="text-center">
                        ${promotion.points_fidelite}
                    </td>
                    <td class="text-center">
                        <c:if test="${promotion.status.equals('Encours')}">
                            <span class="bg-gray-200 font-bold text-black-600 py-1 px-3 rounded-full text-xs">Encours</span>
                        </c:if>
                        <c:if test="${promotion.status.equals('Accepter')}">
                            <span class="bg-green-200 font-bold text-black-600 py-1 px-3 rounded-full text-xs">Accepter</span>
                        </c:if>
                        <c:if test="${promotion.status.equals('Refuser')}">
                            <span class="bg-red-200 font-bold text-black-600 py-1 px-3 rounded-full text-xs">Refuser</span>
                        </c:if>
                    </td>
                    <td class="text-center">
                        ${promotion.date_debut}
                    </td>
                    <td class="text-center">
                        ${promotion.date_fin}
                    </td>
                    <td class="text-center">
                        ${promotion.createdAt}
                    </td>
                    <td class="text-center">
                        ${promotion.updatedAt}
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