//public class Shop {
//    private List<Order> orderList = new ArrayList<>();
//    private List<Product> productList = new ArrayList<>();
//    private Map<Integer, Order> orderMap = new HashMap<>();
//    private Map<String, Product> productMap = new HashMap<>();
//
//    /**
//     * constructor
//     */
//    public Shop() {
//    }
//
//    /**
//     * toode lisatakse poodi. Kui täpselt sama instants on juba poes olemas, tagastab false.
//     * Kõikidel muudel juhtudel lisab toote poodi ja tagastab true.
//     *
//     * @param product product
//     * @return boolean
//     */
//    public boolean addProduct(Product product) {
//        if (!productList.contains(product)) {
//            productList.add(product);
//            productMap.put(product.getName(), product);
//            return true;
//        }
//        return false;
//    }
//
//
//    /**
//     * loob uue tellimuse ja tagastab selle numbri. Tellimuse numbrid on järjest täisarvud alates 1-st.
//     * Ehk siis esimene tellimus on numbriga 1, teine tellimus numbriga 2 jne. Ülesande jaoks võite luua eraldi klassi
//     * Order, aga saab lahendada ka ilma selleta.
//     *
//     * @return num
//     */
//    public int createNewOrder() {
//        Order order = new Order();
//        orderList.add(order);
//        orderMap.put(order.getOrderId(), order);
//        return order.getOrderId();
//    }
//
//    /**
//     * lisab toote tellimusse. Kui sellise numbriga tellimust ei ole, tagastab false.
//     * Kui sellise nimega (täpne vaste) toode on olemas ja ei ole mõnes teises tellimuses, siis lisatakse kõige
//     * odavam selle nimega toode tellimusse ja tagastab true. Kui toode on lisatud ühte tellimusse, siis seda
//     * enam teise tellimusse lisada ei saa. Kui sellise nimega toodet ei ole (või kõik on juba mõnes tellimuses),
//     * siis tagastab false. Kui tellimus on tühistatud (vt. altpoolt), siis toodet ei lisata ja tagastab false
//     *
//     * @param orderNumber order number
//     * @param itemName    item name
//     * @return boolean
//     */
//    public boolean addProductToOrder(int orderNumber, String itemName) {
//        if (!orderMap.containsKey(orderNumber)) {
//            return false;
//        } else if (productMap.get(itemName).isInUse()) {
//            return false;
//        } else if (orderMap.get(orderNumber).isOrderCancellation()) {
//            return false;
//        } else {
//            Product cheapestProduct = productList.stream()
//                    .sorted(Comparator.comparingInt(Product::getPrice))
//                    .findFirst().get();
//            orderMap.get(orderNumber).addProduct(cheapestProduct);
//            productMap.get(itemName).setInUse(true);
//            return true;
//        }
//    }
//
//    /**
//     * tagastab tellimuse kogusumma (toodete hindade summa). Kui sellise tellimust pole, tagastab -1.
//     * Tühja tellimuse kogusumma on 0.
//     *
//     * @param orderNumber order number
//     * @return number;
//     */
//    public int getOrderSum(int orderNumber) {
//        if (!orderMap.containsKey(orderNumber)) {
//            return -1;
//        } else {
//            return orderMap.get(orderNumber).getProductsSum();
//        }
//    }
//
//    /**
//     * tellimus tühistatakse. Kui sellist tellimust ei ole või see on juba tühistatud, tagastab false.
//     * Muul juhul tehakse tellimus tühjaks (selle toodete hulk saab tühjaks ja kogusumma muutub 0-ks)
//     * ja tagastatakse true. Kõik tooted, mis olid tühistatud tellimuses, on poes jälle kättesaadavad.
//     * Tühistatud tellimusse ei saa enam tooteid lisada.
//     *
//     * @param orderNumber order number
//     * @return boolean
//     */
//    public boolean cancelOrder(int orderNumber) {
//        if (!orderMap.containsKey(orderNumber) || orderMap.get(orderNumber).isOrderCancellation()) {
//            return false;
//        } else {
//            orderMap.get(orderNumber).cancelOrder(this);
//            return true;
//        }
//
//    }
//
//    /**
//     * tagastab kõik poes saada olevad tooted Listina
//     *
//     * @return
//     */
//    public List<Product> getAvailableProducts() {
//        return productList;
//    }
//
//
//}
