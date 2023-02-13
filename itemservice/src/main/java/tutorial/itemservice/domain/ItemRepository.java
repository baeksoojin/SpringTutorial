package tutorial.itemservice.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository //component scan의 대상이됨
public class ItemRepository {

    private static final Map<Long, Item> store = new ConcurrentHashMap<>();//실제로는 동기처리가 안 돼서 hashmap을 사용하면 안 됨
    private static long sequence = 0L;

    //save
    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(),item);
        return item;
    }

    //find
    public Item findById(Long id){
        return store.get(id);
    }

    //findall
    public List<Item> findAll(){
        return new ArrayList<>(store.values()); // 한번 감싸서 반환하면 arraylist에 값을 넣어도 store를 건드리는게 아니여서 store에는 변화가 없어서 안전성을 유지
    }

    //update
    public void update(Long itemId, Item updateParam){ //사실 해당 경우에는 Item을 사용하는 것이 아닌 사용하지 않는 id를 제거한 parameter3개만 사용하도록 DTO를 만드는 것이 맞음
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore(){
        store.clear();
        //test에서 사용예정
    }

}
