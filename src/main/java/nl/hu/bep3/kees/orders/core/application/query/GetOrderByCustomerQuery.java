package nl.hu.bep3.kees.orders.core.application.query;

public class GetOrderByCustomerQuery {
    private final String customer;

    public GetOrderByCustomerQuery(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }
}
