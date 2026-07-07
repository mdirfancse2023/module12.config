package june.module12.inventory.controller;

import june.module12.inventory.entity.Inventory;
import june.module12.inventory.repository.InventoryRepo;
import june.module12.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService service;
    private final InventoryRepo repo;

    @PostMapping
    public Inventory addProduct(@RequestBody Inventory inventory){
        return repo.save(inventory);
    }

    @PostMapping("/reduce")
    public String reduceStock(@RequestParam Long productId, @RequestParam Integer qty){
        boolean result = service.reduceStock(productId,qty);
        return result ? "Stock Reduced" : "Insufficient Stock";
    }

    @PostMapping("/restock")
    public String restock(@RequestParam Long productId, @RequestParam Integer qty){
        service.restock(productId,qty);
        return "Restocked";
    }

    @GetMapping("/test")
    public String test() {
        return "Inventory Service Working";
    }
}
