package june.module12.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "module12.inventory")
public interface InventoryClient {
    @PostMapping("/inventory/reduce")
    String reduceStock(@RequestParam Long productId, @RequestParam Integer qty);

    @PostMapping("/inventory/restock")
    String restock(@RequestParam Long productId, @RequestParam Integer qty);
}
