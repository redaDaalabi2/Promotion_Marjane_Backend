<jsp:include page="../Global/Header.jsp"></jsp:include>
<section class="flex pb-16 w-full">
  <form action="AdminLoginServlet" method="POST" class="mx-auto w-6/12 m-auto mt-16 text-center">
    <h1 class="font-bold tracking-wider text-3xl mb-8 w-full text-gray-600">
      Login Admin
    </h1>
    <div class="mb-3 flex justify-center">
      <input
              required
              type="email"
              class="block w-full px-4 py-2 mt-2 bg-white border rounded-md focus:border-blue-400 focus:ring-blue-300 focus:outline-none focus:ring focus:ring-opacity-40"
              placeholder="Adresse email"
              name="email"
      />
    </div>
    <div class="mb-3 flex justify-center">
      <input
              required
              type="password"
              class="block w-full px-4 py-2 mt-2 bg-white border rounded-md focus:border-blue-400 focus:ring-blue-300 focus:outline-none focus:ring focus:ring-opacity-40"
              placeholder="Mot de passe"
              name="password"
      />
    </div>
    <div class="flex justify-between my-4 w-75">
      <div>
        <input type="checkbox" checked class="checkbox" />
        <label class="checkbox-wrap checkbox-primary mb-0"
        >Remember me
          <span class="checkmark"></span>
        </label>
      </div>
      <div>
        <a href="#" class="hover:underline text-red-600"
        >Forgot Password</a
        >
      </div>
    </div>
    <div class="form-group flex justify-center">
      <button
              type="submit"
              class="mt-2 mx-auto shadow bg-blue-500 hover:bg-blue-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded py-4 w-full"
      >
        Connexion
      </button>
    </div>
  </form>
</section>
<jsp:include page="../Global/Footer.jsp"></jsp:include>
