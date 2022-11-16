<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Container-->
<div style="width: 80%; margin-left: auto;" class="px-2 w-4/5 ml-auto h-screen">
  <!--Title-->
  <h1 class="flex items-center font-sans font-bold break-normal text-indigo-500 px-2 py-8 text-xl md:text-2xl">
    All Categories
  </h1>
  <!--Card-->
  <div id='recipients' class="p-8 mt-6 lg:mt-0 rounded shadow bg-white">
    <table id="example" class="stripe hover" style="width:100%; padding-top: 1em;  padding-bottom: 1em;">
      <thead>
      <tr>
        <th data-priority="1">Id</th>
        <th data-priority="2">Nom</th>
        <th data-priority="3">Created at</th>
        <th data-priority="4">Updated at</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${categories}" var="categorie">
        <tr>
          <td class="text-center">
              ${categorie.idCategorie}
          </td>
          <td class="text-center">
              ${categorie.nomCategorie}
          </td>
          <td class="text-center">
              ${categorie.createdAt}
          </td>
          <td class="text-center">
              ${categorie.updatedAt}
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