//public class Order {
//    private int orderId;
//    private boolean orderCancellation = false;
//    private List<Product> productList = new ArrayList<>();
//    private static int nextFreeOrder = 0;
//
//    /
//            * constructor
//     */
//    public Order() {
//        this.orderId = ++nextFreeOrder;
//    }
//
//    /
//            * add new product to order
//     *
//             * @param product product
//     */
//    public void addProduct(Product product) {
//        productList.add(product);
//    }
//
//    /
//            * order id getter
//     *
//             * @return id
//     */
//    public int getOrderId() {
//        return orderId;
//    }
//
//    /
//            * calcel getter
//     *
//             * @return boolean
//     */
//    public boolean isOrderCancellation() {
//        return orderCancellation;
//    }
//
//
//    /
//            * calcel setter
//     *
//             * @param orderCancellation boolean
//     */
//    public void setOrderCancellation(boolean orderCancellation) {
//        this.orderCancellation = orderCancellation;
//    }
//
//    /
//            * product list getter
//     *
//             * @return list
//     */
//    public List<Product> getProductList() {
//        return productList;
//    }
//
//    /
//            * get sum of all products
//     *
//             * @return sum
//     */
//    public int getProductsSum() {
//        return productList.stream()
//                .mapToInt(p -> p.getPrice())
//                .sum();
//    }
//
//    /
//            * ,ethod cancel order
//     *
//             * @param shop shop
//     */
//    public void cancelOrder(Shop shop) {
//        setOrderCancellation(true);
//        productList.forEach(product -> product.setInUse(false));
//        productList.clear();
//
//    }
//}
//public class Product {
//    private String name;
//    private int price;
//    private boolean inUse = false;
//
//    /
//            * constructor
//     *
//             * @param name  name
//     * @param price price
//     */
//    public Product(String name, int price) {
//        this.name = name;
//        this.price = price;
//    }
//
//    /
//            * name getter
//     *
//             * @return name
//     */
//    public String getName() {
//        return name;
//    }
//
//    /
//            * name setter
//     *
//             * @param name name
//     */
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    /
//            * price getter
//     *
//             * @return price
//     */
//    public int getPrice() {
//        return price;
//    }
//
//    /
//            * price setter
//     *
//             * @param price price
//     */
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    /
//            * in use getter
//     *
//             * @return boolean
//     */
//    public boolean isInUse() {
//        return inUse;
//    }
//
//    /**
//     * in use setter
//     *
//     * @param inUse boolean
//     */
//    public void setInUse(boolean inUse) {
//        this.inUse = inUse;
//    }
//}