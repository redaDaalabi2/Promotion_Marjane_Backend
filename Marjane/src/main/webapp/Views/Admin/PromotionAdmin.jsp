<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="flex">
    <jsp:include page="./SidebarAdmin.jsp" />
    <section class="w-4/5 ml-auto h-screen bg-gray-200">
        <div class="w-full flex justify-center">
            <div class="w-full bg-white p-5 rounded-lg mt-8 mx-8">
                <h1 class="text-center pb-2 pt-1 text-xl font-medium">Create Promotion</h1>
<%--                <% int produit_id = Integer.valueOf(request.getParameter("id")); %>--%>
                <form
                        action="../../../CreatePromotionServlet.DashboardAdminServlet?produit_id=<%=request.getParameter("id")%>"
                        method="post"
                        class="flex flex-col space-y-5"
                >
                    <div class="flex space-y-2 gap-4">
                        <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
                        <input
                                required
                                type="number"
                                name="taux"
                                placeholder="Entre your taux"
                                class="block w-full px-4 py-2 mt-2 bg-white border rounded-md focus:border-blue-400 focus:ring-blue-300 focus:outline-none focus:ring focus:ring-opacity-40"
                        />
                        <input
                                required
                                type="number"
                                name="points_fidelite"
                                placeholder="Entre your points de fidelite"
                                class="block w-full px-4 py-2 mt-2 bg-white border rounded-md focus:border-blue-400 focus:ring-blue-300 focus:outline-none focus:ring focus:ring-opacity-40"
                        />
                    </div>
                    <div class="flex gap-4 w-full">
                        <div class="flex flex-col gap-4 w-1/2">
                            <label class="block text-gray-700 text-sm font-bold">
                                Date de fin
                            </label>
                            <input
                                    required
                                    type="date"
                                    name="date_fin"
                                    placeholder="Entre your date de fin"
                                    class="block w-full px-4 py-2 mt-2 bg-white border rounded-md focus:border-blue-400 focus:ring-blue-300 focus:outline-none focus:ring focus:ring-opacity-40"
                            />
                        </div>
                    </div>
                    <div class="w-3/6 flex justify-center">
                        <button
                                type="submit"
                                class="mt-2 mx-auto shadow bg-blue-500 hover:bg-blue-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded py-4 w-full"
                        >
                            Create
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>
