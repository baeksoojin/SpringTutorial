package tutorial.itemservice.domain;

import lombok.Data;

@Data //다만 불필요한것까지 다 만들어서 위험함(원래는 주의할 필요가있음)
public class Item {

    private long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item(){
    }

    public Item( String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }


}
