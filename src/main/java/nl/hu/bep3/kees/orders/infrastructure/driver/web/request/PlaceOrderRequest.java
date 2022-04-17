package nl.hu.bep3.kees.orders.infrastructure.driver.web.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class PlaceOrderRequest {
    @NotBlank
    public String customerName;

    @NotBlank
    public String customerSurname;

    @NotBlank
    public String comment;

    @NotNull
    public ArrayList<String> meals;

}
