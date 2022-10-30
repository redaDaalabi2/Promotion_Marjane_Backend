public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        //ProduitRepo.CreateProduit("Cherler", 6, 100.00, 7);
        /*List<Produit> produits = ProduitRepo.getAllProduits();
        produits.stream().forEach(produit -> {
            System.out.println(produit.getIdProduit());
            System.out.println(produit.getNomProduit());
            System.out.println(produit.getQuantite());
            System.out.println(produit.getPrix());
            System.out.println(produit.getCategorieId());
            System.out.println(produit.getCreatedAt());
            System.out.println(produit.getUpdatedAt());
        });*/
        //ProduitRepo.DeleteProduit(4);
        /*ProduitRepo.getProduitById(4).ifPresent(produit -> {
            System.out.println(produit.getIdProduit());
            System.out.println(produit.getNomProduit());
            System.out.println(produit.getQuantite());
            System.out.println(produit.getPrix());
            System.out.println(produit.getCategorieId());
            System.out.println(produit.getCreatedAt());
            System.out.println(produit.getUpdatedAt());
        });*/
    }
}
