package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {

    private Map<ShoppingItem, Integer> itens = new LinkedHashMap<ShoppingItem, Integer>();

    public void add(ShoppingItem item) {
        itens.put(item, getQuantity(item) + 1);
    }

    public Integer getQuantity(ShoppingItem item) {
        if (!itens.containsKey(item)) {
            itens.put(item, 0);
        }
        return itens.get(item);
    }

    public Integer getQuantity() {
        return itens.values().stream()
                .reduce(0, (next, accumulator) -> next + accumulator);
    }

    public Collection<ShoppingItem> getList() {
        return itens.keySet();
    }

    public BigDecimal getTotal(ShoppingItem item) {
        return item.getTotal(getQuantity(item));
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        //TODO change to reduce?
        for (ShoppingItem item : itens.keySet()) {
            total = total.add(getTotal(item));
        }
        return total;
    }

    public void remove(ShoppingItem shoppingItem) {
        itens.remove(shoppingItem);
    }

    public boolean isEmpty() {
        return itens.isEmpty();
    }

}
