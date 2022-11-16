<jsp:include page="Global/Header.jsp"></jsp:include>
<section class="pt-4 pb-8 w-full flex justify-center items-center flex-col">
    <div class="w-2/4">
        <label class="text-center block mb-4 text-base font-bold py-10 text-gray-900 dark:text-gray-400">Login As</label>
        <div class="flex flex-wrap justify-between items-center">
            <a href="../../SuperAdminLoginServlet" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">
                Super Admin
            </a>
            <a href="../../AdminLoginServlet" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">
                Admin
            </a>
            <a href="../../ResponsapleRayonLoginServlet" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">
                Responsable de Rayon
            </a>
        </div>
    </div>
</section>
<jsp:include page="Global/Footer.jsp"></jsp:include>