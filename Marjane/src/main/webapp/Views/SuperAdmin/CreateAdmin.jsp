<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="flex">
    <jsp:include page="../Global/Sidebar.jsp" />
    <section class="w-4/5 ml-auto h-screen bg-gray-200">
        <div class="w-full flex justify-center">
            <div class="w-full bg-white p-5 rounded-lg mt-8 mx-8">
                <h1 class="text-center pb-2 pt-1 text-xl font-medium">Create Admin</h1>
                <form
                    action="../../../CreateAdminServlet.DashboardSuperAdminServlet"
                    method="post"
                    class="flex flex-col space-y-5"
                >
                    <div class="flex space-y-2 gap-4">
                        <input
                                required
                                type="text"
                                name="nom"
                                placeholder="Entre your nom"
                                class="block w-full px-4 py-2 mt-2 bg-white border rounded-md focus:border-blue-400 focus:ring-blue-300 focus:outline-none focus:ring focus:ring-opacity-40"
                        />
                        <input
                                required
                                type="text"
                                name="prenom"
                                placeholder="Entre your prenom"
                                class="block w-full px-4 py-2 mt-2 bg-white border rounded-md focus:border-blue-400 focus:ring-blue-300 focus:outline-none focus:ring focus:ring-opacity-40"
                        />
                    </div>
                    <div class="flex space-y-2 gap-4">
                        <input
                                required
                                type="email"
                                name="email"
                                placeholder="Entre your email"
                                class="block w-full px-4 py-2 mt-2 bg-white border rounded-md focus:border-blue-400 focus:ring-blue-300 focus:outline-none focus:ring focus:ring-opacity-40"
                        />
                        <input
                            required
                            type="password"
                            name="password"
                            placeholder="Entre your password"
                            class="block w-full px-4 py-2 mt-2 bg-white border rounded-md focus:border-blue-400 focus:ring-blue-300 focus:outline-none focus:ring focus:ring-opacity-40"
                        />
                    </div>
                    <div class="w-3/6 flex justify-center">
                        <select name="id_centre" class="block w-full px-4 py-2 mt-2 bg-white border rounded-md focus:border-blue-400 focus:ring-blue-300 focus:outline-none focus:ring focus:ring-opacity-40">
                            <option selected >Choisir un centre</option>
                            <c:forEach items="${centres}" var="centre">
                                <option value="${centre.idCentre}">${centre.nomCentre}</option>
                            </c:forEach>
                        </select>
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