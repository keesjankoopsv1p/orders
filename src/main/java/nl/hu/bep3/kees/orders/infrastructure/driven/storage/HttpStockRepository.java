package nl.hu.bep3.kees.orders.infrastructure.driven.storage;

import nl.hu.bep3.kees.orders.core.ports.storage.StockRepository;
import nl.hu.bep3.kees.orders.infrastructure.driven.storage.result.IngredientResult;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HttpStockRepository implements StockRepository {
    private final String rootPath;
    private final RestTemplate client;

    public HttpStockRepository(String rootPath, RestTemplate client) {
        this.rootPath = rootPath;
        this.client = client;
    }

    @Override
    public List<IngredientResult> getIngredientsQuantityByMeal(String id){
        URI uri = URI.create(this.rootPath + "/ingredients/meal/" + id);
        IngredientResult[] result = this.client.getForObject(uri, IngredientResult[].class);

        if (result == null) {
            return new ArrayList<>();
        }
        return Arrays.stream(result).map(temp -> {
            IngredientResult resp = new IngredientResult();
            resp.id = temp.id;
            resp.quantity = temp.quantity;
            return resp;
        }).collect(Collectors.toList());
    }
}
